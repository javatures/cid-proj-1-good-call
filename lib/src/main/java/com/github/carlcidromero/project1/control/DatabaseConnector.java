package com.github.carlcidromero.project1.control;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.github.carlcidromero.project1.model.Headspace;
import com.github.carlcidromero.project1.model.Soul;
import com.github.carlcidromero.project1.model.Thought;
import com.github.carlcidromero.project1.model.Vibe;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DatabaseConnector {

  private static final Logger LOGGER = LogManager.getLogger(DatabaseConnector.class.getName());
  
  Properties properties = new Properties();
  Connection connection;
  String url;
  String password;
  String username;
  DaoImplThought daoThought;
  DaoImplVibe daoVibe;
  DaoImplSoul daoSoul;
  DaoImplHeadspace daoHeadspace;

  // begin singleton implementation
  static DatabaseConnector databaseConnector = new DatabaseConnector();
  private DatabaseConnector(){}
  public static DatabaseConnector getInstance() {
    return databaseConnector;
  }
  // end singleton implementation

  public void connectToDatabase() {
    try {
      String file = "C:/Users/carlc/OneDrive/Desktop/project-1-1/database.properties";
      FileInputStream fileInputStream = new FileInputStream(file);
      properties.load(fileInputStream);
    } catch (IOException e1) {
        e1.printStackTrace();
    }

    url = properties.getProperty("URL");
    password = properties.getProperty("CONNECTION_PASSWORD");
    username = properties.getProperty("CONNECTION_USERNAME");

    try {
        LOGGER.info("trying to connect to database");
        connection = DriverManager.getConnection(url, username, password);
        LOGGER.info("successfully connected to database");

        daoThought = new DaoImplThought(connection);
        daoVibe = new DaoImplVibe(connection);
        daoSoul = new DaoImplSoul(connection);
        daoHeadspace = new DaoImplHeadspace(connection);

    } catch (SQLException e) {
        LOGGER.error("error connecting to database: " + e.getMessage());
        e.printStackTrace();
    }
  }

  List<Headspace> headspaces = new ArrayList<>();
  public List<Headspace> viewHeadspaces() {
    connectToDatabase();
    headspaces = daoHeadspace.viewAll();
    return headspaces;
  }


  List<Thought> thoughts = new ArrayList<>();
  public List<Thought> rememberThoughts() {
    connectToDatabase();
    thoughts = daoThought.rememberAll();
    return thoughts;
  }

  public void contemplateThought(Thought thought) {
    connectToDatabase();
    daoThought.contemplate(thought);
  }

  public void forgetThought(Thought thought) {
    connectToDatabase();
    daoThought.forget(thought);
  }

  public void moveThought(int id, String location) {
    connectToDatabase();
    daoThought.move(id, location);
  }

  List<Vibe> vibes = new ArrayList<>();
  public List<Vibe> feelVibes() {
    connectToDatabase();
    vibes = daoVibe.feelAll();
    return vibes;
  }

  public void sendVibe(Vibe vibe) {
    connectToDatabase();
    daoVibe.send(vibe);
  }

  public void cancelVibe(Vibe vibe) {
    connectToDatabase();
    daoVibe.cancel(vibe);
  }

  public void changeVibe(int id, String tldr) {
    connectToDatabase();
    daoVibe.change(id, tldr);
  }

  List<Soul> souls = new ArrayList<>();
  public List<Soul> observeSouls() {
    connectToDatabase();
    souls = daoSoul.observeAll();
    return souls;
  }

  public void touchSoul(Soul soul) {
    connectToDatabase();
    daoSoul.touch(soul);
  }
}
