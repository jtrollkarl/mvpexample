package com.example.jay.mvpexample;

/**
 * Created by Jay on 2017-02-18.
 */

public interface ColorFragmentPresenter {

    void onResume();

    void onPause();

    void onDestroy();

    void onItemClicked(int position);

}
