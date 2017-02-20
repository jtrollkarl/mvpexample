package com.example.jay.mvpexample.model;

import android.content.Context;
import android.os.Handler;

import com.example.jay.mvpexample.R;
import com.example.jay.mvpexample.data.ColorData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay on 2017-02-19.
 */

public class FindColorsInteractorImpl implements FindColorsInteractor {

    @Override
    public void findColors(final OnFinishedListener listener) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                listener.onFinished(getColorData());
            }
        }, 2000);
    }

    private ArrayList<ColorData> getColorData(){
        ArrayList<ColorData> data = new ArrayList<>();
        data.add(new ColorData(android.R.color.holo_green_light, "Light green"));
        data.add(new ColorData(android.R.color.black, "Black"));
        data.add(new ColorData(android.R.color.holo_blue_dark, "Dark blue"));
        data.add(new ColorData(android.R.color.holo_red_dark, "Dark red"));


        return data;
    }

}
