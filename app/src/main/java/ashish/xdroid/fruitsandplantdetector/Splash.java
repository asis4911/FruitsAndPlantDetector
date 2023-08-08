package ashish.xdroid.fruitsandplantdetector;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    private int RUN_TIMEOUT = 2000;
    TextView heading,version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);


        heading = findViewById(R.id.tv);
        version = findViewById(R.id.version_1);
        Typeface face = Typeface.createFromAsset(getAssets(), "fonts/robotto.ttf");
        heading.setTypeface(face);

        Typeface face1 = Typeface.createFromAsset(getAssets(), "fonts/robotto.ttf");
        version.setTypeface(face1);

        new Handler().postDelayed(new Runnable(){
            @Override
            public void run(){
                Intent Splash = new Intent(Splash.this,MainActivity.class);
                startActivity(Splash);
                finish();
            }

        },RUN_TIMEOUT);

    }
}
