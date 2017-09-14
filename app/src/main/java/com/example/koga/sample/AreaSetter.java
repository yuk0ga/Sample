package com.example.koga.sample;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import java.util.ArrayList;

/**
 * Created by koga on 2017/09/13.
 */

//Observable クラス
public class AreaSetter extends BaseObservable {
    MainActivity mainActivity = new MainActivity();

    //Floor
    public int floor;

    //Area
    public ArrayList<String> area;

    @Bindable
    public int getFloor() {
        return this.floor;
    }

    public void setArea(){
        switch(floor) {
            case 1:
                area = mainActivity.areaList1;
            case 2:
                area = mainActivity.areaList2;
            case 3:
                area = mainActivity.areaList3;
            case 4:
                area = mainActivity.areaList4;
        }
    }
}
