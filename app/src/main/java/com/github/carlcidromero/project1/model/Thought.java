package com.github.carlcidromero.project1.model;

public class Thought {

    private int id;
    private String tldr;

    public Thought(int id, String tldr) {
        this.id = id;
        this.tldr = tldr;
    }

    public Thought() {
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

    @Override
    public String toString() {
        return "Thought [id=" + id + ", tldr=" + tldr + "]";
    }
    
}
