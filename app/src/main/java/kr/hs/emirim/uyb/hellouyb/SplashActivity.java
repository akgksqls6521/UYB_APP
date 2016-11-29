package kr.hs.emirim.uyb.hellouyb;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;

public class SplashActivity extends ActionBarActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_splash);



        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), menu.class);
                startActivity(intent);
                finish();
            }
        }, 3000);


    }


}