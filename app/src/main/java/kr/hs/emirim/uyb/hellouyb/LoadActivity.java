package kr.hs.emirim.uyb.hellouyb;

import android.content.Intent;
import android.database.Cursor;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by LG on 2016-11-22.
 */

public class LoadActivity extends AppCompatActivity {
    Intent intent;
    String c_up="";
    String c_down="";
    int up=R.drawable.tra;
    ImageButton edit;
    int down=R.drawable.tra;
    ImageView iv_1,iv_2;
    String p;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load);
        codi.cthflag=1;
        intent=getIntent();
        p=intent.getStringExtra("iv");

        GridActivity.db = GridActivity.dbHelper.getReadableDatabase();
        Cursor rs=GridActivity.db.rawQuery("select * from clothes where time='"+p+"'",null);
        rs.moveToNext();
        c_up=rs.getString(1);
        c_down=rs.getString(2);
        RelativeLayout layout=(RelativeLayout)findViewById(R.id.loadla);
        if(c_up.substring(0,2).equals("pi")) {
           layout.setBackgroundResource(R.drawable.picnicsbg);
        }else if(c_up.substring(0,2).equals("pa")){
            layout.setBackgroundResource(R.drawable.partysbg);
        }else if(c_up.substring(0,1).equals("s")){
            layout.setBackgroundResource(R.drawable.summersbg);
        }else if(c_up.substring(0,1).equals("w")){
            layout.setBackgroundResource(R.drawable.wintersbg);
        }else if(c_up.substring(0,1).equals("c")){
            layout.setBackgroundResource(R.drawable.celebratesbg);
        }
        edit=(ImageButton)findViewById(R.id.edit);
        edit.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Handler handler1=new Handler();
                edit.setImageResource(R.drawable.editbtn_press);
                handler1.postDelayed(new Runnable()
                {
                    @Override
                    public void run() {
                        edit.setImageResource(R.drawable.editbtn);
                    }
                },100);
                if(c_up.substring(0,2).equals("pi")) {
                    Intent intent = new Intent(getApplicationContext(), picnic.class);
                    intent.putExtra("loadtop", up);
                    intent.putExtra("loadpants", down);
                    startActivity(intent);
                }else if(c_up.substring(0,2).equals("pa")){
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("loadtop", up);
                    intent.putExtra("loadpants", down);
                    startActivity(intent);
                }else if(c_up.substring(0,1).equals("s")){
                    Intent intent = new Intent(getApplicationContext(),summer.class);
                    intent.putExtra("loadtop", up);
                    intent.putExtra("loadpants", down);
                    startActivity(intent);
                }else if(c_up.substring(0,1).equals("w")){
                    Intent intent = new Intent(getApplicationContext(),winter.class);
                    intent.putExtra("loadtop", up);
                    intent.putExtra("loadpants", down);
                    startActivity(intent);
                }else if(c_up.substring(0,1).equals("c")){
                    Intent intent = new Intent(getApplicationContext(),celebrate.class);
                    intent.putExtra("loadtop", up);
                    intent.putExtra("loadpants", down);
                    startActivity(intent);
                }
            }
        });
        if(c_up.equals("piu1"))
            up=R.drawable.picnic_up1;
        else if(c_up.equals("piu2"))
            up=R.drawable.picnic_up2;
        else if(c_up.equals("piu3"))
            up=R.drawable.picnic_up3;
        else if(c_up.equals("piu4"))
            up=R.drawable.picnic_up4;
        else if(c_up.equals("piu5"))
            up=R.drawable.picnic_up5;
        else if(c_up.equals("piu6"))
            up=R.drawable.picnic_up6;
        else if(c_up.equals("piu7"))
            up=R.drawable.picnic_up7;
        else if(c_up.equals("piu8"))
            up=R.drawable.picnic_up8;
        else if(c_up.equals("pau1"))
            up=R.drawable.party_up1;
        else if(c_up.equals("pau2"))
            up=R.drawable.party_up2;
        else if(c_up.equals("pau3"))
            up=R.drawable.party_up3;
        else if(c_up.equals("pau4"))
            up=R.drawable.party_up4;
        else if(c_up.equals("pau5"))
            up=R.drawable.party_up5;
        else if(c_up.equals("pau6"))
            up=R.drawable.party_up6;
        else if(c_up.equals("pau7"))
            up=R.drawable.party_up7;
        else if(c_up.equals("pau8"))
            up=R.drawable.party_up8;
        else if(c_up.equals("cu1"))
            up=R.drawable.celebrate_up1;
        else if(c_up.equals("cu2"))
            up=R.drawable.celebrate_up2;
        else if(c_up.equals("cu3"))
            up=R.drawable.celebrate_up3;
        else if(c_up.equals("cu4"))
            up=R.drawable.celebrate_up4;
        else if(c_up.equals("su1"))
            up=R.drawable.summer_up1;
        else if(c_up.equals("su2"))
            up=R.drawable.summer_up2;
        else if(c_up.equals("su3"))
            up=R.drawable.summer_up3;
        else if(c_up.equals("su4"))
            up=R.drawable.summer_up4;
        else if(c_up.equals("su5"))
            up=R.drawable.summer_up5;
        else if(c_up.equals("su6"))
            up=R.drawable.summer_up6;
        else if(c_up.equals("su7"))
            up=R.drawable.summer_up7;
        else if(c_up.equals("su8"))
            up=R.drawable.summer_up8;
        else if(c_up.equals("wu1"))
            up=R.drawable.winter_up1;
        else if(c_up.equals("wu2"))
            up=R.drawable.winter_up2;
        else if(c_up.equals("wu3"))
            up=R.drawable.winter_up3;
        else if(c_up.equals("wu4"))
            up=R.drawable.winter_up4;
        else if(c_up.equals("wu5"))
            up=R.drawable.winter_up5;
        else if(c_up.equals("wu6"))
            up=R.drawable.winter_up6;
        else if(c_up.equals("wu7"))
            up=R.drawable.winter_up7;
        else if(c_up.equals("wu8"))
            up=R.drawable.winter_up8;

        if(c_down.equals("pid1"))
            down=R.drawable.picnic_down1;
        else if(c_down.equals("pid2"))
            down=R.drawable.picnic_down2;
        else if(c_down.equals("pid3"))
            down=R.drawable.picnic_down3;
        else if(c_down.equals("pid4"))
            down=R.drawable.picnic_down4;
        else if(c_down.equals("pid5"))
            down=R.drawable.picnic_down5;
        else if(c_down.equals("pid6"))
            down=R.drawable.picnic_down6;
        else if(c_down.equals("pid7"))
            down=R.drawable.picnic_down7;
        else if(c_down.equals("pid8"))
            down=R.drawable.picnic_down8;
        else if(c_down.equals("cd1"))
            down=R.drawable.celebrate_down1;
        else if(c_down.equals("cd2"))
            down=R.drawable.celebrate_down2;
        else if(c_down.equals("cd3"))
            down=R.drawable.celebrate_down3;
        else if(c_down.equals("cd4"))
            down=R.drawable.celebrate_down4;
        else if(c_down.equals("sd1"))
            down=R.drawable.summer_down1;
        else if(c_down.equals("sd2"))
            down=R.drawable.summer_down2;
        else if(c_down.equals("sd3"))
            down=R.drawable.summer_down3;
        else if(c_down.equals("sd4"))
            down=R.drawable.summer_down4;
        else if(c_down.equals("sd5"))
            down=R.drawable.summer_down5;
        else if(c_down.equals("sd6"))
            down=R.drawable.summer_down6;
        else if(c_down.equals("sd7"))
            down=R.drawable.summer_down7;
        else if(c_down.equals("sd8"))
            down=R.drawable.summer_down8;
        else if(c_down.equals("wd1"))
            down=R.drawable.winter_down1;
        else if(c_down.equals("wd2"))
            down=R.drawable.winter_down2;
        else if(c_down.equals("wd3"))
            down=R.drawable.winter_down3;
        else if(c_down.equals("wd4"))
            down=R.drawable.winter_down4;
        else if(c_down.equals("wd5"))
            down=R.drawable.winter_down5;
        else if(c_down.equals("wd6"))
            down=R.drawable.winter_down6;
        else if(c_down.equals("wd7"))
            down=R.drawable.winter_down7;
        else if(c_down.equals("wd8"))
            down=R.drawable.winter_down8;
        rs.close();
        GridActivity.db.close();

        iv_1=(ImageView)findViewById(R.id.iv_1);
        iv_2=(ImageView)findViewById(R.id.iv_2);

        iv_1.setImageResource(up);
        iv_2.setImageResource(down);

    }
}
