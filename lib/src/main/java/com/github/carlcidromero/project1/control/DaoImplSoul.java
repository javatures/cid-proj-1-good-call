package com.github.carlcidromero.project1.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.carlcidromero.project1.control.dao.DaoSoul;
import com.github.carlcidromero.project1.model.Soul;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DaoImplSoul implements DaoSoul {

  private static final Logger LOGGER = LogManager.getLogger(DaoImplThought.class.getName());
  
  Connection connection;

  public DaoImplSoul(Connection connection) {
    this.connection = connection;
  }

  @Override
  public List<Soul> observeAll() {
    
    List<Soul> souls = new ArrayList<>();

    try {
      LOGGER.info("executing database query");
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM soul");
      ResultSet resultSet = preparedStatement.executeQuery();
      while(resultSet.next()) {
        Soul soul = new Soul();
        soul.setSoulId(resultSet.getInt("soulId"));
        soul.setSoulName(resultSet.getString("soulName"));
        souls.add(soul);
      }
      LOGGER.info("successfully executed database query");
    } catch(SQLException e) {
      LOGGER.error("error while executing database query: " + e.getMessage());
      e.printStackTrace();
    }

    return souls;
  }

  @Override
  public void touch(Soul soul) {
    
    try {
      LOGGER.info("executing database insert");
      PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO soul (soulName) VALUES (?)", Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, soul.getSoulName());
      preparedStatement.execute();
      ResultSet resultSet = preparedStatement.getGeneratedKeys();
      if(resultSet.next()) {
        soul.setSoulId(resultSet.getInt(1));
      }
      LOGGER.info("successfully executed database insert");
    } catch(SQLException e) {
      LOGGER.error("error while executing database insert: " + e.getMessage());
      e.printStackTrace();
    }
  }

}
