package com.github.carlcidromero.project1.control;

import java.util.List;

import com.github.carlcidromero.project1.model.Vibe;

public interface DaoVibe {

  List<Vibe> feelAll();
  void send(Vibe vibe);
}
