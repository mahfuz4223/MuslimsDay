 package dark.com.muslimdays;

import android.Manifest;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.provider.AlarmClock;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.navigation.NavigationView;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.MultiplePermissionsReport;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.multi.MultiplePermissionsListener;

import org.json.JSONException;
import org.json.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;


import dark.com.muslimdays.Allah99Name.AllahAr99NamAndFojilotMainActivity;
import dark.com.muslimdays.Allah99Name.AllahMainActivity;
import dark.com.muslimdays.Azan.AzanActivity;
import dark.com.muslimdays.ImportentSurah.ImportantSuraActivity;
import dark.com.muslimdays.NamazShikkha.NanazShikkahActivity;
import dark.com.muslimdays.Tools.AppController;
import dark.com.muslimdays.Tools.AppInternetStatus;
import dark.com.muslimdays.Tools.InternetCheckActivity;
import dark.com.muslimdays.Tools.Monthconvart;
import dark.com.muslimdays.Tools.TimeConverter;
import dark.com.muslimdays.kalima.KalimaActivity;
import dark.com.muslimdays.kibla.CompassActivity;
import hotchemi.android.rate.AppRate;
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

     TextView mCity;



     private com.al.tobangla.views.BNTextView sunRise, sunSet;
    String tag_json_obj = "json_obj_req";
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
        RamadanCountdown();
//        RateAppAlert();

//        LoadPreviousSalatData();

        try {
            new GetPrayerTimes().execute();
            checkInternet();
//            LoadPreviousSalatData();
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
        }).execute();


    }

     private void RamadanCountdown() {

         Calendar start_calendar = Calendar.getInstance();
         Calendar end_calendar = Calendar.getInstance();
         end_calendar.set(2021, 3, 14); // 10 = November, month start at 0 = January
         long start_millis = start_calendar.getTimeInMillis(); //get the start time in milliseconds
         long end_millis = end_calendar.getTimeInMillis(); //get the end time in milliseconds
         long total_millis = (end_millis - start_millis); //total time in milliseconds

         //1000 = 1 second interval
         CountDownTimer cdt = new CountDownTimer(total_millis, 1000) {
             @Override
             public void onTick(long millisUntilFinished) {
                 long days = TimeUnit.MILLISECONDS.toDays(millisUntilFinished);
                 millisUntilFinished -= TimeUnit.DAYS.toMillis(days);

                 long hours = TimeUnit.MILLISECONDS.toHours(millisUntilFinished);
                 millisUntilFinished -= TimeUnit.HOURS.toMillis(hours);

                 long minutes = TimeUnit.MILLISECONDS.toMinutes(millisUntilFinished);
                 millisUntilFinished -= TimeUnit.MINUTES.toMillis(minutes);

                 long seconds = TimeUnit.MILLISECONDS.toSeconds(millisUntilFinished);
          countdownTextView.setText(days + " দিন : " + hours + " ঘন্টা : " + minutes + " মিনিট : " + seconds+" সেকেন্ড"); //You can compute the millisUntilFinished on hours/minutes/seconds

             }

             @Override
             public void onFinish() {
                 countdownTextView.setText("Finish!");
                 countdownCardView.setVisibility(View.GONE);

             }
         };
         cdt.start();

     }

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

//     public void LoadPreviousSalatData(){
//         SharedPreferences salatpref = getSharedPreferences("lastprayertimes", MODE_PRIVATE);
//
//         String GETPrayerCity =salatpref.getString("city",getString(R.string.city));
//         String GETfajr = salatpref.getString("fajr","00:00");
//         String GETduhur = salatpref.getString("duhur","00:00");
//         String GETasr = salatpref.getString("asr","00:00");
//         String GETmaghrib = salatpref.getString("maghrib","00:00");
//         String GETisha = salatpref.getString("isha","00:00");
//         String GetsunSet =  salatpref.getString("sunSeting","00:00");
//         String GetsunRise =  salatpref.getString("sunriseing","00:00");
//
//         mCity.setText(GETPrayerCity);
//         startFajar.setText(timeConverter.TimeConvertTO(GETfajr));
//         startZuhar.setText(timeConverter.TimeConvertTO(GETduhur));
//         startAsr.setText(timeConverter.TimeConvertTO(GETasr));
//         startMagrib.setText(timeConverter.TimeConvertTO(GETmaghrib));
//         startEsha.setText(timeConverter.TimeConvertTO(GETisha));
//         sunSet.setText(timeConverter.TimeConvertTO(GetsunSet));
//         sunRise.setText(timeConverter.TimeConvertTO(GetsunRise));
//
//     }

     private class GetPrayerTimes extends AsyncTask<Void, Void, Void>  {

         SharedPreferences salatpref = getSharedPreferences("lastprayertimes", MODE_PRIVATE);

         String GETPrayerCity = salatpref.getString("city", "Dhaka");
         String GETCountry = salatpref.getString("country", "Bangladesh");

         int fajroff =salatpref.getInt("fajroffset",0);
         int dhuhroff =salatpref.getInt("dhuhroffset",0);
         int asroff =salatpref.getInt("asroffset",0);
         int maghriboff =salatpref.getInt("maghriboffset",0);
         int ishaoff =salatpref.getInt("ishaoffset",0);

         String fajr,duhur,asr,maghrib,isha,sunSeting,sunriseing;
         Boolean Passed=false;

         @Override
         protected void onPreExecute() {
             super.onPreExecute();
             //Toast.makeText(MainActivity.this,getString(R.string.loadingprayertimes),Toast.LENGTH_LONG).show();
         }


         @Override
         protected Void doInBackground(Void... arg0) {
             HttpHandler sh = new HttpHandler();
             // Making a request to url and getting response
             //String url = "https://api.pray.zone/v2/times/today.json?city="+GETPrayerCity;
             String offsets = "&tune=0,"+(fajroff-6)+",0,"+(dhuhroff+5)+","+asroff+","+(maghriboff+5)+",0,"+ishaoff+",0" ;
             String url ="http://api.aladhan.com/v1/timingsByCity?city="+GETPrayerCity+"&country="+GETCountry+"&method=3"+offsets;
             String jsonStr = sh.makeServiceCall(url);
             //Log.e("TAG", "Response from url: " + jsonStr);
             if (jsonStr != null) {
                 try {

                     JSONObject jsonObj = new JSONObject(jsonStr);
                     JSONObject data = jsonObj.getJSONObject("data");
                     JSONObject prayertimes = data.getJSONObject("timings");

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

             //SunSet SunRise
             sunRise.setText(timeConverter.TimeConvertTO(sunriseing));
             sunSet.setText(timeConverter.TimeConvertTO(sunSeting));


             if (Passed) {
                 String[] time1 = fajr.split(":");
                 int hh1 = Integer.parseInt(time1[0].trim());
                 int mm1 = Integer.parseInt(time1[1].trim());
                 String[] time2 = duhur.split(":");
                 int hh2 = Integer.parseInt(time2[0].trim());
                 int mm2 = Integer.parseInt(time2[1].trim());
                 String[] time3 = asr.split(":");
                 int hh3 = Integer.parseInt(time3[0].trim());
                 int mm3 = Integer.parseInt(time3[1].trim());
                 String[] time4 = maghrib.split(":");
                 int hh4 = Integer.parseInt(time4[0].trim());
                 int mm4 = Integer.parseInt(time4[1].trim());
                 String[] time5 = isha.split(":");
                 int hh5 = Integer.parseInt(time5[0].trim());
                 int mm5 = Integer.parseInt(time5[1].trim());

             }
         }
     }
}