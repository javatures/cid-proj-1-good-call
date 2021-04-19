package com.github.carlcidromero.project1.repository;

import java.util.List;

import com.github.carlcidromero.project1.model.Thought;



public interface ThoughtDao {

    // Create
    Thought generate(Thought thought);

    // Read
    Thought remember(int id);
    List<Thought> rememberAll();

    // Update
    void rethink(Thought thought);
    
    // Delete
    void forget(int id);
    void forgetAll();
}
