package com.example.jay.mvpexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.jay.mvpexample.adapter.ColorRecyclerAdapter;
import com.example.jay.mvpexample.data.ColorData;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class ColorListFragment extends Fragment implements ColorFragmentView{


    @BindView(R.id.colorRecycler)
    RecyclerView colorRecycler;

    public ColorListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void setColorList(ArrayList<ColorData> colorList) {
        LinearLayoutManager llm = new LinearLayoutManager(getContext());
        colorRecycler.setLayoutManager(llm);
        colorRecycler.setAdapter(new ColorRecyclerAdapter(colorList));

    }

    @Override
    public void hideColors() {
        colorRecycler.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showColors() {
        colorRecycler.setVisibility(View.VISIBLE);
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
