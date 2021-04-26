package com.github.carlcidromero.project1.control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.carlcidromero.project1.control.dao.DaoHeadspace;
import com.github.carlcidromero.project1.model.Headspace;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DaoImplHeadspace implements DaoHeadspace {

  private static final Logger LOGGER = LogManager.getLogger(DaoImplHeadspace.class.getName());

  Connection connection;

  public DaoImplHeadspace(Connection connection) {
    this.connection = connection;
  }

  @Override
  public List<Headspace> viewAll() {
    
    List<Headspace> headspaces = new ArrayList<>();
    Headspace headspace = null;

    try {
      LOGGER.info("executing database query - begin");
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT thought.thoughtId, thought.thoughtTldr, vibe.vibeTldr, vibe.vibePurpose, thought.thoughtLocation, thought.thoughtFrame FROM thought LEFT JOIN vibe ON thought.thoughtVibeId=vibe.vibeId");
      while(resultSet.next()) {
        headspace = new Headspace();
        headspace.setHeadspaceThoughtId(resultSet.getInt("ThoughtId"));
        headspace.setHeadspaceThoughtTldr(resultSet.getString("thoughtTldr"));
        headspace.setHeadspaceVibeTldr(resultSet.getString("vibeTldr"));
        headspace.setHeadspaceVibePurpose(resultSet.getString("vibePurpose"));
        headspace.setHeadspaceThoughtLocation(resultSet.getString("thoughtLocation"));
        headspace.setHeadspaceThoughtFrame(resultSet.getString("thoughtFrame"));
        headspaces.add(headspace);
      }
      LOGGER.info("executing database query - success");
    } catch(SQLException e) {
      LOGGER.error("executing database query - error: " + e.getMessage());
      e.printStackTrace();
    }

    return headspaces;
  }
  
}
