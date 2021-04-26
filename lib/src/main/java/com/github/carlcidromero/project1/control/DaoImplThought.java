package com.github.carlcidromero.project1.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.carlcidromero.project1.control.dao.DaoThought;
import com.github.carlcidromero.project1.model.Thought;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DaoImplThought implements DaoThought {

  private static final Logger LOGGER = LogManager.getLogger(DaoImplThought.class.getName());

  Connection connection;

  public DaoImplThought(Connection connection) {
    this.connection = connection;
  }

  @Override
  public List<Thought> rememberAll() {

    List<Thought> thoughts = new ArrayList<>();
    Thought thought = null;

    try {
      LOGGER.info("executing database query");
      Statement statement = connection.createStatement(); 
      ResultSet resultSet = statement.executeQuery("SELECT * FROM thought");
      while(resultSet.next()) {
        thought = new Thought();
        thought.setThoughtId(resultSet.getInt("thoughtId"));
        thought.setThoughtTldr(resultSet.getString("thoughtTldr"));
        thought.setThoughtVibeId(resultSet.getInt("thoughtVibeId"));
        thought.setThoughtLocation(resultSet.getString("thoughtLocation"));
        thought.setThoughtFrame(resultSet.getString("thoughtFrame"));
        thoughts.add(thought);
      }
      LOGGER.info("successfully executed database query");
    } catch(SQLException e) {
      LOGGER.error("error while executing database query: " + e.getMessage());
      e.printStackTrace();
    }
    return thoughts;
  }

  @Override
  public void contemplate(Thought thought) {

    try {
      LOGGER.info("executing database insert");
      PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO thought (thoughtTldr, thoughtLocation, thoughtFrame) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, thought.getThoughtTldr());
      preparedStatement.setString(2, thought.getThoughtLocation());
      preparedStatement.setString(3, thought.getThoughtFrame());
      preparedStatement.execute();
      ResultSet resultSet = preparedStatement.getGeneratedKeys();
      if(resultSet.next()) {
        thought.setThoughtId(resultSet.getInt(1));
      }
      LOGGER.info("successfully executed database insert");
    } catch(SQLException e) {
      LOGGER.error("error while executing database insert: " + e.getMessage());
      e.printStackTrace();
    }
  }

  @Override
  public void forget(Thought thought) {
    
    try {
      LOGGER.info("executing database delete");
      PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM thought WHERE thoughtId = ?");
      preparedStatement.setInt(1, thought.getThoughtId());
      preparedStatement.execute();
      LOGGER.info("successfully executed database delete");
    } catch(SQLException e) {
      LOGGER.error("error while executing database delete: " + e.getMessage());
      e.printStackTrace();
    }
    
  }

  @Override
  public void move(int thoughtId, String thoughtLocation) {
    
    try {
      LOGGER.info("executing database update");
      PreparedStatement preparedStatement = connection.prepareStatement("UPDATE thought SET thoughtLocation = ? WHERE thoughtId = ?");
      preparedStatement.setString(1, thoughtLocation);
      preparedStatement.setInt(2, thoughtId);
      preparedStatement.executeUpdate();
      LOGGER.info("successfully executed database update");
    } catch(SQLException e) {
      LOGGER.error("error executing database update: " + e.getMessage());
      e.printStackTrace();
    }
    
  }
  
}
