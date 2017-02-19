package com.example.jay.mvpexample;

import com.example.jay.mvpexample.data.ColorData;

import java.util.List;

/**
 * Created by Jay on 2017-02-18.
 */

public class ColorFragmentPresenterImpl implements ColorFragmentPresenter, FindColorsInteractor.OnFinishedListener {

    private ColorListFragment mainView;
    private FindColorsInteractor findColorsInteractor;

    public ColorFragmentPresenterImpl(ColorListFragment mainView, FindColorsInteractor findColorsInteractor) {
        this.mainView = mainView;
        this.findColorsInteractor = findColorsInteractor;
    }

    @Override
    public void onResume() {
        if(mainView != null){
        //show progress bar
        }

    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void onItemClicked(int position) {

    }

    @Override
    public void onFinished(List<ColorData> colorData) {

    }
}
