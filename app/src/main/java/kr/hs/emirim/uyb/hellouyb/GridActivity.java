package kr.hs.emirim.uyb.hellouyb;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

/**
 * Created by LG on 2016-11-22.
 */

public class GridActivity extends AppCompatActivity implements View.OnClickListener{
    ImageView iv_1,iv_2,iv_3,iv_4,iv_5,iv_6;
    String s_1,s_2,s_3,s_4,s_5,s_6;
    Intent intent;
    static int colnum;
    static MyDBHelper dbHelper;
    static SQLiteDatabase db;
    String t;
    int up,down;
    String strDate;
    String c_up,c_down;
    ImageButton reset;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        iv_1 = (ImageView) findViewById(R.id.iv_1);
        iv_2 = (ImageView) findViewById(R.id.iv_2);
        iv_3 = (ImageView) findViewById(R.id.iv_3);
        iv_4 = (ImageView) findViewById(R.id.iv_4);
        iv_5 = (ImageView) findViewById(R.id.iv_5);
        iv_6 = (ImageView) findViewById(R.id.iv_6);
        reset=(ImageButton)findViewById(R.id.reset);
        dbHelper = new MyDBHelper(getApplicationContext());
        reset.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Handler handler1=new Handler();
                reset.setImageResource(R.drawable.resetbtn_press);
                handler1.postDelayed(new Runnable()
                {
                    @Override
                    public void run() {
                        reset.setImageResource(R.drawable.resetbtn);
                    }
                },100);
                //dbHelper.onUpgrade(db,1,2);
                db=dbHelper.getWritableDatabase();
                db.delete("clothes",null,null);
                db.execSQL("DELETE FROM clothes");
                //String sql="delete from clothes;";
                //db.execSQL(sql);
                iv_1.setImageResource(0);
                iv_2.setImageResource(0);
                iv_3.setImageResource(0);
                iv_4.setImageResource(0);
                iv_5.setImageResource(0);
                iv_6.setImageResource(0);
            }
        });
        if(menu.flag==1) {
            Intent intent = getIntent();
            up = intent.getExtras().getInt("top");
            down = intent.getExtras().getInt("pants");
            strDate = intent.getExtras().getString("str");

            if (strDate != null) {
                if (up == R.drawable.picnic_up1)
                    c_up = "piu1";
                else if (up == R.drawable.picnic_up2)
                    c_up = "piu2";
                else if (up == R.drawable.picnic_up3)
                    c_up = "piu3";
                else if (up == R.drawable.picnic_up4)
                    c_up = "piu4";
                else if (up == R.drawable.picnic_up5)
                    c_up = "piu5";
                else if (up == R.drawable.picnic_up6)
                    c_up = "piu6";
                else if (up == R.drawable.picnic_up7)
                    c_up = "piu7";
                else if (up == R.drawable.picnic_up8)
                    c_up = "piu8";
                else if (up == R.drawable.party_up1)
                    c_up = "pau1";
                else if (up == R.drawable.party_up2)
                    c_up = "pau2";
                else if (up == R.drawable.party_up3)
                    c_up = "pau3";
                else if (up == R.drawable.party_up4)
                    c_up = "pau4";
                else if (up == R.drawable.party_up5)
                    c_up = "pau5";
                else if (up == R.drawable.party_up6)
                    c_up = "pau6";
                else if (up == R.drawable.party_up7)
                    c_up = "pau7";
                else if (up == R.drawable.party_up8)
                    c_up = "pau8";
                else if (up == R.drawable.celebrate_up1)
                    c_up = "cu1";
                else if (up == R.drawable.celebrate_up2)
                    c_up = "cu2";
                else if (up == R.drawable.celebrate_up3)
                    c_up = "cu3";
                else if (up == R.drawable.celebrate_up4)
                    c_up = "cu4";
                else if (up == R.drawable.summer_up1)
                    c_up = "su1";
                else if (up == R.drawable.summer_up2)
                    c_up = "su2";
                else if (up == R.drawable.summer_up3)
                    c_up = "su3";
                else if (up == R.drawable.summer_up4)
                    c_up = "su4";
                else if (up == R.drawable.summer_up5)
                    c_up = "su5";
                else if (up == R.drawable.summer_up6)
                    c_up = "su6";
                else if (up == R.drawable.summer_up7)
                    c_up = "su7";
                else if (up == R.drawable.summer_up8)
                    c_up = "su8";
                else if (up == R.drawable.winter_up1)
                    c_up = "wu1";
                else if (up == R.drawable.winter_up2)
                    c_up = "wu2";
                else if (up == R.drawable.winter_up3)
                    c_up = "wu3";
                else if (up == R.drawable.winter_up4)
                    c_up = "wu4";
                else if (up == R.drawable.winter_up5)
                    c_up = "wu5";
                else if (up == R.drawable.winter_up6)
                    c_up = "wu6";
                else if (up == R.drawable.winter_up7)
                    c_up = "wu7";
                else if (up == R.drawable.winter_up8)
                    c_up = "wu8";

                if (down == R.drawable.picnic_down1)
                    c_down = "pid1";
                else if (down == R.drawable.picnic_down2)
                    c_down = "pid2";
                else if (down == R.drawable.picnic_down3)
                    c_down = "pid3";
                else if (down == R.drawable.picnic_down4)
                    c_down = "pid4";
                else if (down == R.drawable.picnic_down5)
                    c_down = "pid5";
                else if (down == R.drawable.picnic_down6)
                    c_down = "pid6";
                else if (down == R.drawable.picnic_down7)
                    c_down = "pid7";
                else if (down == R.drawable.picnic_down8)
                    c_down = "pid8";
                else if (down == R.drawable.celebrate_down1)
                    c_down = "cd1";
                else if (down == R.drawable.celebrate_down2)
                    c_down = "cd2";
                else if (down == R.drawable.celebrate_down3)
                    c_down = "cd3";
                else if (down == R.drawable.celebrate_down4)
                    c_down = "cd4";
                else if (down == R.drawable.summer_down1)
                    c_down = "sd1";
                else if (down == R.drawable.summer_down2)
                    c_down = "sd2";
                else if (down == R.drawable.summer_down3)
                    c_down = "sd3";
                else if (down == R.drawable.summer_down4)
                    c_down = "sd4";
                else if (down == R.drawable.summer_down5)
                    c_down = "sd5";
                else if (down == R.drawable.summer_down6)
                    c_down = "sd6";
                else if (down == R.drawable.summer_down7)
                    c_down = "sd7";
                else if (down == R.drawable.summer_down8)
                    c_down = "sd8";
                else if (down == R.drawable.winter_down1)
                    c_down = "wd1";
                else if (down == R.drawable.winter_down2)
                    c_down = "wd2";
                else if (down == R.drawable.winter_down3)
                    c_down = "wd3";
                else if (down == R.drawable.winter_down4)
                    c_down = "wd4";
                else if (down == R.drawable.winter_down5)
                    c_down = "wd5";
                else if (down == R.drawable.winter_down6)
                    c_down = "wd6";
                else if (down == R.drawable.winter_down7)
                    c_down = "wd7";
                else if (down == R.drawable.winter_down8)
                    c_down = "wd8";

                db = dbHelper.getWritableDatabase();
                db.execSQL("insert into clothes values('" + strDate + "', '" + c_up + "', '" + c_down + "');");
                db.close();
                Toast.makeText(getApplicationContext(), "옷장에 저장완료", Toast.LENGTH_LONG).show();
                menu.flag=0;
            }
        }

        db = dbHelper.getReadableDatabase();
        Cursor rs=db.rawQuery("select * from clothes",null);

        while(rs.moveToNext()){

            File files = new File("/sdcard/uyb/uyb_" + rs.getString(0) + ".jpg"); //temp폴더에 이름으로 저장된 jpeg파일 경로 선언
            if (files.exists() == true)  //파일유무확인
            {
                //Toast.makeText(getApplicationContext(), "김민선", Toast.LENGTH_LONG).show();
                Bitmap myBitmap = BitmapFactory.decodeFile(files.getAbsolutePath());
                switch (rs.getPosition()) {
                    case 0:
                        iv_1.setImageBitmap(myBitmap);
                        s_1=rs.getString(0);
                        break;
                    case 1:
                        iv_2.setImageBitmap(myBitmap);
                        s_2=rs.getString(0);
                        break;
                    case 2:
                        iv_3.setImageBitmap(myBitmap);
                        s_3=rs.getString(0);
                        break;
                    case 3:
                        iv_4.setImageBitmap(myBitmap);
                        s_4=rs.getString(0);
                        break;
                    case 4:
                        iv_5.setImageBitmap(myBitmap);
                        s_5=rs.getString(0);
                        break;
                    case 5:
                        iv_6.setImageBitmap(myBitmap);
                        s_6=rs.getString(0);
                        break;
                }
            } else {
//파일이 없다면 저장을 해달라는 토스트메세지를 띄운다.
                Toast.makeText(getApplicationContext(), "저장을 먼저 해주세요", Toast.LENGTH_LONG).show();
            }
        }
        db.close();

        iv_1.setOnClickListener(this);
        iv_2.setOnClickListener(this);
        iv_3.setOnClickListener(this);
        iv_4.setOnClickListener(this);
        iv_5.setOnClickListener(this);
        iv_6.setOnClickListener(this);

        colnum=rs.getCount();
    }



    @Override
    public void onClick(View view) {
        intent=new Intent(getApplicationContext(),LoadActivity.class);

        switch (view.getId()){
            case R.id.iv_1:
                intent.putExtra("iv",s_1);
                break;
            case R.id.iv_2:
                intent.putExtra("iv",s_2);
                break;
            case R.id.iv_3:
                intent.putExtra("iv",s_3);
                break;
            case R.id.iv_4:
                intent.putExtra("iv",s_4);
                break;
            case R.id.iv_5:
                intent.putExtra("iv",s_5);
                break;
            case R.id.iv_6:
                intent.putExtra("iv",s_6);
                break;
        }
        startActivity(intent);
        finish();
    }

    public class MyDBHelper extends SQLiteOpenHelper {
        public MyDBHelper(Context context){
            super(context,"clothesdb",null,3);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("create table clothes(time char(15) primary key, up char(5),down char(5));");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("drop table if exists clothes");
            onCreate(db);
        }
    }
}