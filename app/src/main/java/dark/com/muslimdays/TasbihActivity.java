package dark.com.muslimdays;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class TasbihActivity extends AppCompatActivity {

    public com.al.tobangla.views.BNTextView showcounter;
    int counter;
    int resetdefault = 10000;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_tasbih);
        topBar();
        SharedPreferences sp = getSharedPreferences("tallycounter", Activity.MODE_PRIVATE);
        int myIntValue = sp.getInt("counter", 0);

        showcounter = findViewById(R.id.counter_text);
        showcounter.setText("" + myIntValue);

    }


    public void reset(View v){
        showcounter=findViewById(R.id.counter_text);
        showcounter.setText("0");
        SharedPreferences sp = getSharedPreferences("tallycounter", TasbihActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("counter", 0);
        editor.commit();
    }

    public void counter (View v){
        showcounter=findViewById(R.id.counter_text);
        count= 1 + Integer.parseInt((String) showcounter.getText()) ;
        showcounter.setText(""+count);
        SharedPreferences sp = getSharedPreferences("tallycounter", TasbihActivity.MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putInt("counter", count);
        editor.commit();
    }

    private void topBar() {

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);  //  Fixed Portrait orientation
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //remove the notifcation bar
        Toolbar topAppBar = findViewById(R.id.toolbar);

        topAppBar.setOnMenuItemClickListener(item -> {

            if (item.getItemId() == R.id.about) {

                Intent intent = new Intent(getApplicationContext(), AboutActivity.class);
                startActivity(intent);
                return true;
            }

            return false;
        });

        topAppBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}