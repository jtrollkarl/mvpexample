package com.example.jay.mvpexample.presenter;

import android.util.Log;

import com.example.jay.mvpexample.model.FindColorsInteractorImpl;
import com.example.jay.mvpexample.view.ColorFragmentView;
import com.example.jay.mvpexample.view.ColorListFragment;
import com.example.jay.mvpexample.model.FindColorsInteractor;
import com.example.jay.mvpexample.data.ColorData;
import com.hannesdorfmann.mosby.mvp.MvpBasePresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Jay on 2017-02-18.
 */

public class ColorFragmentPresenterImpl extends MvpBasePresenter<ColorFragmentView>
        implements ColorFragmentPresenter, FindColorsInteractor.OnFinishedListener {


    private FindColorsInteractorImpl interactor;
    private static final String TAG = ColorFragmentPresenterImpl.class.getSimpleName();

    public ColorFragmentPresenterImpl() {

    }


    @Override
    public void loadData(boolean pullToRefresh) {

        Log.d(TAG, String.valueOf(pullToRefresh));
        getView().showLoading(pullToRefresh);
        if(isViewAttached()){
            interactor = new FindColorsInteractorImpl();
            interactor.findColors(this);
        }
    }

    @Override
    public void onItemClicked(int position) {
        getView().showMessage("Clicked " + position + " position");

    }

    @Override
    public void onFinished(ArrayList<ColorData> colorData) {
        if (isViewAttached()) {
            getView().setData(colorData);
            getView().showContent();
        }
    }


    @Override
    public void attachView(ColorFragmentView view) {
        super.attachView(view);
    }

    @Override
    public void detachView(boolean retainInstance) {
        super.detachView(retainInstance);
    }

}
