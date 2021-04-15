package com.github.carlcidromero.project1;

import java.util.List;

public interface ThoughtDao {
    Thought generate(Thought thought);
    List<Thought> remember();
    void rethink(Thought thought);
    void forget(Thought thought);
    void forgetAll();
}
