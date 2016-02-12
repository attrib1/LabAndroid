package com.kisscompany.helloworld;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_str;
    private Button btn_Lab2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);

        tv_str = (TextView) findViewById(R.id.tv_str);
        btn_Lab2 = (Button) findViewById(R.id.btn_Lab2);
        btn_Lab2.setOnClickListener(this);

        initInstances();

    }

    private void initInstances() {
        Intent intent = getIntent();
        String str_name = intent.getStringExtra("str_name");
        tv_str.setText(str_name);
        tv_str.setTypeface(null, Typeface.BOLD);
        tv_str.setTextSize(40);

    }

    @Override
    public void onClick(View v) {
        if (v == btn_Lab2) {
            Intent intent = new Intent(
                    DisplayMessageActivity.this, BmrActivity.class);
            startActivity(intent);
        }

    }
}
