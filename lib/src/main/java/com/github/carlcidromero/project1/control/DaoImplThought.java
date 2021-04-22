package com.github.carlcidromero.project1.control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    try {
      LOGGER.info("executing database query");
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM thought");
      while(resultSet.next()) {
        Thought thought = new Thought();
        thought.setId(resultSet.getInt("id"));
        thought.setVibeId(resultSet.getInt("vibe_id"));
        thought.setTldr(resultSet.getString("tldr"));
        thought.setLocation(resultSet.getString("location"));
        thought.setFrame(resultSet.getString("frame"));
        thoughts.add(thought);
      }
      LOGGER.info("successfully executed database query");
    } catch(SQLException e) {
      LOGGER.error("error while executing database query: " + e.getMessage());
      e.printStackTrace();
    }
    return thoughts;
  }
  
}
