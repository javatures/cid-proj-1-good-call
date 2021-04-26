package com.github.carlcidromero.project1.control.dao;

import java.util.List;

import com.github.carlcidromero.project1.model.Soul;

public interface DaoSoul {

  List<Soul> observeAll();
  void touch(Soul soul);

}
