package com.example.jay.mvpexample;

import com.example.jay.mvpexample.data.ColorData;

import java.util.ArrayList;

/**
 * Created by Jay on 2017-02-18.
 */

public interface ColorFragmentView {

    void setColorList(ArrayList<ColorData> colorList);

    void hideColors();

    void showColors();

    void showMessage(String message);

}
