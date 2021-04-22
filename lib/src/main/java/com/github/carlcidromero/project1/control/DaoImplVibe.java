package com.github.carlcidromero.project1.control;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.github.carlcidromero.project1.model.Vibe;

public class DaoImplVibe implements DaoVibe {

  Connection connection;

  public DaoImplVibe(Connection connection) {
    this.connection = connection;
  }
  
  @Override
  public List<Vibe> feelAll() {

    List<Vibe> vibes = new ArrayList<>();

    try {
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
    } catch(SQLException e) {
      e.printStackTrace();
    }
    return vibes;
  }



}
