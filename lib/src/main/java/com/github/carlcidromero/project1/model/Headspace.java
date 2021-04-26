package com.github.carlcidromero.project1.model;

public class Headspace {

  private int headspaceThoughtId;
  private String headspaceThoughtTldr;
  private String headspaceVibeTldr;
  private String headspaceVibePurpose;
  private String headspaceThoughtLocation;
  private String headspaceThoughtFrame;

  public int getHeadspaceThoughtId() {
    return headspaceThoughtId;
  }

  public void setHeadspaceThoughtId(int headspaceThoughtId) {
    this.headspaceThoughtId = headspaceThoughtId;
  }

  public String getHeadspaceThoughtTldr() {
    return headspaceThoughtTldr;
  }

  public void setHeadspaceThoughtTldr(String headspaceThoughtTldr) {
    this.headspaceThoughtTldr = headspaceThoughtTldr;
  }

  public String getHeadspaceVibeTldr() {
    return headspaceVibeTldr;
  }

  public void setHeadspaceVibeTldr(String headspaceVibeTldr) {
    this.headspaceVibeTldr = headspaceVibeTldr;
  }

  public String getHeadspaceVibePurpose() {
    return headspaceVibePurpose;
  }

  public void setHeadspaceVibePurpose(String headspaceVibePurpose) {
    this.headspaceVibePurpose = headspaceVibePurpose;
  }

  public String getHeadspaceThoughtLocation() {
    return headspaceThoughtLocation;
  }

  public void setHeadspaceThoughtLocation(String headspaceThoughtLocation) {
    this.headspaceThoughtLocation = headspaceThoughtLocation;
  }

  public String getHeadspaceThoughtFrame() {
    return headspaceThoughtFrame;
  }

  public void setHeadspaceThoughtFrame(String headspaceThoughtFrame) {
    this.headspaceThoughtFrame = headspaceThoughtFrame;
  }

  @Override
  public String toString() {
    return "Headspace [headspaceThoughtFrame=" + headspaceThoughtFrame + ", headspaceThoughtId=" + headspaceThoughtId
        + ", headspaceThoughtLocation=" + headspaceThoughtLocation + ", headspaceThoughtTldr=" + headspaceThoughtTldr
        + ", headspaceVibePurpose=" + headspaceVibePurpose + ", headspaceVibeTldr=" + headspaceVibeTldr + "]";
  }

  public Headspace() {}

  public Headspace(int headspaceThoughtId, String headspaceThoughtTldr, String headspaceVibeTldr,
      String headspaceVibePurpose, String headspaceThoughtLocation, String headspaceThoughtFrame) {
    this.headspaceThoughtId = headspaceThoughtId;
    this.headspaceThoughtTldr = headspaceThoughtTldr;
    this.headspaceVibeTldr = headspaceVibeTldr;
    this.headspaceVibePurpose = headspaceVibePurpose;
    this.headspaceThoughtLocation = headspaceThoughtLocation;
    this.headspaceThoughtFrame = headspaceThoughtFrame;
  }

}
