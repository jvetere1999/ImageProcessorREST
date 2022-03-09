package com.jvetere.processor;



import com.jvetere.image.Image;

import java.util.ArrayList;

public class InImageColorProcessor extends Processor{
    String          fileName;
    ProcessType     type;

    public InImageColorProcessor(String _fileName, ProcessType type) {
        images      = new ArrayList<>();
        fileName    = _fileName;

        images.add(new Image(_fileName));
    }
    @Override
    public ArrayList<Image> getImages() {
        return images;
    }

    @Override
    public void run() {
        String      newFN;
        newFN       = fileName.substring(0, fileName.indexOf("."))+"new.png";
        images.add(new Image( newFN, images.get(0).getColorStorage(), type));
    }
}
