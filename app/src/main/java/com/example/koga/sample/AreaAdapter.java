package com.example.koga.sample;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by koga on 2017/09/06.
 */

public class AreaAdapter extends RecyclerView.Adapter<AreaAdapter.ViewHolder> {

    private ArrayList<String> areaDataset = new ArrayList<>();

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;

        public ViewHolder(View v){
            super(v);
            mTextView = (TextView)(v.findViewById(R.id.list_item_text));
            v.setClickable(true);
        }
    }

    public AreaAdapter(ArrayList<String> areaList){
        areaDataset = areaList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        // set the view's size, margins, paddings and layout parameters


        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(areaDataset.get(position));
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return areaDataset.size();
    }
}
