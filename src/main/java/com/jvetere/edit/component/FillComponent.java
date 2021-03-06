package com.jvetere.edit.component;




import com.jvetere.edit.image.Image;
import com.jvetere.edit.image.colorinfo.ColorStorage;


import java.awt.*;
import java.util.ArrayList;
import java.util.List;


public class FillComponent {
    com.jvetere.edit.component.Component com1, com2;
    int             xMin, xMax;
    int             yMin, yMax;
    int[][]         display;

    public FillComponent(com.jvetere.edit.component.Component _com1) {
        com1 = _com1;
        com2 = new com.jvetere.edit.component.Component(new ColorStorage(Color.BLUE));
        xMax = 0;
        yMax = 0;
        xMin = 10000;
        yMin = 10000;
        for (int[] cord: com1.component.keySet()) {
            xMax = Math.max(xMax, cord[0]);
            yMax = Math.max(yMax, cord[1]);
            xMin = Math.min(xMin, cord[0]);
            yMin = Math.min(yMin, cord[1]);
        }
        int normalizedXMax = xMax - xMin;
        int normalizedYMax = yMax - yMin;
        display = new int[normalizedXMax+1][ normalizedYMax+1];
        for (int[] cord: com1.component.keySet()) {
            display [cord[0]-xMin][cord[1] -yMin] = 1;

            com2.componentAdd(new int[] { cord[0]-xMin, cord[1] -yMin }, new ColorStorage(Color.BLUE));


        }

        List<int[]> fill = new ArrayList<>();
        int prev, curr;
        //System.out.println( "here 1");
        for (int x = 0; x < display.length; x++){
            prev = display[x][0];
            for (int y = 0; y < display[0].length; y++){
                //System.out.println( "heree 3");
                curr = display[x][y];
                if (prev == 1 && curr == 0 || (fill.contains(new int[] {x, y-1}) && curr!=1)){
                    fill.add(new int[]{x, y});
                    System.out.println( "heree iof");
                }
                else if (fill.contains(new int[] {x, y-1}) && curr==1){
                    for (int[] var: fill) {
                        System.out.println( "heree");
                        display[var[0]][var[1]] = 2;
                    }
                    fill = new ArrayList<>();
                }
                else {
                    fill = new ArrayList<>();
                }
                prev = curr;
            }
            fill = new ArrayList<>();
        }

        ArrayList<Component> c = new ArrayList<>();
        c.add(com2);
//        for (int x = 0; x < display.length; x++) {
//
//            for (int y = 0; y < display[0].length; y++) {
//                prev = display[x][y];
//                System.out.print(prev + " | ");
//            }
//            System.out.println();
//        }
        Image img = new Image("src/main/images/component.png",c , normalizedXMax+1, normalizedYMax+1);
    }
    public boolean isAdjacent(int x, int y){
        int adjacency = 0;
        if (display[x][y] == 1){
            if (x-1 >= 0 && display[x-1][y] == 1 )
                adjacency++;
            if (x+1 < display.length && display[x+1][y] == 1)
                adjacency++;
            if (y-1 >= 0 && display[x][y-1] == 1)
                adjacency++;
            if (y+1 < display[0].length && display[x][y+1] == 1)
                adjacency++;
        }
        return adjacency == 2 || adjacency == 3;
    }


    @Override
    public String toString(){
        return "MAX X: " + xMax + " MAX Y: " + yMax +"\n" +
                "MIN X: "+ xMin + " MIN Y: " + yMin;
    }
}
