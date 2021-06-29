package dark.com.muslimdays;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

import com.webianks.easy_feedback.EasyFeedback;

public class Devloper extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devloper);
    }


    public void feedback(View view) {
        new EasyFeedback.Builder(this)
                .withEmail("darksoftbd@gmail.com")
                .withSystemInfo()
                .build()
                .start();
    }
}