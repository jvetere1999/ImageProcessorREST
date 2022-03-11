package com.jvetere.component;


import com.jvetere.image.*;
import com.jvetere.image.colorinfo.ColorStorage;

import java.util.ArrayList;
import java.util.List;

public class ConnectedComponents {
    List<Component>     components;
    List<Component>     prunedComponent;
    Image               img;
    ColorStorage[][]    imgArr;
    int                 componentIndex;
    int                 xLim;
    int                 yLim;
    int[][]             componentVisual;

    public ConnectedComponents(Image _img) {
        components      = new ArrayList<>();
        prunedComponent = new ArrayList<>();
        img             = _img;
        imgArr          = _img.getColorStorage();
        componentIndex  = 0;
        componentVisual = new int[img.width][img.height];
        constructComponents();

    }
    public void constructComponents() {
        boolean[][] added = new boolean[img.width][img.height];

        for (int y = 0; y < img.height; y++) {
            for (int x = 0; x < img.width; x++) {

                if (!added[x][y]) {
                    components.add(componentIndex,  scanForComponentWithBreadth(added, x, y) );
                    componentIndex++;
                }
            }
        }
    }

    public void componentPrune(int pruneSizeLower, int pruneUpper) {
        List<Component> temp = new ArrayList<>(components);
        for (Component com : temp) {
            if (com.size() < pruneSizeLower || com.size() > pruneUpper) {
                prunedComponent.add(com);
                components.remove(com);
            }
        }

    }

    public ArrayList<Component> prunedAsList() {
        return (ArrayList<Component>) prunedComponent;
    }



    public ArrayList<Component> asList(){
        return (ArrayList<Component>) components;
    }
    public Component scanForComponentWithBreadth(boolean[][] added, int x, int y) {
        xLim = img.width;
        yLim = img.height;

        ColorStorage compareColor = imgArr[x] [y];
        Component com = new Component(new int[] {x, y}, compareColor);

        List<int[]> frontier = new ArrayList<>();
        frontier.add(new int[] {x, y});
        added[x][y] = true;

        while (frontier.size() > 0) {

            int[] cord = frontier.get(0);
            int xC = cord[0];
            int yC = cord[1];
            frontier.remove(0);

            ifX(xC - 1,        yC, added, frontier, com);
            ifX(xC + 1,        yC, added, frontier, com);
            ifY(       xC, yC - 1, added, frontier, com);
            ifY(       xC, yC + 1, added, frontier, com);

        }
        return com;
    }

    private void ifX(int x, int y, boolean[][] added, List<int[]> frontier, Component com) {
        if ( x >= 0 && x < xLim
                && !added[x][y]
                && com.match(imgArr[x][y])) {
            added[x][y] = true;
            frontier.add(
                    new int[] {x, y} );

            com.componentAdd( new int[] {x, y}, imgArr[x][y]);

        }
    }
    private void ifY(int x, int y, boolean[][] added, List<int[]> frontier, Component com) {
        if ( y >= 0 && y < yLim
                && !added[x][y]
                && com.match(imgArr[x][y])) {
            added[x][y] = true;
            frontier.add(
                    new int[] {x, y} );

            com.componentAdd( new int[] {x, y}, imgArr[x][y]);

        }
    }

    public void componentVisualize() {
        for (int index = 0; index < components.size(); index++) {
            for (int[] cord: components.get(index).component.keySet()) {
                componentVisual[cord[0]] [cord[1]] = index;
            }
        }
    }
    public int size() {
        return components.size();
    }
    public Component get(int _index) {
        return components.get(_index);
    }
    @Override
    public String toString() {
        componentVisualize();
        String rtr = "";
        for (int y = 0; y < img.height; y++) {

            for (int x = 0; x < img.width; x++) {
                rtr += componentVisual[x][y] + " ";
            }
            rtr += "\n";
        }
        return rtr;
    }
}
