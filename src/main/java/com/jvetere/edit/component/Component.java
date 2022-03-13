package com.jvetere.edit.component;

import com.jvetere.edit.image.Image;
import com.jvetere.edit.image.colorinfo.ColorStorage;
import com.jvetere.edit.image.colorinfo.FavoriteColor;
import com.jvetere.web.io.json.payloads.ComponentJson;

import java.awt.*;
import java.util.HashMap;

public class Component {
    public ColorStorage rootColor;
    public          Image                           rootImgPointer;
    private final   int                             DISTANCE = 15;
    public          HashMap<int[], ColorStorage>    component; // int {x, y}
    private         int                             xMax, xMin;
    private         int                             yMax, yMin;

    public Component(int[] cord, ColorStorage point) {
        rootColor = point;
        component = new HashMap<>();
        component.put(cord, point);
    }
    public Component() {
        component = new HashMap<>();
    }

    public Component(ColorStorage _rootColor) {
        rootColor = _rootColor;
        component = new HashMap<>();
    }

    public void componentAdd(int[] cord, ColorStorage point) {
        component.put(cord, point);
        //updateAverage();
    }

    public void union (Component toAdd) {
        component.putAll(toAdd.component);
    }



//    private void updateAverage () {
//        double[] newAvg = new double[] {0, 0, 0};
//        for (ColorStorage com: component.values()) {
//            newAvg[0] += com.red;
//            newAvg[1] += com.green;
//            newAvg[2] += com.blue;
//        }
//        newAvg[0] = newAvg[0]/component.size();
//        newAvg[1] = newAvg[1]/component.size();
//        newAvg[2] = newAvg[2]/component.size();
//        averageColor = newAvg;
//    }

    public boolean contains(int[] check) {
        return component.containsKey(check);
    }
    public int size(){
        return component.size();
    }
    public boolean match(ColorStorage outside) {
        int outRed      = outside.red;
        int outGreen    = outside.green;
        int outBlue     = outside.blue;
        boolean dominant;
        boolean red     = isDominant(FavoriteColor.RED) ? (rootColor.red   - DISTANCE/2) < outRed
                && outRed   < (rootColor.red   + DISTANCE/2) : (rootColor.red   - DISTANCE) < outRed
                && outRed   < (rootColor.red   + DISTANCE);
        boolean green   = isDominant(FavoriteColor.GREEN) ? (rootColor.green   - DISTANCE/2) < outGreen
                && outGreen   < (rootColor.green   + DISTANCE/2) : (rootColor.green   - DISTANCE) < outGreen
                && outGreen   < (rootColor.green   + DISTANCE);
        boolean blue    = isDominant(FavoriteColor.BLUE)? (rootColor.blue  - DISTANCE/2) < outBlue  && outBlue  < (rootColor.blue  + DISTANCE/2) :
                (rootColor.blue  - DISTANCE) < outBlue  && outBlue  < (rootColor.blue  + DISTANCE);

        return red && green && blue;
    }
    public Image createImage() {
        Component   com2;

        com2 = new Component(new ColorStorage(Color.BLUE));
        xMax = 0;
        yMax = 0;
        xMin = 10000;
        yMin = 10000;
        for (int[] cord: this.component.keySet()) {
            xMax = Math.max(xMax, cord[0]);
            yMax = Math.max(yMax, cord[1]);
            xMin = Math.min(xMin, cord[0]);
            yMin = Math.min(yMin, cord[1]);
        }
        int normalizedXMax = xMax - xMin;
        int normalizedYMax = yMax - yMin;
        for (int[] cord: this.component.keySet()) {
            com2.componentAdd(new int[] { cord[0]-xMin, cord[1] -yMin }, rootColor);
        }
        return new Image("src/main/images/component.png", com2 , normalizedXMax+1, normalizedYMax+1);
    }
    public int[][] create2DRep(){
        int[][]     display;
        int         normalizedXMax = xMax - xMin;
        int         normalizedYMax = yMax - yMin;

        display = new int[normalizedXMax+1][ normalizedYMax+1];
        for (int[] cord: this.component.keySet()) {
            display[cord[0] - xMin][cord[1] - yMin] = 1;
        }
        return display;
    }
    public boolean isDominant(FavoriteColor color) {
        return rootColor.favoriteColor == color;
    }
    public int getColor() {
        return rootColor.color.getRGB();
    }
    public ComponentJson getJson(){
        return new ComponentJson(this);
    }

}
