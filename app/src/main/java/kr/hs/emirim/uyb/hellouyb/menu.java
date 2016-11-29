package kr.hs.emirim.uyb.hellouyb;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;
import java.util.logging.LogRecord;

/**
 * Created by Hansung on 2016-10-31.
 */

public class menu extends AppCompatActivity implements View.OnClickListener {
    static int flag=0;
    ImageButton codi,bogi,devel,sound;
    Handler handler1=new Handler();
    private final long FINISH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;
    private static MediaPlayer mp;
    int chk=0;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);

        codi=(ImageButton)findViewById(R.id.start);
        bogi=(ImageButton)findViewById(R.id.closet);
        devel=(ImageButton)findViewById(R.id.devel);
        sound=(ImageButton)findViewById(R.id.sound);
        codi.setOnClickListener(this);
        bogi.setOnClickListener(this);
        devel.setOnClickListener(this);
        sound.setOnClickListener(this);
        mp = MediaPlayer.create(this, R.raw.bgm);
        mp.setLooping(true);
        mp.start();

    }
    @Override
    public void onBackPressed() {
        long tempTime = System.currentTimeMillis();
        long intervalTime = tempTime - backPressedTime;

        if (0 <= intervalTime && FINISH_INTERVAL_TIME >= intervalTime)
        {
            super.onBackPressed();
        }
        else
        {
            backPressedTime = tempTime;
            Toast.makeText(getApplicationContext(), "한번 더 뒤로가기 누르면 안녕이에요!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.closet){
            bogi.setImageResource(R.drawable.closetbtn_press);
            //Toast.makeText(getApplicationContext(), "개발중.", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(menu.this,GridActivity.class);
            startActivity(intent);
            //finish();
           handler1.postDelayed(new Runnable()
            {
                @Override
                public void run() {
                    bogi.setImageResource(R.drawable.closetbtn);
                }
            },100);
        }else if(v.getId()==R.id.start){
            codi.setImageResource(R.drawable.startbtn_press);
            Intent intent=new Intent(menu.this,codi.class);

            handler1.postDelayed(new Runnable()
            {
                @Override
                public void run() {
                    codi.setImageResource(R.drawable.startbtn);
                }
            },100);
            startActivity(intent);
            //finish();
        }else if(v.getId()==R.id.devel){
            Intent intent=new Intent(menu.this,developer.class);
            startActivity(intent);

        }else if(v.getId()==R.id.sound){
           if(mp.isPlaying()) {
               sound.setImageResource(R.drawable.soundoffbtn);
               mp.stop();
               try {
                   mp.prepare();
               } catch (IllegalStateException e) {
                   e.printStackTrace();
               } catch (IOException e) {
                   e.printStackTrace();
               }
           }else{
               sound.setImageResource(R.drawable.soundonbtn);
               mp.start();
           }
        }
    }
    protected void onDestroy() {
        super.onDestroy();
        mp.release();
    }

}
