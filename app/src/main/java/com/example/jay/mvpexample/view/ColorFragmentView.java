package com.example.jay.mvpexample.view;

import com.example.jay.mvpexample.data.ColorData;

import java.util.ArrayList;

/**
 * Created by Jay on 2017-02-18.
 */

public interface ColorFragmentView {

    void setColorList(ArrayList<ColorData> colorList);


    void showMessage(String message);

}
