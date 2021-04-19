package dark.com.muslimdays;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Looper;
import android.provider.Settings;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class SalatSettings extends AppCompatActivity {
    static final String THEME_KEY = "Theme";
    int PERMISSION_ID = 44;
    FusedLocationProviderClient mFusedLocationClient;
    double mLongitude, mLatitude;
    String mCity;
    TextView DisplayCity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences prefs = getSharedPreferences(THEME_KEY,0);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_salat_settings);

        
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        //getLastLocation();
        initiateData();

    }

    @SuppressLint("SetTextI18n")
    public void initiateData(){
        SharedPreferences salatpref = getSharedPreferences("lastprayertimes", MODE_PRIVATE);
        String GETPrayerCity = salatpref.getString("city", "Dhaka");
        String GETCountry = salatpref.getString("country", "Bangladesh");

        DisplayCity = findViewById(R.id.displayCity);

        DisplayCity.setText(GETPrayerCity+", "+GETCountry);

    }



    public void findLocation(View v){
        getLastLocation();
        Toast.makeText(getApplicationContext(), getString(R.string.locationloading), Toast.LENGTH_SHORT).show();
    }

    @SuppressLint("MissingPermission")
    public void getLastLocation() {
        if (checkPermissions()) {
            if (isLocationEnabled()) {
                mFusedLocationClient.getLastLocation().addOnCompleteListener(
                        new OnCompleteListener<Location>() {
                            @Override
                            public void onComplete(@NonNull Task<Location> task) {
                                Location location = task.getResult();
                                if (location == null) {
                                    requestNewLocationData();
                                } else {
                                    setLatitude(location.getLatitude());
                                    setLongitude(location.getLongitude());
                                    FindCity(location.getLatitude(), location.getLongitude());
                                }
                            }
                        }
                );
            } else {
                Toast.makeText(this, "Turn on location", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        } else {
            requestPermissions();
        }
    }
    @SuppressLint("MissingPermission")
    private void requestNewLocationData() {
        LocationRequest mLocationRequest = new LocationRequest();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(0);
        mLocationRequest.setFastestInterval(0);
        mLocationRequest.setNumUpdates(1);

        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mFusedLocationClient.requestLocationUpdates(
                mLocationRequest, mLocationCallback,
                Looper.myLooper()
        );
    }
    private LocationCallback mLocationCallback = new LocationCallback() {
        @Override
        public void onLocationResult(LocationResult locationResult) {
            Location mLastLocation = locationResult.getLastLocation();
            setLatitude(mLastLocation.getLatitude());
            setLongitude(mLastLocation.getLongitude());
            FindCity(mLastLocation.getLatitude(), mLastLocation.getLongitude());
        }
    };
    private boolean checkPermissions() {
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) == PackageManager.PERMISSION_GRANTED &&
                ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            return true;
        }
        return false;
    }
    private void requestPermissions() {
        ActivityCompat.requestPermissions(
                this,
                new String[]{Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.ACCESS_FINE_LOCATION},
                PERMISSION_ID
        );
    }
    private boolean isLocationEnabled() {
        LocationManager locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        return locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER) || locationManager.isProviderEnabled(
                LocationManager.NETWORK_PROVIDER
        );
    }
    //----------------------------
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == PERMISSION_ID) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                getLastLocation();
            }
        }
    }
    @Override
    public void onResume() {
        super.onResume();
        //if (checkPermissions()) {
          //  getLastLocation();
        //}
    }
    public void FindCity(double MyLat, double MyLong) {
        //double MyLat = 33.97159194946289;
        //double MyLong = -6.849812984466553;
        Geocoder geocoder = new Geocoder(this, Locale.getDefault());
        List<Address> addresses = null;
        try {
            addresses = geocoder.getFromLocation(MyLat, MyLong, 1);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        String cityName = addresses.get(0).getLocality();
        String country = addresses.get(0).getCountryName();
        setCity(cityName);
        String cityy= cityName.replace(' ', '-');
        SharedPreferences preff = getSharedPreferences("lastprayertimes", MODE_PRIVATE);
        SharedPreferences.Editor editor = preff.edit();
        editor.putString("country", country);
        editor.putString("city", cityy);
        editor.apply();
        DisplayCity = findViewById(R.id.displayCity);
        DisplayCity.setText(cityy+", "+country);
    }
    public void setLongitude(double longitude) {
        mLongitude = longitude;
    }
    public void setLatitude(double latitude) {
        mLatitude = latitude;
    }
    public void setCity(String city) {
        mCity = city;
    }

    @Override
    public void onBackPressed() {
        Intent intent= new Intent(this,MainActivity.class);
        overridePendingTransition(0, 0);
        startActivity(intent);
        overridePendingTransition(0, 0);
        finish();
    }


}
