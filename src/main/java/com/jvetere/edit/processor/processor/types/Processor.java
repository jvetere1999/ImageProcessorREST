package com.jvetere.edit.processor.processor.types;


import com.jvetere.edit.image.Image;

import java.util.ArrayList;

public abstract class Processor implements Runnable {
    public          ArrayList<Image> images;
    public abstract ArrayList<Image> getImages();

}
