package com.jvetere.spring.files.upload.model;

public class FileInfo {
    private String name;
    private String url;

    public FileInfo(String _name, String _url) {
        name    = _name;
        url     = _url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
