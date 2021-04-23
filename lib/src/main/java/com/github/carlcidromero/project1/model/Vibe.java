package com.github.carlcidromero.project1.model;

public class Vibe {
  private int id;
  private Soul soul;
  private String tldr;
  private String purpose;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTldr() {
    return tldr;
  }

  public void setTldr(String tldr) {
    this.tldr = tldr;
  }

  public String getPurpose() {
    return purpose;
  }

  public void setPurpose(String purpose) {
    this.purpose = purpose;
  }

  public Soul getSoul() {
    return soul;
  }

  public void setSoul(Soul soul) {
    this.soul = soul;
  }

  public Vibe(int id, Soul soul, String tldr, String purpose) {
    this.id = id;
    this.soul = soul;
    this.tldr = tldr;
    this.purpose = purpose;
  }

  public Vibe() {
  }

  @Override
  public String toString() {
    return "Vibe [id=" + id + ", purpose=" + purpose + ", soul=" + soul + ", tldr=" + tldr + "]";
  }

}
