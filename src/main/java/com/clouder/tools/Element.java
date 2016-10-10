package com.clouder.tools;

public final class Element {
    private String name;
    private String path;
    public Element(String name, String path) {
        this.name = name;
        this.path = path;
    }
    public String getName() {
        return name;
    }
    public String getPath() {
        return path;
    }
}