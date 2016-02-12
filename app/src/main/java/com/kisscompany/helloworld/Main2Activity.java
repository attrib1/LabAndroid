package com.kisscompany.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {


    private EditText edt_username;
    private EditText edt_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void btn_login(View v) {
        edt_username = (EditText) findViewById(R.id.edt_username);
        edt_password = (EditText) findViewById(R.id.edt_password);

        String str_username = edt_username.getText().toString();
        String str_password = edt_password.getText().toString();

        if (str_username.equals("Sumate") && str_password.equals("1234")) {

            Toast.makeText(
                    Main2Activity.this
                    , "Hi!! " + str_username + " ยินดีต้อนรับ"
                    , Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(Main2Activity.this, DisplayMessageActivity.class);
            intent.putExtra("str_name", "" + str_username);
            startActivity(intent);

        } else {
            Toast.makeText(
                    Main2Activity.this
                    , "Login Fail"
                    , Toast.LENGTH_SHORT).show();
        }

    }
}

