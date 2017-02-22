package com.example.jay.mvpexample.presenter;

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

    public ColorFragmentPresenterImpl() {

    }


    @Override
    public void loadData(boolean pullToRefresh) {
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
