package com.example.koga.sample;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> floorList;
    ArrayList<String> areaList;

    ListView listView;
    ListView listView2;

    ArrayAdapter<String> adapter;
    ArrayAdapter<String> adapter2;
    ArrayAdapter<String> adapter3;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create a floor list
        floorList = new ArrayList<>();

        // Put data in the list
        floorList.add("1F");
        floorList.add("2F");
        floorList.add("3F");
        floorList.add("4F");
        floorList.add("5F");
        floorList.add("6F");

        // Create an adapter
        adapter = new ArrayAdapter<>(this, R.layout.list_item, floorList);

        // Link Adapter to ListView
        listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(adapter);

        // Create an area list
        areaList = new ArrayList<>();

        // Put data in the list
        areaList.add("エリアA");
        areaList.add("エリアB");
        areaList.add("エリアC");
        areaList.add("エリアD");
        areaList.add("エリアE");
        areaList.add("エリアF");

        // Create an area list
        ArrayList<String> areaList2 = new ArrayList<>();

        // Put data in the list
        areaList2.add("エリアA");
        areaList2.add("エリアB");
        areaList2.add("エリアC");


        // Create an adapter
        adapter2 = new ArrayAdapter<>(this, R.layout.list_item, areaList);
        adapter3 = new ArrayAdapter<>(this, R.layout.list_item, areaList2);

        // Link Adapter to ListView
        listView2 = (ListView) findViewById(R.id.listView2);
        listView2.setAdapter(adapter2);

//        onListItemClick(listView.getPositionForView(listView));


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

    @OnItemClick(R.id.listView1)
    public void onListItemClick(int position) {
//        if (position != 1){
//            areaList.add("エリアX");
//            areaList.add("エリアY");
//            areaList.add("エリアZ");
//            adapter2.notifyDataSetChanged();
//        }
        Log.v("ListView", "selected pos=" + position);
    }
}
