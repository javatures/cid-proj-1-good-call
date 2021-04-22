package com.github.carlcidromero.project1.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.github.carlcidromero.project1.model.Soul;

public class DaoImplSoul implements DaoSoul {

  Connection connection;

  public DaoImplSoul(Connection connection) {
    this.connection = connection;
  }

  @Override
  public List<Soul> touchAll() {
    
    List<Soul> souls = new ArrayList<>();

    try {
      PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM soul");
      ResultSet resultSet = preparedStatement.executeQuery();
      while(resultSet.next()) {
        Soul soul = new Soul();
        soul.setId(resultSet.getInt("id"));
        soul.setName(resultSet.getString("name"));
        souls.add(soul);
      }
    } catch(SQLException e) {
      e.printStackTrace();
    }

    return souls;
  }

}
