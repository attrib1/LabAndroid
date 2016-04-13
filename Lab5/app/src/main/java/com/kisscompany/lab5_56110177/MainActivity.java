package com.kisscompany.lab5_56110177;

import android.content.Context;
import android.content.Intent;
import android.database.DataSetObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Gallery galry;
    private Button btn_media;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_media = (Button) findViewById(R.id.btn_media);

        galry = (Gallery) findViewById(R.id.gallery);
        galry.setSpacing(1);
        galry.setAdapter(new ImgeAdapter(this));

        galry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });
        btn_media.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MediaActivity.class);
                startActivity(intent);

            }
        });


    }

    private class ImgeAdapter extends BaseAdapter {
        private Context mContext;
        private Integer[] mImageIds = {
                R.drawable.a,
                R.drawable.b,
                R.drawable.c
        };

        public ImgeAdapter(Context c) {
            mContext = c;
        }


        @Override
        public int getCount() {
            return mImageIds.length;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView i = new ImageView(mContext);

            i.setImageResource(mImageIds[position]);
            i.setLayoutParams(new Gallery.LayoutParams(500, 500));

            //i.setScaleType(ImageView.ScaleType.CENTER_CROP);

            i.setScaleType(ImageView.ScaleType.FIT_XY);

            return i;
        }
    }


}
