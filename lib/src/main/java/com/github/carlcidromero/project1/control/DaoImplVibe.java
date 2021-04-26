package com.github.carlcidromero.project1.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.carlcidromero.project1.control.dao.DaoVibe;
import com.github.carlcidromero.project1.model.Vibe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DaoImplVibe implements DaoVibe {

  private static final Logger LOGGER = LogManager.getLogger(DaoImplVibe.class.getName());

  Connection connection;

  public DaoImplVibe(Connection connection) {
    this.connection = connection;
  }

  @Override
  public List<Vibe> feelAll() {

    List<Vibe> vibes = new ArrayList<>();

    try {
      LOGGER.info("executing database query");
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM vibe");
      while (resultSet.next()) {
        Vibe vibe = new Vibe();
        vibe.setVibeId(resultSet.getInt("vibeId"));
        vibe.setVibeSoulId(resultSet.getInt("vibeSoulId"));
        vibe.setVibeTldr(resultSet.getString("vibeTldr"));
        vibe.setVibePurpose(resultSet.getString("vibePurpose"));
        vibes.add(vibe);
      }
      LOGGER.info("successfully executed database query");
    } catch (SQLException e) {
      LOGGER.error("error while executing database query: " + e.getMessage());
      e.printStackTrace();
    }
    return vibes;
  }

  @Override
  public void send(Vibe vibe) {

    try {
      LOGGER.info("executing database insert");
      PreparedStatement preparedStatement = connection.prepareStatement(
          "INSERT INTO vibe (vibeTldr, vibeSoulId, vibePurpose) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, vibe.getVibeTldr());
      preparedStatement.setInt(2, vibe.getVibeSoulId());
      preparedStatement.setString(3, vibe.getVibePurpose());
      preparedStatement.execute();
      ResultSet resultSet = preparedStatement.getGeneratedKeys();
      if (resultSet.next()) {
        vibe.setVibeId(resultSet.getInt(1));
      }
      LOGGER.info("successfully executed database insert");
    } catch (SQLException e) {
      LOGGER.error("error while executing database insert: " + e.getMessage());
      e.printStackTrace();
    }

  }

  @Override
  public void cancel(Vibe vibe) {

    try {
      LOGGER.info("executing database delete");
      PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM vibe WHERE vibeId = ?");
      preparedStatement.setInt(1, vibe.getVibeId());
      preparedStatement.execute();
      LOGGER.info("successfully executed database delete");
    } catch (SQLException e) {
      LOGGER.error("error while executing database delete: " + e.getMessage());
      e.printStackTrace();
    }

  }

  @Override
  public void change(int vibeId, String vibeTldr) {

    try {
      LOGGER.info("executing database update");
      PreparedStatement preparedStatement = connection.prepareStatement("UPDATE vibe SET vibeTldr = ? WHERE vibeId = ?");
      preparedStatement.setString(1, vibeTldr);
      preparedStatement.setInt(2, vibeId);
      preparedStatement.executeUpdate();
      LOGGER.info("successfully executed database update");
    } catch (SQLException e) {
      LOGGER.error("error executing database update: " + e.getMessage());
      e.printStackTrace();
    }

  }

}
