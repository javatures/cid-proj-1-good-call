package com.github.carlcidromero.project1;

import java.util.List;

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
