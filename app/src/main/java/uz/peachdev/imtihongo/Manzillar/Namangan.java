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

public class Namangan extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_namangan);
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
//
        LatLng latLng = new LatLng(41.007023, 71.674060);
        LatLng latLng2 = new LatLng(41.000725, 71.626124);
        LatLng latLng3 = new LatLng(40.9997006, 71.593506);
        LatLng latLng4 = new LatLng(40.995739, 71.611864);

        mMap.addMarker(new MarkerOptions().position(latLng)
                .title("\"Barkamol avlod\" sport majmuasi stadioni").snippet("Namangan shahri, Istiqlol ko'chasi, 3-uy")).setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_ui_foreground));
        mMap.addMarker(new MarkerOptions().position(latLng2)
                .title("\"Dinamo\" o'yingohi").snippet("Namangan shahri, G'alaba ko'chasi")).setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_ui_foreground));
        mMap.addMarker(new MarkerOptions().position(latLng3)
                .title("\"Navbahor stadioni\" ").snippet("Namangan shahri, 5-kichik tuman")).setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_ui_foreground));
        mMap.addMarker(new MarkerOptions().position(latLng4)
                .title("\"Yoshlik\" stadioni").snippet("To'raqo'rg'on tumani")).setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_ui_foreground));


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