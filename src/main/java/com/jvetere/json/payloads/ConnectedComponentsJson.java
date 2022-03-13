package com.jvetere.json.payloads;

import com.jvetere.component.Component;
import com.jvetere.component.ConnectedComponents;
import org.springframework.core.io.Resource;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponentsJson {
    public List<ComponentJson> components;


    public ConnectedComponentsJson(ConnectedComponents c) {
        components = new ArrayList<>();
        List<Component> t = c.asList();
        for (Component a: t){
            components.add(a.getJson());
        }

    }

}
