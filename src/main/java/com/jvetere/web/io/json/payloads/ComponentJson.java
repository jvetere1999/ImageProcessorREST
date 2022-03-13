package com.jvetere.web.io.json.payloads;

import com.jvetere.edit.component.Component;
import com.jvetere.edit.image.colorinfo.ColorStorage;

import java.util.ArrayList;
import java.util.Map;

public class ComponentJson {
    public ArrayList<PixelJson> list;
    public static int index = 0;
    public int thisIndex = index;
    public ComponentJson(Component c){
        list = new ArrayList<>();
        Map<int[], ColorStorage> cMap = c.component;

        for (int[] x: cMap.keySet()){
            list.add(new PixelJson(cMap.get(x), x[0], x[1]));
        }
        incrementIndex();
    }
    public static void incrementIndex() {
        index++;
    }
}
