package com.jvetere.processor;


import com.jvetere.image.Image;

import java.util.ArrayList;

public abstract class Processor implements Runnable {
    public          ArrayList<Image> images;
    public abstract ArrayList<Image> getImages();

}
