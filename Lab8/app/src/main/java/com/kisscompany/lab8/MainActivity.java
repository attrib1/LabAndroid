package com.kisscompany.lab8;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.DashPathEffect;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    static int TAKE_PHOTO_REQUEST_CODE = 1;
    static int TAKE_VDO_REQUEST_CODE = 2;
    static final int MEDIA_TYPE_IMG = 1;
    static final int MEDIA_TYPE_VDO = 2;
    Uri outPutFileUri;
    private ImageButton btn_camera;
    private ImageButton btn_video;
    private ImageView ImgView1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_camera = (ImageButton) findViewById(R.id.btn_camera);
        btn_video = (ImageButton) findViewById(R.id.btn_video);

    }


    public void btn_camera(View v) {
outPutFileUri= getOutputMediaFileUri(MEDIA_TYPE_IMG);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outPutFileUri);
        startActivityForResult(intent, TAKE_PHOTO_REQUEST_CODE);


    }
    public void btn_video(View v){
        outPutFileUri= getOutputMediaFileUri(MEDIA_TYPE_VDO);
        Intent intent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outPutFileUri);
        intent.putExtra(MediaStore.EXTRA_VIDEO_QUALITY,1 );

        startActivityForResult(intent, TAKE_VDO_REQUEST_CODE);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("ddd","ddd");
       // super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TAKE_PHOTO_REQUEST_CODE && resultCode == RESULT_OK) {
            Log.d("ddd","ok");
      //      Toast.makeText(MainActivity.this, outPutFileUri.toString(), Toast.LENGTH_SHORT).show();
            ImgView1 = (ImageView) findViewById(R.id.ImgView1);
            if (data != null) {
                Log.d("ddd","null");
                if (data.hasExtra("data")) {
                    Bitmap thumbnail = data.getParcelableExtra("data");
                    ImgView1.setImageBitmap(thumbnail);
                }
            } else {
                Log.d("ddd","else");
                int width = ImgView1.getWidth();
                int heght = ImgView1.getHeight();
              //  Toast.makeText(MainActivity.this, "ok", Toast.LENGTH_SHORT).show();
                BitmapFactory.Options factoryOptions = new BitmapFactory.Options();
                factoryOptions.inJustDecodeBounds = true;

                BitmapFactory.decodeFile(outPutFileUri.getPath(), factoryOptions);

                int imageWidth = factoryOptions.outWidth;
                int imageHeight = factoryOptions.outHeight;

                int scaleFactor = Math.min(imageWidth / width, imageHeight / heght);
                factoryOptions.inJustDecodeBounds = false;
                factoryOptions.inSampleSize = scaleFactor;
                factoryOptions.inPurgeable = true;
                Bitmap bitmap = BitmapFactory.decodeFile(outPutFileUri.getPath(), factoryOptions);
                ImgView1.setImageBitmap(bitmap);
            }
        } else if (requestCode == RESULT_CANCELED) {
                Toast.makeText(MainActivity.this,"User Cancelled ยกเลิก ",Toast.LENGTH_SHORT).show();
        }else {

        }
        if (requestCode == TAKE_VDO_REQUEST_CODE && requestCode == RESULT_OK){
            Toast.makeText(MainActivity.this, outPutFileUri.toString(), Toast.LENGTH_SHORT).show();
        }else if (requestCode==RESULT_CANCELED){
            Toast.makeText(MainActivity.this, "User Cancelled ยกเลิก ", Toast.LENGTH_SHORT).show();
        }else {

        }



    }

    private static Uri getOutputMediaFileUri(int mediaTypeImg) {
        return Uri.fromFile(getOutputMediaFile(mediaTypeImg));
    }




    private static File getOutputMediaFile(int type){
        File mediaStorageDir = new File (Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES),"MyApp");
        if (!mediaStorageDir.exists()){
            if(!mediaStorageDir.mkdirs()){
                Log.d("MyApp","fail to create dirtory");
                return null;
            }
        }
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        File mediaFile;
        if (type==MEDIA_TYPE_IMG){
            mediaFile = new File(mediaStorageDir.getPath()+File.separator+"IMG_"+timeStamp+".jpg");
        } else   if (type==MEDIA_TYPE_VDO){
            mediaFile = new File(mediaStorageDir.getPath()+File.separator+"VDO_"+timeStamp+".mp4");
        }else {
            return null ;
        }

       return mediaFile;

    }


}
