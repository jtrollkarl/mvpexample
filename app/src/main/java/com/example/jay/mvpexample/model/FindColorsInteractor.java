package com.example.jay.mvpexample.model;

import android.content.Context;

import com.example.jay.mvpexample.data.ColorData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay on 2017-02-19.
 */

public interface FindColorsInteractor {

    interface OnFinishedListener{
        void onFinished(ArrayList<ColorData> colorData);
    }

    void findColors(OnFinishedListener listener);
}
