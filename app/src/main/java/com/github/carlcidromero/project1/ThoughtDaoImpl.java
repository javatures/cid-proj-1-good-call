package com.github.carlcidromero.project1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ThoughtDaoImpl implements ThoughtDao {

    private final Logger log = LogManager.getLogger(this.getClass());

    private List<Thought> thoughts = new ArrayList<>();

    Connection connection;
    PreparedStatement preparedStatement;
    ResultSet resultSet;
    String sql;

    public ThoughtDaoImpl(Connection connection) {
        this.connection = connection;
    }

    public ThoughtDaoImpl() {
    }

    @Override
    public Thought generate(Thought thought) {
        
        sql = "INSERT INTO thought (tldr) VALUES (?);";
        
        try {
            log.info("Generating thought");
            
            preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, thought.getTldr());
            preparedStatement.execute();
            resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                thought.setId(resultSet.getInt(1));
            }
            
            log.info("Generated thought");
        } catch (SQLException e) {
            log.error("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }
        
        return thought;
    }
    
    @Override
    public Thought remember(int id) {

        sql = "SELECT ? FROM thought;";

        // try {
        //     log.info("Remembering thought");

        //     preparedStatement = connection.prepareStatement(sql);
        // }

        for(Thought thought : thoughts) {
            if(thought.getId() == id)
                return thought;
        }
        return null;
    }

    @Override
    public List<Thought> rememberAll() {

        thoughts.clear();

        sql = "SELECT * FROM thought;";

        try {
            log.info("Remembering thoughts");

            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Thought thought = new Thought();
                thought.setId(resultSet.getInt("id"));
                thought.setTldr(resultSet.getString("tldr"));
                thoughts.add(thought);
            }

            log.info("Remembered thoughts");
        } catch (SQLException e) {
            log.error("SQL Error: " + e.getMessage());
            e.printStackTrace();
        }

        return thoughts;
    }

    @Override
    public void rethink(Thought thought) {

    }

    @Override
    public void forget(int id) {

    }

    @Override
    public void forgetAll() {

    }

}
