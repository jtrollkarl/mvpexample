package com.example.jay.mvpexample.view;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
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
import com.hannesdorfmann.mosby.mvp.lce.MvpLceFragment;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.LceViewState;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.MvpLceViewStateFragment;
import com.hannesdorfmann.mosby.mvp.viewstate.lce.data.RetainingLceViewState;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;


public class ColorListFragment extends
        MvpLceViewStateFragment<SwipeRefreshLayout, List<ColorData>, ColorFragmentView, ColorFragmentPresenter>
        implements ColorFragmentView, ColorRecyclerAdapter.OnItemClickListener, SwipeRefreshLayout.OnRefreshListener{


    @BindView(R.id.colorRecycler)
    RecyclerView colorRecycler;
    Unbinder unbinder;


    private ColorRecyclerAdapter adapter;
    private static String TAG = ColorListFragment.class.getSimpleName();

    public ColorListFragment() {
        // Required empty public constructor
    }

    @Override
    public ColorFragmentPresenter createPresenter() {
        return new ColorFragmentPresenterImpl();
    }

    @Override
    public LceViewState<List<ColorData>, ColorFragmentView> createViewState() {
        setRetainInstance(true);
        return new RetainingLceViewState<>();
    }

    @Override
    public List<ColorData> getData() {
        if(adapter != null){
            return adapter.getData();
        }
        return null;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_color_list, container, false);
        unbinder = ButterKnife.bind(this, view);

        adapter = new ColorRecyclerAdapter(getActivity().getApplicationContext());
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
        contentView.setOnRefreshListener(this);

    }

    @Override
    protected String getErrorMessage(Throwable e, boolean pullToRefresh) {
        return null;
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(getContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showContent() {
        super.showContent();
        contentView.setRefreshing(false);
    }

    @Override
    public void onClick(int position) {
        presenter.onItemClicked(position);
    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {
        super.showError(e, pullToRefresh);
        contentView.setRefreshing(false);
    }

    @Override
    public void setData(List<ColorData> data) {
        adapter.setListAndUpdate(new ArrayList<ColorData>(data));
        Log.d(TAG, "List updated");

    }

    @Override
    public void loadData(boolean pullToRefresh) {
        presenter.loadData(pullToRefresh);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        adapter = null;
        unbinder.unbind();
    }

    @Override
    public void onRefresh() {
        loadData(true);
    }
}
