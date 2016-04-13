package com.kisscompany.myapplication_lab3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.Toast;

public class MainMyWeb extends AppCompatActivity {

    private WebView myWebView;
    private EditText edt_myWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_my_web);

       edt_myWeb = (EditText)findViewById(R.id.edt_myWeb);

        //initInstances();
    }
        public void go_web(View v){

            String url = edt_myWeb.getText().toString();
            Toast.makeText(getApplication(),""+url,Toast.LENGTH_SHORT).show();

            WebView myWebView = (WebView) findViewById(R.id.webView);
            WebSettings webSettings = myWebView.getSettings();
            webSettings.setJavaScriptEnabled(true);
            myWebView.loadUrl(url);

        }


}
