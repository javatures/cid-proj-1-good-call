package com.github.carlcidromero.project1.model;

public class Thought {

    private int id;
    private String tldr;
    private String vibe;
    private String location;
    private String frame;

    public Thought() {
    }

    public Thought(int id, String tldr, String vibe, String location, String frame) {
        this.id = id;
        this.tldr = tldr;
        this.vibe = vibe;
        this.location = location;
        this.frame = frame;
    }

    public Thought(int id, String tldr, String location, String frame) {
        this.id = id;
        this.tldr = tldr;
        this.location = location;
        this.frame = frame;
    }

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

    public String getVibe() {
        return vibe;
    }

    public void setVibe(String vibe) {
        this.vibe = vibe;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getFrame() {
        return frame;
    }

    public void setFrame(String frame) {
        this.frame = frame;
    }

    @Override
    public String toString() {
        return "Headspace [frame=" + frame + ", id=" + id + ", location=" + location + ", tldr=" + tldr + ", vibe="
                + vibe + "]";
    }

}
