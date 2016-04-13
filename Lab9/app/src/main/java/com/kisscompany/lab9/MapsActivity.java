package com.kisscompany.lab9;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.LevelListDrawable;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        double[] Lat = {15.003667, 15.0037063, 15.0028407, 15.0053321, 15.006859, 15.0068248
                , 15.0143373, 15.0162462, 15.0162462, 15.0254034};

        double[] Lng = {102.1143576, 102.1146025, 102.1143934, 102.1140522, 102.1181473, 102.1179478
                , 102.1251739, 102.1280935, 102.1280935, 102.1384389};

        String[] name = {"สนามกีฬาวงษ์ชวลิตกุล", "ร้านอาหารลั้นลา", "ร้าน bedroom", "banana park"
                , "สถานีบริการปิคนิคแก๊ส", "โรงเรียนบ้านโคกไผ่-ขนาย", "จอหอโคราชแอร์แอนด์ซาวด์"
                , "Index Living Mall สาขานครราชสีมา", "ฮอนด้าเมืองงาม", "เทศบาลตำบลจอหอ"};

        String[] myImageList = {"aperture", "aperture_1", "auto_flash"
                , "blitz_flash", "brightness_option", "camera_big_screen_size"
                , "camera_screen", "camera_screen_1", "camera_small_screen_size"
                , "video_file_list"};
        String[] snp = {"สนามกีฬาวงษ์ชวลิตกุล", "ร้านอาหารลั้นลา", "ร้าน bedroom", "banana park"
                , "สถานีบริการปิคนิคแก๊ส", "โรงเรียนบ้านโคกไผ่-ขนาย", "จอหอโคราชแอร์แอนด์ซาวด์"
                , "Index Living Mall สาขานครราชสีมา", "ฮอนด้าเมืองงาม", "เทศบาลตำบลจอหอ"};


        // Add a marker in Sydney and move the camera
 /*       LatLng sydney = new LatLng(-34, 151);
        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));

        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));*/
        LatLng vu = new LatLng(15.002268, 102.118032);
        mMap.addMarker(new MarkerOptions().position(vu)
                .title("วงษ์ชวลิตกุล")
                .snippet("จริยธรรมนำปัญญา")
                .icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher)));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(vu, 15));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(15), 2000, null);

        for (int i = 0; i <= 9; i++) {

            LatLng vu2 = new LatLng(Lat[i], Lng[i]);
            mMap.addMarker(new MarkerOptions().position(vu2)
                    .title(name[i])
                    .snippet(snp[i])
                    .icon(BitmapDescriptorFactory.fromBitmap(resizeMapIcons(myImageList[i],100,100))));

        }



    }
    public Bitmap resizeMapIcons(String iconName,int width, int height){
        Bitmap imageBitmap = BitmapFactory.decodeResource(getResources(),getResources().getIdentifier(iconName, "drawable", getPackageName()));
        Bitmap resizedBitmap = Bitmap.createScaledBitmap(imageBitmap, width, height, false);
        return resizedBitmap;
    }
}
