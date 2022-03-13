package com.jvetere.edit.image;

import com.github.sarxos.webcam.Webcam;

public class Video {
    public Webcam cam;

    public Video(){
        cam = Webcam.getDefault();
        cam.open();
    }
}
