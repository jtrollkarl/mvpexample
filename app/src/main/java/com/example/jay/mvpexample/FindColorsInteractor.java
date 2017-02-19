package com.example.jay.mvpexample;

import android.content.Context;

import com.example.jay.mvpexample.data.ColorData;

import java.util.List;

/**
 * Created by Jay on 2017-02-19.
 */

public interface FindColorsInteractor {

    interface OnFinishedListener{
        void onFinished(List<ColorData> colorData);
    }

    void findColors(Context context, OnFinishedListener listener);
}
