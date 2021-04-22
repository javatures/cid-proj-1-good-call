package com.github.carlcidromero.project1.model;

public class Thought {
    private int id;
    private int vibeId;
    private String tldr;
    private String location;
    private String frame;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVibeId() {
        return vibeId;
    }

    public void setVibeId(int vibeId) {
        this.vibeId = vibeId;
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

    public Thought(int id, int vibeId, String tldr, String location, String frame) {
        this.id = id;
        this.vibeId = vibeId;
        this.tldr = tldr;
        this.location = location;
        this.frame = frame;
    }

    public Thought(int id, String tldr, String location, String frame) {
        this.id = id;
        this.tldr = tldr;
        this.location = location;
        this.frame = frame;
    }

    @Override
    public String toString() {
        return "Thought [frame=" + frame + ", id=" + id + ", location=" + location + ", tldr=" + tldr + ", vibeId="
                + vibeId + "]";
    }

}
