package com.github.carlcidromero.project1.model;

public class Thought {
    private int thoughtId;
    private int thoughtVibeId;
    private String thoughtTldr;
    private String thoughtLocation;
    private String thoughtFrame;

    public int getThoughtId() {
        return thoughtId;
    }

    public void setThoughtId(int thoughtId) {
        this.thoughtId = thoughtId;
    }

    public int getThoughtVibeId() {
        return thoughtVibeId;
    }

    public void setThoughtVibeId(int thoughtVibeId) {
        this.thoughtVibeId = thoughtVibeId;
    }

    public String getThoughtTldr() {
        return thoughtTldr;
    }

    public void setThoughtTldr(String thoughtTldr) {
        this.thoughtTldr = thoughtTldr;
    }

    public String getThoughtLocation() {
        return thoughtLocation;
    }

    public void setThoughtLocation(String thoughtLocation) {
        this.thoughtLocation = thoughtLocation;
    }

    public String getThoughtFrame() {
        return thoughtFrame;
    }

    public void setThoughtFrame(String thoughtFrame) {
        this.thoughtFrame = thoughtFrame;
    }

    @Override
    public String toString() {
        return "Thought [thoughtFrame=" + thoughtFrame + ", thoughtId=" + thoughtId + ", thoughtLocation="
                + thoughtLocation + ", thoughtTldr=" + thoughtTldr + ", thoughtVibeId=" + thoughtVibeId + "]";
    }

    public Thought() {
    }

    public Thought(int thoughtId) {
        this.thoughtId = thoughtId;
    }

    public Thought(int thoughtId, String thoughtTldr, String thoughtLocation, String thoughtFrame) {
        this.thoughtId = thoughtId;
        this.thoughtTldr = thoughtTldr;
        this.thoughtLocation = thoughtLocation;
        this.thoughtFrame = thoughtFrame;
    }

    
    

}
