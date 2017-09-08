package com.example.koga.sample;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {



    private RecyclerView mRecyclerView2;
    private RecyclerView.Adapter mAdapter2;
    private RecyclerView.LayoutManager mLayoutManager2;

    private String[] myDataset2 = new String[20];


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Instantiate RecyclerView
        RecyclerView floorRecyclerView = (RecyclerView)(findViewById(R.id.recycler_view_left));

        //create & set layout manager
        floorRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        floorRecyclerView.setHasFixedSize(true);

        //Create a floor list
        ArrayList<String> floorList = new ArrayList<String>();

        // Put data in the list
        floorList.add("1F");
        floorList.add("2F");
        floorList.add("3F");
        floorList.add("4F");
        floorList.add("5F");
        floorList.add("6F");

        //set an adapter
        RecyclerView.Adapter floorAdapter = new FloorAdapter(floorList);
        floorRecyclerView.setAdapter(floorAdapter);





        mRecyclerView2 = (RecyclerView)(findViewById(R.id.recycler_view_right));
        mRecyclerView2.setHasFixedSize(true);
        mLayoutManager2 = new LinearLayoutManager(this);
        mRecyclerView2.setLayoutManager(mLayoutManager2);
        for(int i=0; i<myDataset2.length; i++) {
            myDataset2[i] = "Data_0"+String.valueOf(i);
        }
        mAdapter2 = new AreaAdapter(myDataset2);
        mRecyclerView2.setAdapter(mAdapter2);




        View bottomSheet = findViewById(R.id.bottomSheet1);
        final BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);
        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch(newState){
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED:
                        break;
                    case BottomSheetBehavior.STATE_COLLAPSED:
                        break;
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                }

                // prevent user from dragging down the bottom sheet
                if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });

        Button btnExpand = (Button)(findViewById(R.id.btnExpand));
        Button btnHide = (Button)(findViewById(R.id.btnHide));

        btnExpand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });

        btnHide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });
    }
}
