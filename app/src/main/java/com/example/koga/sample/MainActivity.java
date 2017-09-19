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

import butterknife.ButterKnife;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> floorList;

    ListView listView;
    ListView listView2;

    ArrayAdapter<String> floorAdapter;
    ArrayAdapter<String> areaAdapter;
    ArrayAdapter<String> areaAdapter2;
    ArrayAdapter<String> areaAdapter3;
    ArrayAdapter<String> areaAdapter4;
    ArrayAdapter<String> areaAdapter5;
    ArrayAdapter<String> areaAdapter6;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


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
        floorAdapter = new ArrayAdapter<>(this, R.layout.list_item, floorList);

        // Link Adapter to ListView
        listView = (ListView) findViewById(R.id.listView1);
        listView.setAdapter(floorAdapter);

        // Create an area list
        ArrayList<String> firstFloor = new ArrayList<>();
        // Put data in the list
        firstFloor.add("エリアA");

        ArrayList<String> secondFloor = new ArrayList<>();
        secondFloor.add("エリアA");
        secondFloor.add("エリアB");

        ArrayList<String> thirdFloor = new ArrayList<>();
        thirdFloor.add("エリアA");
        thirdFloor.add("エリアB");
        thirdFloor.add("エリアC");

        ArrayList<String> forthFloor = new ArrayList<>();
        forthFloor.add("エリアA");
        forthFloor.add("エリアB");
        forthFloor.add("エリアC");
        forthFloor.add("エリアD");

        ArrayList<String> fifthFloor = new ArrayList<>();
        fifthFloor.add("エリアA");
        fifthFloor.add("エリアB");
        fifthFloor.add("エリアC");
        fifthFloor.add("エリアD");
        fifthFloor.add("エリアE");

        ArrayList<String> sixthFloor = new ArrayList<>();
        sixthFloor.add("エリアA");
        sixthFloor.add("エリアB");
        sixthFloor.add("エリアC");
        sixthFloor.add("エリアD");
        sixthFloor.add("エリアE");
        sixthFloor.add("エリアF");


        // Create an adapter
        areaAdapter = new ArrayAdapter<>(this, R.layout.list_item, firstFloor);
        areaAdapter2 = new ArrayAdapter<>(this, R.layout.list_item, secondFloor);
        areaAdapter3 = new ArrayAdapter<>(this, R.layout.list_item, thirdFloor);
        areaAdapter4 = new ArrayAdapter<>(this, R.layout.list_item, forthFloor);
        areaAdapter5 = new ArrayAdapter<>(this, R.layout.list_item, fifthFloor);
        areaAdapter6 = new ArrayAdapter<>(this, R.layout.list_item, sixthFloor);

        // Link Adapter to ListView
        listView2 = (ListView) findViewById(R.id.listView2);
        listView2.setAdapter(areaAdapter);

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
//        if (position == 1){
//            listView2.setAdapter(areaAdapter2);
//        }
        switch (position) {
            case 0:
                listView2.setAdapter(areaAdapter);
                break;
            case 1:
                listView2.setAdapter(areaAdapter2);
                break;
            case 2:
                listView2.setAdapter(areaAdapter3);
                break;
            case 3:
                listView2.setAdapter(areaAdapter4);
                break;
            case 4:
                listView2.setAdapter(areaAdapter5);
                break;
            case 5:
                listView2.setAdapter(areaAdapter6);
                break;
        }
        Log.v("ListView", "selected pos=" + position);
    }
}
