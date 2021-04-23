package com.github.carlcidromero.project1.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
      while(resultSet.next()) {
        Vibe vibe = new Vibe();
        vibe.setId(resultSet.getInt("id"));
        vibe.setSoulId(resultSet.getInt("soul_id"));
        vibe.setTldr(resultSet.getString("tldr"));
        vibe.setPurpose(resultSet.getString("purpose"));
        vibes.add(vibe);
      }
      LOGGER.info("successfully executed database query");
    } catch(SQLException e) {
      LOGGER.error("error while executing database query: " + e.getMessage());
      e.printStackTrace();
    }
    return vibes;
  }

  @Override
  public void send(Vibe vibe) {
    
    try {
      LOGGER.info("executing database insert");
      PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO vibe (tldr, soul_id, purpose) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, vibe.getTldr());
      preparedStatement.setInt(2, vibe.getSoulId());
      preparedStatement.setString(3, vibe.getPurpose());
      preparedStatement.execute();
      ResultSet resultSet = preparedStatement.getGeneratedKeys();
      if(resultSet.next()) {
        vibe.setId(resultSet.getInt(1));
      }
      LOGGER.info("successfully executed database insert");
    } catch(SQLException e) {
      LOGGER.error("error while executing database insert: " + e.getMessage());
      e.printStackTrace();
    }
    
    
  }



}
