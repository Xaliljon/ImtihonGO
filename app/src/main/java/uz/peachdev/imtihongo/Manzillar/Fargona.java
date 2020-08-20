package uz.peachdev.imtihongo.Manzillar;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import uz.peachdev.imtihongo.R;

public class Fargona extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fargona);
        isStoragePermissionGranted();
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

        LatLng latLng = new LatLng(40.3903341, 71.7498406);
        LatLng latLng2 = new LatLng(40.3868915, 71.7777163);
        LatLng latLng3 = new LatLng(40.4461431, 71.7675984);
        LatLng latLng4 = new LatLng(40.4703572,71.7148415);
        LatLng latLng5 = new LatLng(40.5470271,70.9400667);
        LatLng latLng6 = new LatLng(39.9657435,71.1367051);

        mMap.addMarker(new MarkerOptions().position(latLng)
                .title("\"Istiqlol\" stadioni").snippet("Farg'ona shahri, Kichik halqa yo'li")).setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_ui_foreground));
        mMap.addMarker(new MarkerOptions().position(latLng2)
                .title("Farg'ona davlat universiteti stadioni").snippet("Farg'ona shahri, \" Yoshlar\" MFY, Al-Farg'oniy ko'chaso")).setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_ui_foreground));
        mMap.addMarker(new MarkerOptions().position(latLng3)
                .title("Qirguli mavzesi \"Neftchi\" stadioni").snippet("Farg'ona shahri , Qirguli mavzesi Marg'ilon ko'chasi, 1-uy")).setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_ui_foreground));
        mMap.addMarker(new MarkerOptions().position(latLng4)
                .title("Marg'ilon shahri, 2-bolalar va o'smirlar sport maktabi o'yingohi").snippet("Marg'ilon shahri , \"Yangi bog'\" MFY")).setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_ui_foreground));
        mMap.addMarker(new MarkerOptions().position(latLng5)
                .title("Qo'qon shahri markaziy o'yingohi").snippet("Qo'qon shahri, Turkiston ko'chasi")).setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_ui_foreground));
        mMap.addMarker(new MarkerOptions().position(latLng6)
                .title("\"So'g'diyona\" sport majmuasi stadioni").snippet("So'x tuman, Adolat ko'chasi")).setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_ui_foreground));


        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 12F));
    }

    public boolean isStoragePermissionGranted() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION)
                    == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {


                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation

            return true;
        }
    }

    public void changeType(View view) {
        if (mMap.getMapType() == GoogleMap.MAP_TYPE_NORMAL) {
            mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        } else if (mMap.getMapType() == GoogleMap.MAP_TYPE_SATELLITE) {
            mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

        } else if (mMap.getMapType() == GoogleMap.MAP_TYPE_HYBRID) {
            mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
        }
    }
}