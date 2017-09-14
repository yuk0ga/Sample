package com.example.koga.sample;

import android.content.ClipData;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.content.ClipData.*;

/**
 * Created by koga on 2017/09/06.
 */

public class FloorAdapter extends RecyclerView.Adapter<FloorAdapter.ViewHolder> {

    private List<String> floorDataset = new ArrayList<>();
    private RecyclerView floorRecycler;
    private AdapterView.OnItemClickListener floorListener;

    public static class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mTextView;

        //tells that all views are going to be a string.
        public ViewHolder(View v){
            super(v);
            mTextView = (TextView)(v.findViewById(R.id.list_item_text));
            v.setClickable(true);
        }
    }


    public FloorAdapter(List<String> floorList){
        floorDataset = floorList;
    }


    @Override //create new views. called when recyclerview needs a new view holder.
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item, parent, false);

        // set the view's size, margins, paddings and layout parameters


//        view.setOnClickListener(this);

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    public void setOnItemClickListener(AdapterView.OnItemClickListener listener){
        floorListener = listener;
    }

//    @Override
//    public void onClick(View view){
//        if(floorRecycler == null){
//            return;
//        }
//
//        if(floorListener != null){
//            int position = floorRecycler.getChildAdapterPosition(view);
//            Item item = floorDataset.get(position);
//            floorListener.onItemClick(this, position, item);
//        }
//    }


    @Override  // Replace the contents of a view (invoked by the layout manager)
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.mTextView.setText(floorDataset.get(position));
    }


    @Override   // Return the size of your dataset (invoked by the layout manager)
    public int getItemCount() {
        return floorDataset.size();
    }
}



