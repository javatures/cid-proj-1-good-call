package com.github.carlcidromero.project1.model;

public class Soul {
  private int soulId;
  private String soulName;

  public int getSoulId() {
    return soulId;
  }

  public void setSoulId(int soulId) {
    this.soulId = soulId;
  }

  public String getSoulName() {
    return soulName;
  }

  public void setSoulName(String soulName) {
    this.soulName = soulName;
  }

  public Soul() {
  }

  public Soul(int soulId, String soulName) {
    this.soulId = soulId;
    this.soulName = soulName;
  }

  @Override
  public String toString() {
    return "Soul [soulId=" + soulId + ", soulName=" + soulName + "]";
  }

}
