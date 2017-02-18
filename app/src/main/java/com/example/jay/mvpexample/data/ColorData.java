package com.example.jay.mvpexample.data;

/**
 * Created by Jay on 2017-02-18.
 */

public class ColorData {

    private int colorId;
    private String colorName;

    public ColorData(int colorId, String colorName) {
        this.colorId = colorId;
        this.colorName = colorName;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }
}
