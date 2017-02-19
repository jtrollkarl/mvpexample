package com.example.jay.mvpexample;

import android.content.Context;
import android.support.v4.content.ContextCompat;

import com.example.jay.mvpexample.data.ColorData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay on 2017-02-19.
 */

public class FindColorsInteractorImpl implements FindColorsInteractor {

    @Override
    public void findColors(Context context, OnFinishedListener listener) {

    }

    private List<ColorData> getColorData(){
        ArrayList<ColorData> data = new ArrayList<>();
        //data.add(new ColorData(ContextCompat.getColor()))



        return null;
    }

}
