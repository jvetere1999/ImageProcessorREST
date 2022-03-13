package com.jvetere.spring.files.upload.model;

import com.jvetere.component.Component;
import com.jvetere.component.ConnectedComponents;
import com.jvetere.image.Image;
import com.jvetere.processor.types.ProcessType;

import java.util.ArrayList;

public class FileInfo {
    private String                  name;
    private String                  url;
    private ProcessType             type;
    private Image                   input;
    private ConnectedComponents     components;
    private ArrayList<Image>        images;
    private int                     pruneSizeLower;
    private int                     pruneSizeUpper;
    private ArrayList<Component>    arr;
    private ArrayList<Component>    pruned;
    private ArrayList<Component>    ogArr;

    public FileInfo(String _name, String _url, String _type) {
        name    = _name;
        url     = _url;
        images  = new ArrayList<>();
        setType(_type);
        pruneSizeLower  = 59;
        pruneSizeUpper  = 100000;
    }

    public void setImage() {
        System.out.println(" HERE !!!!!");
        String _fn = "./src/main/images/" + name;
        input               = new Image(_fn);
        components          = new ConnectedComponents(input);
        ogArr               = new ArrayList<>(components.asList());

        components.componentPrune(pruneSizeLower,pruneSizeUpper);

        ArrayList<Component> arr        = components.asList();
        ArrayList<Component> pruned     = components.prunedAsList();
//        images.add(new Image("src/main/images/pruned.png",
//                arr,
//                input.width,
//                input.height));
//
//
//        images.add(new Image("src/main/images/onlyPruned.png",
//                pruned,
//                input.width,
//                input.height));
//
//        images.add(new Image("src/main/images/componentImage.png",
//                ogArr,
//                input.width,
//                input.height));
//
//        Component temp = components.asList().get(1);
//        images.add(temp.createImage());
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
