package com.kisscompany.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

public class BmrActivity extends AppCompatActivity {

    private Button btn_cal;
    private RadioGroup rgOprater;
    private EditText edt_age;
    private EditText edt_height;
    private EditText edt_weight;
    private Spinner spn_ex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);

        btn_cal = (Button) findViewById(R.id.btn_cal);
        rgOprater = (RadioGroup) findViewById(R.id.rgOparater);
        edt_age = (EditText) findViewById(R.id.edt_age);
        edt_height = (EditText) findViewById(R.id.edt_height);
        edt_weight = (EditText) findViewById(R.id.edt_weight);
        spn_ex = (Spinner)findViewById(R.id.spn_ex);


        initInstances();
    }

    private void initInstances() {
        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double weight = 0.0, height = 0.0, age = 0.0, results = 0.0,bmr = 0.0;


                weight = Double.parseDouble((edt_weight.getText().toString()));
                height = Double.parseDouble((edt_height.getText().toString()));
                age = Double.parseDouble((edt_age.getText().toString()));

                switch (rgOprater.getCheckedRadioButtonId()) {
                    case R.id.rdb_male:
                        results = (10 * weight) + (6.25 * height) + (5 * age) + 5;
                        break;

                    case R.id.rbd_female:
                        results = (10 * weight) + (6.25 * height) + (5 * age) - 161;
                        break;

                }

                if(spn_ex.getSelectedItem().toString().equals("None")){
                    bmr = results*1.2;
                }

                Toast.makeText(getApplicationContext(),""+bmr,Toast.LENGTH_SHORT).show();

            }
        });

    }


}
