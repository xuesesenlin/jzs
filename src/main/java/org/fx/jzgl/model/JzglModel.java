package org.fx.jzgl.model;

import java.io.Serializable;

public class JzglModel implements Serializable {

    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public JzglModel() {
        super();
    }

    public JzglModel(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "JzglModel{" +
                "path='" + path + '\'' +
                '}';
    }
}
