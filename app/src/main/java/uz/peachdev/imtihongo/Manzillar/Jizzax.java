package uz.peachdev.imtihongo.Manzillar;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import uz.peachdev.imtihongo.R;

public class Jizzax extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    private static final String TAG = Jizzax.class.getName();
    private LatLng latLngmy;
    private LocationListener listener = new LocationListener() {
        @Override
        public void onLocationChanged(Location location) {

        }

        @Override
        public void onStatusChanged(String s, int i, Bundle bundle) {

        }

        @Override
        public void onProviderEnabled(String s) {

        }

        @Override
        public void onProviderDisabled(String s) {

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jizzax);
        isStoragePermissionGranted();
        Intent intent = getIntent();
        Double extraLat = intent.getDoubleExtra("lat", 0);
        Double extraLng = intent.getDoubleExtra("lng", 0);

        if (extraLat == 0 && extraLng == 0) {
            // if map activity is called from navigation drawer extra = null

            // avoiding null pointer exception
            latLngmy = new LatLng(0, 0);
            getLocation();

        } else {
            Log.d(TAG, "onCreate: got extra LatLng");
            latLngmy = new LatLng(extraLat, extraLng);
        }
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
        LatLng latLng = new LatLng(40.1147775, 67.8281616);
//        LatLng latLng2 = new LatLng(41.3613263d, 69.3953991d);
//        LatLng latLng3 = new LatLng(41.3613263d, 69.3953991d);

        mMap.addMarker(new MarkerOptions().position(latLng)
                .title("\"So'g'diyona\" markaziy o'yingoh futbol maydoni").snippet("Jizzax shahri, A.Navoiy ko'chasi ")).setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_ui_foreground));
//        mMap.addMarker(new MarkerOptions().position(latLng2)
//                .title("10 min")).setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_ui_foreground));
//        mMap.addMarker(new MarkerOptions().position(latLng3)
//                .title("15 min")).setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_ui_foreground));

//        mMap.addMarker(new MarkerOptions().position(latLngmy)).setIcon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher_uiax_foreground));
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
    private void getLocation() {
        if (isNetworkAvailable()) {
            LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

            if (locationManager != null) {

                if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                    //if gps is available use gps provider
                    Log.d(TAG, "getLocation: GPS is ON!");

                    if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                        Toast.makeText(this, "Could not get permission to get location", Toast.LENGTH_LONG).show();
                        return;
                    }

                    locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 12000, 10, listener);
                } else {
                    //if gps is not reachable try using network provider
                    Log.d(TAG, "getLocation: GPS is OFF! Using Network");
                    locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 12000, 10, listener);
                }

                //get last user location from location manager
                Location lastKnownLocation = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                if (lastKnownLocation != null) {
                    latLngmy = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
                } else {
                    Log.d(TAG, "getLocation: location is not known!");
                }

            } else {
                //else, alert user
                Toast.makeText(this, "Could not get location manager", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this, "Check internet connection!", Toast.LENGTH_LONG).show();
        }
    }
    private boolean isNetworkAvailable() {
        return ((ConnectivityManager) getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }
}