package com.example.jay.mvpexample.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jay.mvpexample.data.ColorData;
import com.example.jay.mvpexample.R;

import java.util.ArrayList;

/**
 * Created by Jay on 2017-02-18.
 */

public class ColorRecyclerAdapter extends RecyclerView.Adapter<ColorRecyclerAdapter.ViewHolder> {

    private ArrayList<ColorData> colorDataArrayList;


    public ColorRecyclerAdapter(ArrayList<ColorData> colorDataArrayList) {
        this.colorDataArrayList = colorDataArrayList;
    }

    @Override
    public int getItemCount() {
        return colorDataArrayList.size();
    }

    @Override
    public ColorRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.color_card_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ColorRecyclerAdapter.ViewHolder holder, int position) {
        ColorData colorData = colorDataArrayList.get(position);
        holder.colorName.setText(colorData.getColorName());
        holder.itemView.setBackgroundColor(colorData.getColorId());
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView colorName;

        ViewHolder(View view) {
            super(view);
            colorName = (TextView) view.findViewById(R.id.card_color_name);
        }
    }

}
