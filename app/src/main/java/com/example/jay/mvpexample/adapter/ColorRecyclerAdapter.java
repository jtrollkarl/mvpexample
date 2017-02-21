package com.example.jay.mvpexample.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
    private final String TAG = ColorRecyclerAdapter.class.getSimpleName();
    private Context mContext;

    public interface OnItemClickListener{
        void onClick(int position);
    }

    private OnItemClickListener listener;

    public void setOnClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public ColorRecyclerAdapter(Context appContext) {
        this.mContext = appContext;
    }

    public void setListAndUpdate(ArrayList<ColorData> colorData){
        this.colorDataArrayList = colorData;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(colorDataArrayList != null){
            return colorDataArrayList.size();
        }else
            return 0;
    }

    @Override
    public ColorRecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.color_card_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ColorRecyclerAdapter.ViewHolder holder, int position) {
        ColorData colorData = colorDataArrayList.get(position);
        Log.d(TAG, colorData.getColorName());
        holder.colorName.setText(colorData.getColorName());
        holder.itemView.setClickable(true);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(listener != null){
                    listener.onClick(holder.getAdapterPosition());
                }
            }
        });
        holder.itemView.setBackgroundColor(ContextCompat.getColor(mContext, colorData.getColorId()));
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView colorName;

        ViewHolder(View view) {
            super(view);
            colorName = (TextView) view.findViewById(R.id.card_color_name);
        }
    }

}
