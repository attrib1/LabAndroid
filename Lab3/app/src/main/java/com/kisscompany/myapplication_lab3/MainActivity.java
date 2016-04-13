package com.kisscompany.myapplication_lab3;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText edt_oWeb;
    private EditText edt_phone;
    private EditText edt_map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_oWeb = (EditText)findViewById(R.id.edt_oWeb);
        edt_phone = (EditText)findViewById(R.id.edt_phone);
        edt_map = (EditText)findViewById(R.id.edt_oMap);

        initINstances();


    }

    private void initINstances() {
        findViewById(R.id.btn_oWeb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String Url = edt_oWeb.getText().toString();
               // Url = "http://www.stackoverflow.com";

                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(Url));

                Intent chooser = Intent.createChooser(intent, "android");
                startActivity(chooser);
            }
        });

        findViewById(R.id.btn_oMap).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String url  = edt_map.getText().toString();
                Uri location = Uri.parse("geo:"+url);
                Intent intent = new Intent(Intent.ACTION_VIEW,location);
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_phone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String url = edt_phone.getText().toString();
                Uri number = Uri.parse("tel:+66"+url);
                Intent intent = new Intent(Intent.ACTION_VIEW,number);
                startActivity(intent);
            }
        });
        findViewById(R.id.btn_myWeb).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainMyWeb.class);
                startActivity(intent);
            }
        });


    }
}
