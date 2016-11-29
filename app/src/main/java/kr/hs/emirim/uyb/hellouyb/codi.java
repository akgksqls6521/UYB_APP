package kr.hs.emirim.uyb.hellouyb;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

/**
 * Created by Hansung on 2016-10-31.
 */

public class codi extends AppCompatActivity implements View.OnClickListener {
    ImageButton picnic,party,celebrate,summer,winter;
    Handler handler1=new Handler();
    private final long FINISH_INTERVAL_TIME = 2000;
    private long backPressedTime = 0;
    static int cthflag=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.codi);

        picnic=(ImageButton)findViewById(R.id.picnic);
        party=(ImageButton)findViewById(R.id.party);
        celebrate=(ImageButton)findViewById(R.id.celebrate);
        summer=(ImageButton)findViewById(R.id.summer);
        winter=(ImageButton)findViewById(R.id.winter);
        picnic.setOnClickListener(this);
        party.setOnClickListener(this);
        celebrate.setOnClickListener(this);
        summer.setOnClickListener(this);
        winter.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.picnic) {
            picnic.setImageResource(R.drawable.picnicbtn_press);
            Intent intent = new Intent(codi.this,picnic.class);
            handler1.postDelayed(new Runnable()
            {
                @Override
                public void run() {
                    picnic.setImageResource(R.drawable.picnicbtn);
                }
            },100);
            startActivity(intent);
            finish();
        }
        else if(v.getId()==R.id.party) {
            party.setImageResource(R.drawable.partybtn_press);
            Intent intent = new Intent(codi.this, MainActivity.class);
            handler1.postDelayed(new Runnable()
            {
                @Override
                public void run() {
                    party.setImageResource(R.drawable.partybtn);
                }
            },100);
            startActivity(intent);
            finish();
        }else if(v.getId()==R.id.celebrate) {
            celebrate.setImageResource(R.drawable.celebratebtn_press);
            Intent intent = new Intent(codi.this, celebrate.class);
            handler1.postDelayed(new Runnable()
            {
                @Override
                public void run() {
                    celebrate.setImageResource(R.drawable.celebratebtn);
                }
            },100);
            startActivity(intent);
            finish();
        }
        else if(v.getId()==R.id.summer) {
            summer.setImageResource(R.drawable.summerbtn_press);
            Intent intent = new Intent(codi.this, summer.class);
            handler1.postDelayed(new Runnable()
            {
                @Override
                public void run() {
                    summer.setImageResource(R.drawable.summerbtn);
                }
            },100);
            startActivity(intent);
            finish();
        }
        else if(v.getId()==R.id.winter) {
            winter.setImageResource(R.drawable.winterbtn_press);
            Intent intent = new Intent(codi.this, winter.class);
            handler1.postDelayed(new Runnable()
            {
                @Override
                public void run() {
                    winter.setImageResource(R.drawable.winterbtn);
                }
            },100);
            startActivity(intent);
            finish();
        }
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
            Toast.makeText(getApplicationContext(), "한번 더 누르시면 메인으로 돌아가요!", Toast.LENGTH_SHORT).show();
        }
    }
}
