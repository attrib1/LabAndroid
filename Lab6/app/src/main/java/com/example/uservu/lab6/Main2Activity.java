package com.example.uservu.lab6;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initInstance();
    }
    private void initInstance() {
        String[] data = new String[] {"Prophet","Thunder","Andromeda","Blitz","Bushwack","Defiler"
                ,"Engineer","Magmus","Parasite","Parallax"};

        ArrayAdapter <String> adapter = new ArrayAdapter <String>(this,android.R.layout.simple_list_item_1,data);
        listview = (ListView)findViewById(R.id.listView);

        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position+1){
                    case 1:
                        MediaPlayer voice1 = MediaPlayer.create(getBaseContext(),R.raw.a1);
                        voice1.start(); break;
                    case 2:
                        MediaPlayer voice2 = MediaPlayer.create(getBaseContext(),R.raw.a2);
                        voice2.start();break;
                    case 3:
                        MediaPlayer voice3 = MediaPlayer.create(getBaseContext(),R.raw.a3);
                        voice3.start();break;
                    case 4:
                        MediaPlayer voice4 = MediaPlayer.create(getBaseContext(),R.raw.a4);
                        voice4.start();break;
                    case 5:
                        MediaPlayer voice5 = MediaPlayer.create(getBaseContext(),R.raw.a5);
                        voice5.start();break;
                    case 6:
                        MediaPlayer voice6 = MediaPlayer.create(getBaseContext(),R.raw.a6);
                        voice6.start();break;
                    case 7:
                        MediaPlayer voice7 = MediaPlayer.create(getBaseContext(),R.raw.a7);
                        voice7.start();break;
                    case 8:
                        MediaPlayer voice8 = MediaPlayer.create(getBaseContext(),R.raw.a8);
                        voice8.start();break;
                    case 9:
                        MediaPlayer voice9 = MediaPlayer.create(getBaseContext(),R.raw.a9);
                        voice9.start();break;
                    case 10:
                        MediaPlayer voice10 = MediaPlayer.create(getBaseContext(),R.raw.a10);
                        voice10.start();break;
                }
            }
        });
    }


}
