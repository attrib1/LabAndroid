package com.kisscompany.helloworld;

import android.content.DialogInterface;
import android.graphics.Typeface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText edt_name = (EditText) findViewById(R.id.etd_name);
        tv_name = (TextView) findViewById(R.id.tv_name);
        Button btn_dlg = (Button) findViewById(R.id.btn_dlg);
        Button btn_show = (Button) findViewById(R.id.btn_show);

        btn_show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv_name.setText("" + edt_name.getText().toString());

            }
        });

        btn_dlg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("What's your name ? ")
                        .setMessage("My Name's "+edt_name.getText().toString())
                        .setPositiveButton(android.R.string.cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                            }
                        }).show();

            }
        });


    }
}
