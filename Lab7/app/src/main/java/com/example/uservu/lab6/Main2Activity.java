package com.example.uservu.lab6;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    private ListView listview;
    private String[] data;
   private   int[] resId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initInstance();

    }

    private void initInstance() {
      data = new String[] {"Prophet","Thunder","Andromeda","Blitz","Bushwack","Defiler"
                ,"Engineer","Magmus","Parasite","Parallax"};
        /* data = new ArrayList<String>();
        data.add("Prophet"); data.add("Thunder"); data.add("Andromeda"); data.add("Blitz"); data.add("Bushwack"); data.add("Defiler"); data.add("Engineer");
        data.add("Magmus"); data.add("Parasite"); data.add("Parallax");*/
        resId = new int[]{R.drawable.a1, R.drawable.a2, R.drawable.a3, R.drawable.a4, R.drawable.a5, R.drawable.a6, R.drawable.a7, R.drawable.a8, R.drawable.a9, R.drawable.a10};

        listview = (ListView)findViewById(R.id.listView);
        adapter adapter = new adapter(getApplicationContext(), data, resId);
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


    private class adapter extends BaseAdapter {
        Context mContext;
        String[] strName;
        int[] resId;
        public adapter(Context applicationContext, String[] data, int[] resId) {
            this.mContext= applicationContext;
            this.strName = data;
            this.resId = resId;
        }

        @Override
        public int getCount() {
            return strName.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            LayoutInflater mInflater =
                    (LayoutInflater)mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            if(view == null)
                view = mInflater.inflate(R.layout.custom_listview, parent, false);

            TextView textView = (TextView)view.findViewById(R.id.tv_hero);
            textView.setText(""+strName[position]);

            TextView textView2 = (TextView)view.findViewById(R.id.tv_hero2);
            textView2.setText(""+strName[position]);

            ImageView imageView = (ImageView)view.findViewById(R.id.Img_hero);
            imageView.setBackgroundResource(resId[position]);

            return view;
        }


        }
    }

