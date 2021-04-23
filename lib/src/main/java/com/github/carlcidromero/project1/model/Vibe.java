package com.github.carlcidromero.project1.model;

public class Vibe {
  
  private int id;
  private int soulId;
  private String tldr;
  private String purpose;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getSoulId() {
    return soulId;
  }

  public void setSoulId(int soulId) {
    this.soulId = soulId;
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

  public Vibe() {
  }

  public Vibe(int id, int soulId, String tldr, String purpose) {
    this.id = id;
    this.soulId = soulId;
    this.tldr = tldr;
    this.purpose = purpose;
  }

  @Override
  public String toString() {
    return "Vibe [id=" + id + ", purpose=" + purpose + ", soulId=" + soulId + ", tldr=" + tldr + "]";
  }

}
