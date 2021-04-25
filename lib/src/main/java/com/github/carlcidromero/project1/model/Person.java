package com.github.carlcidromero.project1.model;

public class Person {

  private int personId;
  private String personUsername;
  private String personPassword;

  public int getPersonId() {
    return personId;
  }

  public void setPersonId(int personId) {
    this.personId = personId;
  }

  public String getPersonUsername() {
    return personUsername;
  }

  public void setPersonUsername(String personUsername) {
    this.personUsername = personUsername;
  }

  public String getPersonPassword() {
    return personPassword;
  }

  public void setPersonPassword(String personPassword) {
    this.personPassword = personPassword;
  }

  @Override
  public String toString() {
    return "Person [personId=" + personId + ", personPassword=" + personPassword + ", personUsername=" + personUsername
        + "]";
  }

}
