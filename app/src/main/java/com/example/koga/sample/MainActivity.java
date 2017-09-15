package com.example.koga.sample;

import android.databinding.DataBindingUtil;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.koga.sample.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> floorList;
    ArrayList<String> areaList1;
    ArrayList<String> areaList2;
    ArrayList<String> areaList3;
    ArrayList<String> areaList4;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        //After DataBinding
        ActivityMainBinding mainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mainBinding.recyclerViewLeft.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.Adapter floorAdapter = new FloorAdapter(floorList);
        mainBinding.recyclerViewLeft.setAdapter(floorAdapter);

        //(Before DataBinding) Instantiate RecyclerView
//        RecyclerView floorRecyclerView = (RecyclerView)(findViewById(R.id.recycler_view_left));

        //(Before DataBinding) create & set layout manager
//        floorRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
//        floorRecyclerView.setHasFixedSize(true);

        //Create a floor list
        floorList = new ArrayList<>();

        // Put data in the list
        floorList.add("1F");
        floorList.add("2F");
        floorList.add("3F");
        floorList.add("4F");
        floorList.add("5F");
        floorList.add("6F");

        //(Before DataBinding) set an adapter
//        RecyclerView.Adapter floorAdapter = new FloorAdapter(floorList);
//        floorRecyclerView.setAdapter(floorAdapter);

        //たぶんここじゃなくてAdapterにいれるべきかな？？ClickListenerと合わせて。
        AreaSetter areaSetter = new AreaSetter();
        areaSetter.getFloor();

        //After DataBinding
        mainBinding.recyclerViewRight.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView.Adapter areaAdapter = new AreaAdapter(areaSetter.area);
        mainBinding.recyclerViewRight.setAdapter(areaAdapter);

        //(Before DataBinding) same thing as above but for Area
//        RecyclerView areaRecyclerView = (RecyclerView)(findViewById(R.id.recycler_view_right));
//
//        areaRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        areaList1 = new ArrayList<>();
        areaList1.add("Aエリア");
        areaList1.add("Bエリア");
        areaList1.add("Cエリア");
        areaList1.add("Dエリア");
        areaList1.add("Eエリア");

//        RecyclerView.Adapter areaAdapter = new AreaAdapter(areaSetter.area);
//        areaRecyclerView.setAdapter(areaAdapter);

        //bunch of area lists for different floors
        areaList2 = new ArrayList<>();
        areaList2.add("Aエリア");
        areaList2.add("Bエリア");

        areaList3 = new ArrayList<>();
        areaList3.add("Aエリア");
        areaList3.add("Bエリア");
        areaList3.add("Cエリア");

        areaList4 = new ArrayList<>();
        areaList4.add("Aエリア");
        areaList4.add("Bエリア");
        areaList4.add("Cエリア");
        areaList4.add("Dエリア");




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
