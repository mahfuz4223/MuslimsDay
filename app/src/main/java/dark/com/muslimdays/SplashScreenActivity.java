package dark.com.muslimdays;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONObject;

import cn.pedant.SweetAlert.SweetAlertDialog;
import dark.com.muslimdays.Tools.AppInternetStatus;
import dark.com.muslimdays.Tools.InternetCheckActivity;
import p32929.updaterlib.AppUpdater;
import p32929.updaterlib.UpdateListener;
import p32929.updaterlib.UpdateModel;

public class SplashScreenActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                checkInternet();
            }

        },3000);

    }
    @SuppressLint("WrongConstant")
    private void checkInternet() {
        if (AppInternetStatus.getInstance(this).isOnline()) {
            Log.d("TAG", "checkInternet: Internet Connected" );
            Intent SplashIntent = new Intent(SplashScreenActivity.this,MainActivity.class);
            startActivity(SplashIntent);
            finish();

        } else {
            Log.d("TAG", "checkInternet: Internet not Connected" );
         Intent SplashIntent = new Intent(SplashScreenActivity.this, InternetCheckActivity.class);

            startActivity(SplashIntent);
            finish();

        }

    }
}