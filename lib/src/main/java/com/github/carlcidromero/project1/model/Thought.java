package com.github.carlcidromero.project1.model;

public class Thought {
    private int id;
    private Vibe vibe;
    private String tldr;
    private String location;
    private String frame;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Vibe getVibe() {
        return vibe;
    }

    public void setVibe(Vibe vibe) {
        this.vibe = vibe;
    }

    public String getTldr() {
        return tldr;
    }

    public void setTldr(String tldr) {
        this.tldr = tldr;
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

    public Thought() {
    }

    public Thought(int id, String tldr, String location, String frame) {
        this.id = id;
        this.tldr = tldr;
        this.location = location;
        this.frame = frame;
    }

    public Thought(int id, Vibe vibe, String tldr, String location, String frame) {
        this.id = id;
        this.vibe = vibe;
        this.tldr = tldr;
        this.location = location;
        this.frame = frame;
    }

    public Thought(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Thought [frame=" + frame + ", id=" + id + ", location=" + location + ", tldr=" + tldr + ", vibe=" + vibe
                + "]";
    }

}
