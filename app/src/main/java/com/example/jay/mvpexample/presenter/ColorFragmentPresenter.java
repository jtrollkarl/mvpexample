package com.example.jay.mvpexample.presenter;

import com.example.jay.mvpexample.view.ColorFragmentView;
import com.hannesdorfmann.mosby.mvp.MvpPresenter;

/**
 * Created by Jay on 2017-02-18.
 */

public interface ColorFragmentPresenter extends MvpPresenter<ColorFragmentView> {

    void loadData(boolean pullToRefresh);

    void onItemClicked(int position);

}
