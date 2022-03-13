package com.jvetere.web.io.json.payloads;

import com.jvetere.edit.component.Component;
import com.jvetere.edit.component.ConnectedComponents;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponentsJson {
    public int width, height;
    public List<ComponentJson> components;


    public ConnectedComponentsJson(ConnectedComponents c) {
        width = c.img.width;
        height = c.img.height;
        components = new ArrayList<>();
        List<Component> t = c.asList();
        for (Component a: t){
            components.add(a.getJson());
        }

    }

}
