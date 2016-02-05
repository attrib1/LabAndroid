package com.kisscompany.helloworld;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    private TextView tv_str;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        initInstances();

    }

    private void initInstances() {
        tv_str = (TextView) findViewById(R.id.tv_str);
        Intent intent = getIntent();
        String str_name = intent.getStringExtra("str_name");
        tv_str.setText(str_name);
        tv_str.setTypeface(null, Typeface.BOLD);
        tv_str.setTextSize(40);

    }
}
