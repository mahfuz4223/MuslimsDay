 package dark.com.muslimdays;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Looper;
import android.provider.AlarmClock;
import android.provider.Settings;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.navigation.NavigationView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;
import java.util.Locale;


import dark.com.muslimdays.Allah99Name.AllahAr99NamAndFojilotMainActivity;
import dark.com.muslimdays.Azan.AzanActivity;
import dark.com.muslimdays.ImportentSurah.ImportantSuraActivity;
import dark.com.muslimdays.NamazShikkha.NanazShikkahActivity;
import dark.com.muslimdays.Tools.AppInternetStatus;
import dark.com.muslimdays.Tools.InternetCheckActivity;
import dark.com.muslimdays.Tools.Monthconvart;
import dark.com.muslimdays.Tools.TimeConverter;
import dark.com.muslimdays.kalima.KalimaActivity;
import dark.com.muslimdays.kibla.CompassActivity;
import p32929.updaterlib.AppUpdater;
import p32929.updaterlib.UpdateListener;
import p32929.updaterlib.UpdateModel;

import static android.graphics.Typeface.createFromFile;


 public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private Toolbar topAppBar;

    private TextView countdownTextView;
    private MaterialCardView countdownCardView;

     private com.al.tobangla.views.BNTextView iftar;
     private com.al.tobangla.views.BNTextView sehri;
     private com.al.tobangla.views.BNTextView hijriDates,startFajar,endFajar,startZuhar, startAsr, startMagrib, startEsha,endZuhar, endAsr, endMagrib, endEsha,enDate,hijriyear;


     private ImageButton alarm_button_isha,alarm_button_magrib,alarm_button_asr,alarm_button_zuhar,alarm_button_fajr;

     private TextView hijrimonth,enmonth,enweek;

     private String sFajar, sZuhar, sAsr, sMagrib, sIsha;

     public ProgressDialog progressDialog;


     TextView mCity;



     private com.al.tobangla.views.BNTextView sunRise, sunSet;

//    String tag_json_obj = "json_obj_req";
    final TimeConverter timeConverter = new TimeConverter();
     final Monthconvart monthconvart = new Monthconvart();
    private static final String TAG = "tag";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // check internet First
        checkInternet();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        init();
        topBar();
        SetupNavDrawer();
        checkAllPermission();


        try {
            new GetPrayerTimes().execute();
            new sehriTimes().execute();
            checkInternet();


// :fire           LoadPreviousSalatData()
        } catch (Exception e) {
            Toast.makeText(this, "Network Error", Toast.LENGTH_SHORT).show();
        }

        new AppUpdater(this, "https://darkgamingbd.xyz/update.json", new UpdateListener() {
            @Override
            public void onJsonDataReceived(final UpdateModel updateModel, JSONObject jsonObject) {
                if (AppUpdater.getCurrentVersionCode(MainActivity.this) < updateModel.getVersionCode()) {
                    new AlertDialog.Builder(MainActivity.this)
                            .setIcon(R.drawable.updatess)
                            .setTitle("Update Available")
                            .setMessage("নতুন ফিচার পাওয়ার জন্য বিনামূল্যে অ্যাপটি আপডেট করুন!")
                            .setCancelable(updateModel.isCancellable())
                            .setPositiveButton("Update", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(updateModel.getUrl()));
                                    startActivity(browserIntent);
                                    finish();
                                }
                            })
                            .show();
                }
            }

            @Override
            public void onError(String error) {
                // Do something
            }
        }).execute(); }

     private long backPressedTime;
     private Toast backToast;
     @Override
     public void onBackPressed() {
         if (backPressedTime + 2000 > System.currentTimeMillis()) {
             backToast.cancel();
             super.onBackPressed();
             return;
         } else {
             backToast = Toast.makeText(getBaseContext(), getString(R.string.clickbackagaintoexit), Toast.LENGTH_SHORT);
             backToast.show();
         }

         backPressedTime = System.currentTimeMillis();
     }

     private void checkInternet() {
        if (AppInternetStatus.getInstance(this).isOnline()) {
            Log.d("TAG", "checkInternet: Internet Connected");

        } else {
            Log.d("TAG", "checkInternet: Internet not Connected");
            Intent SplashIntent = new Intent(MainActivity.this, InternetCheckActivity.class);
            startActivity(SplashIntent);
            finish();
        }
    }

     public void SalatSettings(View v){
         Intent intent= new Intent(this,SalatSettings.class);
         startActivity(intent);
         finish();
     }

    private void init() {

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);

        startFajar = findViewById(R.id.startFajr);
        startZuhar = findViewById(R.id.startZuhar);
        startAsr = findViewById(R.id.startAsr);
        startMagrib = findViewById(R.id.statMagrib);
        startEsha = findViewById(R.id.startIsha);

        hijriDates = findViewById(R.id.hidate);
        hijrimonth = findViewById(R.id.hijrimonth);
        enmonth = findViewById(R.id.enmonth);
        enweek = findViewById(R.id.enweek);
        enDate = findViewById(R.id.enDate);
        hijriyear = findViewById(R.id.hijriyear);


        iftar = findViewById(R.id.iftarID);
        sehri = findViewById(R.id.sehriID);
        countdownTextView = findViewById(R.id.countDownTextView);

        sunRise = findViewById(R.id.sunrise);
        sunSet = findViewById(R.id.sunset);

        alarm_button_fajr = findViewById(R.id.alarm_button_fajr);
        alarm_button_zuhar = findViewById(R.id.alarm_button_zuhar);
        alarm_button_asr = findViewById(R.id.alarm_button_asr);
        alarm_button_magrib = findViewById(R.id.alarm_button_magrib);
        alarm_button_isha = findViewById(R.id.alarm_button_isha);

        alarm_button_fajr.setOnClickListener(this);
        alarm_button_zuhar.setOnClickListener(this);
        alarm_button_asr.setOnClickListener(this);
        alarm_button_magrib.setOnClickListener(this);
        alarm_button_isha.setOnClickListener(this);

        countdownCardView = findViewById(R.id.countdownCardView);



    }

    private void topBar() {

        topAppBar = findViewById(R.id.topAppBar);
        topAppBar.setOnMenuItemClickListener(item -> {

            if (item.getItemId() == R.id.about) {

                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
                return true;
            }


            return false;
        });
    }

    private void SetupNavDrawer() {
        navigationView.bringToFront();
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, topAppBar, R.string.nav_open, R.string.nav_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                if (item.getItemId() == R.id.about) {
                     startActivity(new Intent(MainActivity.this, AboutActivity.class));
                }

                if (item.getItemId() == R.id.tasbih) {
                    startActivity(new Intent(MainActivity.this, TasbihActivity.class));
                }

                if (item.getItemId() == R.id.all_surah) {
                    startActivity(new Intent(MainActivity.this, ImportantSuraActivity.class));
                }
                if (item.getItemId() == R.id.compassCard) {
                    startActivity(new Intent(MainActivity.this, CompassActivity.class));
                }
                if (item.getItemId() == R.id.quran) {
                    startActivity(new Intent(MainActivity.this, AzanActivity.class));
                }
                if (item.getItemId() == R.id.namazShikkaid) {
                    startActivity(new Intent(MainActivity.this, NanazShikkahActivity.class));
                }
                if (item.getItemId() == R.id.kalima) {
                    startActivity(new Intent(MainActivity.this, KalimaActivity.class));
                }
                if (item.getItemId() == R.id.name) {
                    startActivity(new Intent(MainActivity.this, AllahAr99NamAndFojilotMainActivity.class));
                }
                if (item.getItemId() == R.id.developer) {
                    startActivity(new Intent(MainActivity.this, Devloper.class));
                } if (item.getItemId() == R.id.setting) {
                    startActivity(new Intent(MainActivity.this, SalatSettings.class));
                    finish();
                }
                return false;
            }
        });

    }


    @Override
    public void onClick(View v) {

        if (v.getId()== R.id.alarm_button_fajr){

           String [] parts = sFajar.split(":");
           int part1 = Integer.parseInt(parts[0]);
           int part2 = Integer.parseInt(parts[1]);
            Log.d(TAG, "onClick: "+part1);
            Log.d(TAG, "onClick: "+part2);

            Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
            i.putExtra(AlarmClock.EXTRA_MESSAGE, "ফজরের নামাজ");
            i.putExtra(AlarmClock.EXTRA_HOUR, part1);
            i.putExtra(AlarmClock.EXTRA_MINUTES, part2);
            startActivity(i);


        }
        if (v.getId()== R.id.alarm_button_zuhar){

            String [] parts = sZuhar.split(":");
            int part1 = Integer.parseInt(parts[0]);
            int part2 = Integer.parseInt(parts[1]);
            Log.d(TAG, "onClick: "+part1);
            Log.d(TAG, "onClick: "+part2);

            Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
            i.putExtra(AlarmClock.EXTRA_MESSAGE, "যোহরের নামাজ");
            i.putExtra(AlarmClock.EXTRA_HOUR, part1);
            i.putExtra(AlarmClock.EXTRA_MINUTES, part2);
            startActivity(i);



        }
        if (v.getId()== R.id.alarm_button_asr){

            String [] parts = sAsr.split(":");
            int part1 = Integer.parseInt(parts[0]);
            int part2 = Integer.parseInt(parts[1]);
            Log.d(TAG, "onClick: "+part1);
            Log.d(TAG, "onClick: "+part2);

            Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
            i.putExtra(AlarmClock.EXTRA_MESSAGE, "আসরের নামাজ");
            i.putExtra(AlarmClock.EXTRA_HOUR, part1);
            i.putExtra(AlarmClock.EXTRA_MINUTES, part2);
            startActivity(i);

        }
        if (v.getId()== R.id.alarm_button_magrib){

            String [] parts = sMagrib.split(":");
            int part1 = Integer.parseInt(parts[0]);
            int part2 = Integer.parseInt(parts[1]);
            Log.d(TAG, "onClick: "+part1);
            Log.d(TAG, "onClick: "+part2);

            Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
            i.putExtra(AlarmClock.EXTRA_MESSAGE, "মাগরিবের নামাজ");
            i.putExtra(AlarmClock.EXTRA_HOUR, part1);
            i.putExtra(AlarmClock.EXTRA_MINUTES, part2);
            startActivity(i);

        }
        if (v.getId()== R.id.alarm_button_isha){

            String [] parts = sIsha.split(":");
            int part1 = Integer.parseInt(parts[0]);
            int part2 = Integer.parseInt(parts[1]);
            Log.d(TAG, "onClick: "+part1);
            Log.d(TAG, "onClick: "+part2);

            Intent i = new Intent(AlarmClock.ACTION_SET_ALARM);
            i.putExtra(AlarmClock.EXTRA_MESSAGE, "ইশার নামাজ");
            i.putExtra(AlarmClock.EXTRA_HOUR, part1);
            i.putExtra(AlarmClock.EXTRA_MINUTES, part2);
            startActivity(i);
        }


    }

    private void checkAllPermission() {

        Dexter.withActivity(this)
                .withPermissions(Manifest.permission.INTERNET,
                        Manifest.permission.ACCESS_NETWORK_STATE)
                .withListener(new MultiplePermissionsListener() {
                    @Override
                    public void onPermissionsChecked(MultiplePermissionsReport report) {
                        // check if all permissions are granted
                        if (report.areAllPermissionsGranted()) {
                            Log.d("TAG", "Permission Granted");
                            // do you work now
                        }

                        // check for permanent denial of any permission
                        if (report.isAnyPermissionPermanentlyDenied()) {
                            // permission is denied permenantly, navigate user to app settings
                            Log.d("TAG", "Permission Granted");
                        }
                    }

                    @Override
                    public void onPermissionRationaleShouldBeShown(List<PermissionRequest> permissions, PermissionToken token) {
                        token.continuePermissionRequest();
                    }
                })
                .onSameThread()
                .check();



    }


     private class GetPrayerTimes extends AsyncTask<Void, Void, Void>  {

         SharedPreferences salatpref = getSharedPreferences("lastprayertimes", MODE_PRIVATE);

         String GETPrayerCity = salatpref.getString("city", "Dhaka");
         String GETCountry = salatpref.getString("country", "Bangladesh");

         int fajroff =salatpref.getInt("fajroffset",0);
         int dhuhroff =salatpref.getInt("dhuhroffset",0);
         int asroff =salatpref.getInt("asroffset",0);
         int maghriboff =salatpref.getInt("maghriboffset",0);
         int ishaoff =salatpref.getInt("ishaoffset",0);

         String fajr,duhur,asr,maghrib,isha,sunSeting,sunriseing,hijrimonths,hijiriyer,hijridat,englishmonth,englishweeks,englishdays;
         Boolean Passed=false;

         @Override
         protected void onPreExecute() {
             super.onPreExecute();
             Toast.makeText(MainActivity.this,getString(R.string.loadingprayertimes),Toast.LENGTH_SHORT).show();


             progressDialog = new ProgressDialog(MainActivity.this);

             progressDialog.show();

             progressDialog.setContentView(R.layout.dialog);

             progressDialog.setCancelable(false);
             progressDialog.getWindow().setBackgroundDrawableResource(
                     android.R.color.transparent
             );

         }


         @Override
         protected Void doInBackground(Void... arg0) {
             HttpHandler sh = new HttpHandler();
             // Making a request to url and getting response
             //String url = "https://api.pray.zone/v2/times/today.json?city="+GETPrayerCity;
             String offsets = "&tune=0,"+(fajroff-2)+",0,"+(dhuhroff-1)+","+(asroff+60)+","+(maghriboff+1)+",0,"+(ishaoff-4)+",0";
             String url ="http://api.aladhan.com/v1/timingsByCity?city="+GETPrayerCity+"&country="+GETCountry+"&method=1"+offsets;
             String jsonStr = sh.makeServiceCall(url);
             //Log.e("TAG", "Response from url: " + jsonStr);
             if (jsonStr != null) {
                 try {

                     JSONObject jsonObj = new JSONObject(jsonStr);
                     JSONObject data = jsonObj.getJSONObject("data");
                     JSONObject prayertimes = data.getJSONObject("timings");

                     JSONObject hijrimonthsss = data.getJSONObject("date").getJSONObject("hijri").getJSONObject("month");

                     JSONObject englishmonths = data.getJSONObject("date").getJSONObject("gregorian").getJSONObject("month");
                     JSONObject englishweek = data.getJSONObject("date").getJSONObject("gregorian").getJSONObject("weekday");
                     JSONObject englishday = data.getJSONObject("date").getJSONObject("gregorian");

                     JSONObject hijridate = data.getJSONObject("date").getJSONObject("hijri");
                     JSONObject hijriyears = data.getJSONObject("date").getJSONObject("hijri");


                     hijrimonths = hijrimonthsss.getString("en");
                     hijiriyer = hijriyears.getString("year");
                     hijridat = hijridate.getString("day");

                     englishmonth = englishmonths.getString("en");
                     englishweeks = englishweek.getString("en");
                     englishdays = englishday.getString("day");


                     fajr = prayertimes.getString("Fajr");
                     duhur = prayertimes.getString("Dhuhr");
                     asr = prayertimes.getString("Asr");
                     maghrib = prayertimes.getString("Maghrib");
                     isha = prayertimes.getString("Isha");
                     sunSeting = prayertimes.getString("Sunset");
                     sunriseing = prayertimes.getString("Sunrise");

                     Passed =true;
                 } catch (final JSONException e) {
                     Log.e("TAG", "Json parsing error: " + e.getMessage());
                     runOnUiThread(new Runnable() {
                         @Override
                         public void run() {
                             Toast.makeText(getApplicationContext(), getString(R.string.errorloadprayertimes), Toast.LENGTH_LONG).show();
                         }
                     });
                 }
             } else {
                 Log.e("TAG", "Couldn't get json from server.");
                 runOnUiThread(new Runnable() {
                     @Override
                     public void run() {
                         Toast.makeText(getApplicationContext(), getString(R.string.errorloadprayertimes), Toast.LENGTH_LONG).show();
                     }
                 });
             }
             return null;
         }


         @Override
         protected void onPostExecute(Void result) {

             progressDialog.dismiss();
             super.onPostExecute(result);
             Toast.makeText(getApplicationContext(), getString(R.string.prayertimesloaded), Toast.LENGTH_LONG).show();
             SharedPreferences salatpref = getSharedPreferences("lastprayertimes", MODE_PRIVATE);
             SharedPreferences.Editor editor = salatpref.edit();
             // editor.putString("city", GETPrayerCity);
             editor.putString("fajr",fajr);
             editor.putString("duhur",duhur);
             editor.putString("asr",asr);
             editor.putString("maghrib",maghrib);
             editor.putString("isha",isha);
             editor.putString("sunriseing",sunriseing);
             editor.putString("sunriseing",sunriseing);

             editor.apply();


             startFajar=findViewById(R.id.startFajr);
             startZuhar=findViewById(R.id.startZuhar);
             startAsr=findViewById(R.id.startAsr);
             startMagrib=findViewById(R.id.statMagrib);
             startEsha=findViewById(R.id.startIsha);
             mCity=findViewById(R.id.city);
             mCity.setText(GETPrayerCity);
//             startFajar.setText(fajr);
             startFajar.setText(timeConverter.TimeConvertTO(fajr));
             startZuhar.setText(timeConverter.TimeConvertTO(duhur));
             startAsr.setText(timeConverter.TimeConvertTO(asr));
             startMagrib.setText(timeConverter.TimeConvertTO(maghrib));
             startEsha.setText(timeConverter.TimeConvertTO(isha));

             hijrimonth.setText(monthconvart.MonthconvartTo(hijrimonths)+" ");
             hijriDates.setText(hijridat+" ");
             hijriyear.setText(hijiriyer);


             iftar.setText(timeConverter.TimeConvertTO(maghrib));


             enmonth.setText(monthconvart.MonthconvartTo(englishmonth));
             enweek.setText(monthconvart.MonthconvartTo(englishweeks)+" ");
             enDate.setText(englishdays+" ");


             //SunSet SunRise
             sunRise.setText(timeConverter.TimeConvertTO(sunriseing));
             sunSet.setText(timeConverter.TimeConvertTO(sunSeting));

         }
     }


    //সেহিরির সময়
     private class sehriTimes extends AsyncTask<Void, Void, Void>  {

         SharedPreferences salatpref = getSharedPreferences("lastprayertimes", MODE_PRIVATE);

         String GETPrayerCity = salatpref.getString("city", "Dhaka");
         String GETCountry = salatpref.getString("country", "Bangladesh");

         int fajroff =salatpref.getInt("fajroffset",0);



         String fajr;

         Boolean Passed=false;

         @Override
         protected void onPreExecute() {
             super.onPreExecute();
             Toast.makeText(MainActivity.this,getString(R.string.loadingprayertimes),Toast.LENGTH_SHORT).show();
         }


         @Override
         protected Void doInBackground(Void... arg0) {
             HttpHandler sh = new HttpHandler();
             // Making a request to url and getting response
             //String url = "https://api.pray.zone/v2/times/today.json?city="+GETPrayerCity;
             String offsets = "&tune=0,"+(fajroff-7)+",0,";
             String url ="http://api.aladhan.com/v1/timingsByCity?city="+GETPrayerCity+"&country="+GETCountry+"&method=1"+offsets;
             String jsonStr = sh.makeServiceCall(url);
             //Log.e("TAG", "Response from url: " + jsonStr);
             if (jsonStr != null) {
                 try {

                     JSONObject jsonObj = new JSONObject(jsonStr);
                     JSONObject data = jsonObj.getJSONObject("data");
                     JSONObject prayertimes = data.getJSONObject("timings");





                     fajr = prayertimes.getString("Fajr");


                     Passed =true;
                 } catch (final JSONException e) {
                     Log.e("TAG", "Json parsing error: " + e.getMessage());
                     runOnUiThread(new Runnable() {
                         @Override
                         public void run() {
                             Toast.makeText(getApplicationContext(), getString(R.string.errorloadprayertimes), Toast.LENGTH_LONG).show();
                         }
                     });
                 }
             } else {
                 Log.e("TAG", "Couldn't get json from server.");
                 runOnUiThread(new Runnable() {
                     @Override
                     public void run() {
                         Toast.makeText(getApplicationContext(), getString(R.string.errorloadprayertimes), Toast.LENGTH_LONG).show();
                     }
                 });
             }
             return null;
         }


         @Override
         protected void onPostExecute(Void result) {

             super.onPostExecute(result);
             Toast.makeText(getApplicationContext(), getString(R.string.prayertimesloaded), Toast.LENGTH_LONG).show();
             SharedPreferences salatpref = getSharedPreferences("lastprayertimes", MODE_PRIVATE);
             SharedPreferences.Editor editor = salatpref.edit();
             // editor.putString("city", GETPrayerCity);
             editor.putString("fajr",fajr);

             editor.apply();


             sehri.setText(timeConverter.TimeConvertTO(fajr));

         }
     }



 }