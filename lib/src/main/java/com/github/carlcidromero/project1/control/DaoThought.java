package com.github.carlcidromero.project1.control;

import java.util.List;

import com.github.carlcidromero.project1.model.Thought;

public interface DaoThought {

    List<Thought> rememberAll();
    void contemplate(Thought thought);
    void forget(Thought thought);
    void move(int id, String location);
    
}
