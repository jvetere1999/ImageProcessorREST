package com.jvetere.spring.files.upload.model;

import com.jvetere.processor.ProcessType;

public class FileInfo {
    private String name;
    private String url;
    private ProcessType type;

    public FileInfo(String _name, String _url, String _type) {
        name    = _name;
        url     = _url;
        setType(_type);
    }

    public void setType(String _type) {
        switch (_type) {
            case ("dominant") -> {type = ProcessType.DOMINATE_COLOR;}
            default -> {
                type = ProcessType.COMPONENT_MAP;
            }
        }
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
