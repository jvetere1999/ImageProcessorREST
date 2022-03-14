package com.jvetere.edit.image.colorinfo;

import com.google.gson.Gson;
import com.jvetere.json.payloads.PixelJson;

import java.awt.*;


public class ColorStorage {
    public int              red;
    public int              green;
    public int              blue;
    public FavoriteColor    favoriteColor;
    public Color            color;

    public ColorStorage(Color _color) {
        color   = _color;
        red     = _color.getRed();
        green   = _color.getGreen();
        blue    = _color.getBlue();

        if (red > blue && red > green)
            favoriteColor = FavoriteColor.RED;
        else if (green > red && green > blue)
            favoriteColor = FavoriteColor.GREEN;
        else
            favoriteColor = FavoriteColor.BLUE;

    }
    public Color getFavoriteColor() {
        switch (favoriteColor) {
            case RED    -> { return Color.RED;  }
            case BLUE   -> { return Color.BLUE; }
            case GREEN  -> { return Color.GREEN;}
        }
        return Color.BLACK;
    }

    @Override
    public boolean equals(Object o) {
        ColorStorage other = null;
        if (o instanceof ColorStorage) {
            other = (ColorStorage) o;
        }

        assert other != null;
        return red == other.red && green == other.green && blue == other.blue;
    }
    @Override
    public String toString() {
        return red + " " + green + " " + blue;
    }


}
