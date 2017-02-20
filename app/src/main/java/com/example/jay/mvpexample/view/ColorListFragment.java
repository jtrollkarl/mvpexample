package com.example.jay.mvpexample.view;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.jay.mvpexample.model.FindColorsInteractorImpl;
import com.example.jay.mvpexample.R;
import com.example.jay.mvpexample.adapter.ColorRecyclerAdapter;
import com.example.jay.mvpexample.data.ColorData;
import com.example.jay.mvpexample.presenter.ColorFragmentPresenter;
import com.example.jay.mvpexample.presenter.ColorFragmentPresenterImpl;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ColorListFragment extends Fragment implements ColorFragmentView, ColorRecyclerAdapter.OnItemClickListener{


    @BindView(R.id.colorRecycler)
    RecyclerView colorRecycler;

    private ColorFragmentPresenter colorFragmentPresenter;

    private ColorRecyclerAdapter adapter;
    private static String TAG = ColorListFragment.class.getSimpleName();

    public ColorListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        colorFragmentPresenter = new ColorFragmentPresenterImpl(this, new FindColorsInteractorImpl());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color_list, container, false);
        ButterKnife.bind(this, view);

        adapter = new ColorRecyclerAdapter();
        adapter.setOnClickListener(this);
        colorRecycler.setAdapter(adapter);

        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        colorRecycler.setLayoutManager(llm);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void setColorList(ArrayList<ColorData> colorList) {
        adapter.setListAndUpdate(colorList);
        Log.d(TAG, "List updated");

    }


    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onResume() {
        super.onResume();
        colorFragmentPresenter.onResume();
    }

    @Override
    public void onDestroy() {
        colorFragmentPresenter.onDestroy();
        super.onDestroy();
    }

    @Override
    public void onClick(int position) {
        colorFragmentPresenter.onItemClicked(position);
    }
}
