package com.jvetere.web.io.json.payloads;

import com.jvetere.edit.image.colorinfo.ColorStorage;

public class PixelJson {
    public int  red, green, blue, x, y;
    public PixelJson(ColorStorage c, int _x, int _y) {
        x =_x;
        y =_y;
        red = c.red;
        green = c.green;
        blue = c.blue;
    }

    public int[] getArray() {
        return new int[] {x, y, red, green, blue};
    }
}
