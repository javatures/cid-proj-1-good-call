package com.github.carlcidromero.project1;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class ThoughtDaoImpl implements ThoughtDao {

    ResultSet resultSet;
    Connection connection;

    public ThoughtDaoImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void generate(Thought thought) {
        
    }

    @Override
    public List<Thought> remember() {
        return null;
    }

    @Override
    public void rethink(Thought thought) {
        
    }

    @Override
    public void forget(Thought thought) {
        
    }

    @Override
    public void forgetAll() {
        
    }
    
}
