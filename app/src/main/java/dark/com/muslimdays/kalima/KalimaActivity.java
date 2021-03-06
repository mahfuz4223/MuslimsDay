package dark.com.muslimdays.kalima;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.google.android.material.card.MaterialCardView;

import dark.com.muslimdays.AboutActivity;
import dark.com.muslimdays.R;

public class KalimaActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kalima);
        topBar();
        init();
    }

    private void init() {
        MaterialCardView kalimaTayyeba_button, kalimaSahadat_button, kalimaTaowhid_button, kalimaTamjid_button, kalimaRaddekufor_button;
      
        kalimaRaddekufor_button = findViewById(R.id.kalimaRaddekufor_button);
        kalimaTayyeba_button = findViewById(R.id.kalimaTayyeba_button);
        kalimaSahadat_button = findViewById(R.id.kalimaSahadat_button);
        kalimaTaowhid_button = findViewById(R.id.kalimaTaowhid_button);
        kalimaTamjid_button = findViewById(R.id.kalimaTamjid_button);


        kalimaRaddekufor_button.setOnClickListener(this);
        kalimaSahadat_button.setOnClickListener(this);
        kalimaTamjid_button.setOnClickListener(this);
        kalimaTaowhid_button.setOnClickListener(this);
        kalimaTayyeba_button.setOnClickListener(this);

    }

    private void topBar() {

        setRequestedOrientation (ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);  //  Fixed Portrait orientation
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN); //remove the notifcation bar
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

    @Override
    public void onClick(View v) {

        if (v.getId() == R.id.kalimaRaddekufor_button) {
            Intent intent = new Intent(KalimaActivity.this, KalimaContentView.class);
            intent.putExtra("layoutName","kalimaRaddekufor");
            intent.putExtra("title","?????????????????? ??????????????? ????????????");
            startActivity(intent);

        }
        if (v.getId() == R.id.kalimaSahadat_button) {
            Intent intent = new Intent(KalimaActivity.this, KalimaContentView.class);
            intent.putExtra("layoutName","kalimaSahadat");
            intent.putExtra("title","?????????????????? ?????????????????????");
            startActivity(intent);

        }
        if (v.getId() == R.id.kalimaTamjid_button) {
            Intent intent = new Intent(KalimaActivity.this, KalimaContentView.class);
            intent.putExtra("layoutName","kalimaTamjid");
            intent.putExtra("title","?????????????????? ??????????????????");
            startActivity(intent);

        }
        if (v.getId() == R.id.kalimaTaowhid_button) {
            Intent intent = new Intent(KalimaActivity.this, KalimaContentView.class);
            intent.putExtra("layoutName","kalimaTaowhid");
            intent.putExtra("title","?????????????????? ??????????????????");
            startActivity(intent);

        }

        if (v.getId() == R.id.kalimaTayyeba_button) {
            Intent intent = new Intent(KalimaActivity.this, KalimaContentView.class);
            intent.putExtra("layoutName","kalimaTayyeba");
            intent.putExtra("title","?????????????????? ??????????????????????????????");
            startActivity(intent);

        }
        
    }
}