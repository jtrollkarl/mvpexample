package com.example.jay.mvpexample.view;

import com.example.jay.mvpexample.data.ColorData;
import com.hannesdorfmann.mosby.mvp.lce.MvpLceView;

import java.util.List;

/**
 * Created by Jay on 2017-02-18.
 */

public interface ColorFragmentView extends MvpLceView<List<ColorData>> {


    void showMessage(String message);

}
