package com.jvetere.processor;



import com.jvetere.component.Component;
import com.jvetere.component.ConnectedComponents;
import com.jvetere.image.Image;

import java.util.ArrayList;

public class ComponentProcessor extends Processor {
    int                         pruneSizeLower;
    int                         pruneSizeUpper;
    String                      fileName;
    Image                       original;
    ProcessType                 type;
    ConnectedComponents         components;

    public ComponentProcessor(String _fileName, ProcessType _type) {
        images          = new ArrayList<>();
        fileName        = _fileName;
        type            = _type;
        pruneSizeLower  = 59;
        pruneSizeUpper  = 100000;

    }
    public ComponentProcessor(String _fileName, ProcessType _type,int _pruneSizeLower, int _pruneSizeUpper) {
        images          = new ArrayList<>();
        fileName        = _fileName;
        type            = _type;
        pruneSizeLower  = _pruneSizeLower;
        pruneSizeUpper  = _pruneSizeUpper;

    }
    @Override
    public void run() {
        original            = new Image(fileName);
        images.add(original);
        components          = new ConnectedComponents(original);
        ArrayList<Component> ogArr;
        ogArr               = new ArrayList<>(components.asList());
        components.componentPrune(pruneSizeLower,pruneSizeUpper);

        ArrayList<Component> arr        = components.asList();
        ArrayList<Component> pruned     = components.prunedAsList();
        fileName = fileName.substring(0, fileName.indexOf("."));
        images.add(new Image("src/main/images/pruned.png",
                arr,
                original.width,
                original.height));


        images.add(new Image("src/main/images/onlyPruned.png",
                pruned,
                original.width,
                original.height));

        images.add(new Image("src/main/images/componentImage.png",
                ogArr,
                original.width,
                original.height));

        Component temp = components.asList().get(1);
        images.add(temp.createImage());
    }


    @Override
    public ArrayList<Image> getImages() {
        return images;
    }
}
