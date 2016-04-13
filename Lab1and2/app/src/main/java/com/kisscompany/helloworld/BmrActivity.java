package com.kisscompany.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
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
    private Spinner spinner;
    MySelectListener mySelectListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmr);

        mySelectListener = new MySelectListener();

        btn_cal = (Button) findViewById(R.id.btn_cal);
        rgOprater = (RadioGroup) findViewById(R.id.rgOparater);
        edt_age = (EditText) findViewById(R.id.edt_age);
        edt_height = (EditText) findViewById(R.id.edt_height);
        edt_weight = (EditText) findViewById(R.id.edt_weight);
        spinner = (Spinner) findViewById(R.id.spn_ex);
        spinner.setOnItemSelectedListener(mySelectListener);


        initInstances();
    }

    private void initInstances() {

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.array_Exercies, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);


        btn_cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double weight = 0.0, height = 0.0, age = 0.0, results = 0.0, bmr = 0.0;
                boolean statusShowToast = true;

                try {
                    weight = Double.parseDouble((edt_weight.getText().toString()));
                } catch (NumberFormatException e) {
                    statusShowToast = false;
                    Toast.makeText(BmrActivity.this,
                            R.string.Please_input_Weight,
                            Toast.LENGTH_SHORT).show();
                }
                try {
                    height = Double.parseDouble((edt_height.getText().toString()));
                } catch (NumberFormatException e) {
                    statusShowToast = false;
                    Toast.makeText(BmrActivity.this,
                            R.string.Please_input_Height,
                            Toast.LENGTH_SHORT).show();
                }
                try {
                    age = Double.parseDouble((edt_age.getText().toString()));
                } catch (NumberFormatException e) {
                    statusShowToast = false;
                    Toast.makeText(BmrActivity.this,
                            R.string.Please_input_Age,
                            Toast.LENGTH_SHORT).show();
                }


                switch (rgOprater.getCheckedRadioButtonId()) {
                    case R.id.rdb_male:
                        results = (10 * weight) + (6.25 * height) + (5 * age) + 5;
                        break;

                    case R.id.rbd_female:
                        results = (10 * weight) + (6.25 * height) + (5 * age) - 161;
                        break;
                }

                switch (mySelectListener.getNumSelecter()) {
                    case 0:
                        bmr = results * 1.2;
                        break;
                    case 1:
                        bmr = results * 1.375;
                        break;
                    case 2:
                        bmr = results * 1.55;
                        break;
                    case 3:
                        bmr = results * 1.725;
                        break;
                    case 4:
                        bmr = results * 1.9;
                        break;
                }

                if (statusShowToast)
                    Toast.makeText(BmrActivity.this,
                            "BMR : " + bmr,
                            Toast.LENGTH_SHORT).show();
                else
                    statusShowToast = true;

            }
        });


    }


}
