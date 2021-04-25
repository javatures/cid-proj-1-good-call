package com.github.carlcidromero.project1.model;

public class Vibe {

  private int vibeId;
  private int vibeSoulId;
  private String vibeTldr;
  private String vibePurpose;

  public int getVibeId() {
    return vibeId;
  }

  public void setVibeId(int vibeId) {
    this.vibeId = vibeId;
  }

  public int getVibeSoulId() {
    return vibeSoulId;
  }

  public void setVibeSoulId(int vibeSoulId) {
    this.vibeSoulId = vibeSoulId;
  }

  public String getVibeTldr() {
    return vibeTldr;
  }

  public void setVibeTldr(String vibeTldr) {
    this.vibeTldr = vibeTldr;
  }

  public String getVibePurpose() {
    return vibePurpose;
  }

  public void setVibePurpose(String vibePurpose) {
    this.vibePurpose = vibePurpose;
  }

  @Override
  public String toString() {
    return "Vibe [vibeId=" + vibeId + ", vibePurpose=" + vibePurpose + ", vibeSoulId=" + vibeSoulId + ", vibeTldr="
        + vibeTldr + "]";
  }

  public Vibe() {
  }

  

  public Vibe(int vibeId, int vibeSoulId, String vibeTldr, String vibePurpose) {
    this.vibeId = vibeId;
    this.vibeSoulId = vibeSoulId;
    this.vibeTldr = vibeTldr;
    this.vibePurpose = vibePurpose;
  }

  public Vibe(int vibeId) {
    this.vibeId = vibeId;
  }

}
