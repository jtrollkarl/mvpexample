package com.example.jay.mvpexample.presenter;

import com.example.jay.mvpexample.view.ColorListFragment;
import com.example.jay.mvpexample.model.FindColorsInteractor;
import com.example.jay.mvpexample.data.ColorData;

import java.util.ArrayList;
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
        findColorsInteractor.findColors(this);
    }

    @Override
    public void onPause() {

    }

    @Override
    public void onDestroy() {
        mainView = null;
    }

    @Override
    public void onItemClicked(int position) {
        if(mainView != null){
            mainView.showMessage("position "+ position + " clicked");
        }
    }

    @Override
    public void onFinished(ArrayList<ColorData> colorData) {
        if(mainView != null){
            mainView.setColorList(colorData);
        }
    }




}
