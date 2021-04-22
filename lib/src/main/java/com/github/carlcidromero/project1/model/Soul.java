package com.github.carlcidromero.project1.model;

public class Soul {
  private int id;
  private String name;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Soul() {
  }

  public Soul(int id, String name) {
    this.id = id;
    this.name = name;
  }

  @Override
  public String toString() {
    return "Soul [id=" + id + ", name=" + name + "]";
  }

}
