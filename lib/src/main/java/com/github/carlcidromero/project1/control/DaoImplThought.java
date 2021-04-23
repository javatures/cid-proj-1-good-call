package com.github.carlcidromero.project1.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.carlcidromero.project1.model.Thought;
import com.github.carlcidromero.project1.model.Vibe;

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
        Vibe vibe = new Vibe();
        thought.setId(resultSet.getInt("id"));
        vibe.setId(resultSet.getInt("vibe_id"));
        thought.setVibe(vibe);
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

  @Override
  public void contemplate(Thought thought) {

    try {
      LOGGER.info("executing database insert");
      PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO thought (tldr, location, frame) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
      preparedStatement.setString(1, thought.getTldr());
      preparedStatement.setString(2, thought.getLocation());
      preparedStatement.setString(3, thought.getFrame());
      preparedStatement.execute();
      ResultSet resultSet = preparedStatement.getGeneratedKeys();
      if(resultSet.next()) {
        thought.setId(resultSet.getInt(1));
      }
      LOGGER.info("successfully executed database insert");
    } catch(SQLException e) {
      LOGGER.error("error while executing database insert: " + e.getMessage());
      e.printStackTrace();
    }
  }
  
}
