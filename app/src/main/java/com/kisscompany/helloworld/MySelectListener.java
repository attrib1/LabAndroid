package com.kisscompany.helloworld;


import android.view.View;
import android.widget.AdapterView;


/**
 * Created by PENA on 12/2/2559.
 */
public class MySelectListener implements AdapterView.OnItemSelectedListener {

    int position;

    public int getNumSelecter() {
        return this.position;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        this.position = position;
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
