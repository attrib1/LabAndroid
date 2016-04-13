package com.kisscompany.lab4;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private ImageView img;
    
    private int fontSize = 14;
    private String color = "";
    private CheckBox check;
    private ToggleButton tg;
    private Switch btn_switch;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        

        initInstance();

    }

    private void initInstance() {


        findViewById(R.id.checkbox1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 check = (CheckBox) findViewById(R.id.checkbox1);
                img = (ImageView) findViewById(R.id.Img_view);
                if (check.isChecked()) {
                    img.setImageResource(R.drawable.power_button);
                    Toast.makeText(MainActivity.this, "เช็กบอกซ์แสดง img: NOW ON",
                            Toast.LENGTH_SHORT).show();

                } else {
                    img.setImageResource(R.drawable.off_button);
                    Toast.makeText(MainActivity.this, "เช็กบอกซ์แสดง img: NOW OFF",
                            Toast.LENGTH_SHORT).show();

                }
            }
        });


        findViewById(R.id.toggle_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 tg = (ToggleButton) findViewById(R.id.toggle_btn);

                if (tg.isChecked()) {
                    img.setImageResource(R.drawable.toggleon);

                    Toast.makeText(MainActivity.this, "Toggle Save อัตโนมัติ: NOW ON",
                            Toast.LENGTH_SHORT).show();
                } else {
                    img.setImageResource(R.drawable.toggleoff);
                    Toast.makeText(MainActivity.this, "Toggle Save อัตโนมัติ: NOW OFF",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });


        findViewById(R.id.btn_switch).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                 btn_switch = (Switch) findViewById(R.id.btn_switch);


                if (btn_switch.isChecked()) {
                    img.setImageResource(R.drawable.power_button);

                    Toast.makeText(MainActivity.this, "แจ้งเตือนิ: NOW ON",
                            Toast.LENGTH_SHORT).show();
                } else {
                    img.setImageResource(R.drawable.off_button);
                    Toast.makeText(MainActivity.this, "แจ้งเตือน: NOW OFF",
                            Toast.LENGTH_SHORT).show();
                }

            }
        });






        findViewById(R.id.btn_ok).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txtShow = "";
                if (check.isChecked()){
                    txtShow += "เซ็กบ๊อกซ์ถูกเลือกฃ\n";
                }
                if (tg.isChecked()){
                    txtShow += "ท๊อกเกิลถูกเลือก\n";
                }
                if (btn_switch.isChecked()){
                    txtShow += "สวิทซ์ถูกเลือก\n";
                }

                Toast.makeText(MainActivity.this, "แจ้งเตือน: \n" + txtShow,
                        Toast.LENGTH_SHORT).show();
            }

        });

    }//end initInstance
    public void Radio_bt(View v) {
        RadioGroup radio_gp = (RadioGroup) findViewById(R.id.radio_g);
        TextView tv = (TextView) findViewById(R.id.tv_newText);
        switch (radio_gp.getCheckedRadioButtonId()) {
            case R.id.radio_small:
                fontSize = 14;
                color = "#FF8900";
                break;
            case R.id.radio_mid:
                fontSize = 18;
                color = "#00FF04";

                break;
            case R.id.radio_large:
                fontSize = 22;
                color = "#2200C9";
                break;
        }
        tv.setText("SetText Complete");
        tv.setTextSize(fontSize);
        tv.setTextColor(Color.parseColor("" + color + ""));
    }
}//end class
