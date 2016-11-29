package kr.hs.emirim.uyb.hellouyb;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class success extends AppCompatActivity implements View.OnClickListener {
    ImageButton share, save, clo;
    RelativeLayout layout;
    ImageView top,pants,mane;
    String strDate;
    int topp,pantsp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        menu.flag=1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.success);
        share = (ImageButton) findViewById(R.id.share);
        save = (ImageButton) findViewById(R.id.save);
        clo = (ImageButton) findViewById(R.id.clo);
        //main = (ImageButton) findViewById(R.id.main);
        share.setOnClickListener(this);
        save.setOnClickListener(this);
        clo.setOnClickListener(this);
        Intent intent = getIntent();
        topp= intent.getExtras().getInt("top");
        pantsp = intent.getExtras().getInt("pants");
        int bg=intent.getExtras().getInt("bg");
        layout=(RelativeLayout)findViewById(R.id.rela);
        layout.setBackgroundResource(bg);
        top=(ImageView)findViewById(R.id.cth_top);
        pants=(ImageView)findViewById(R.id.cth_pants);
        top.setImageResource(topp);
        if(pantsp==0){
            pants.setImageResource(0);
        }else pants.setImageResource(pantsp);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.share) {
            share.setImageResource(R.drawable.facebookbtn_press);
            Handler handler1=new Handler();
            handler1.postDelayed(new Runnable()
            {
                @Override
                public void run() {
                    share.setImageResource(R.drawable.facebookbtn);
                }
            },100);
            String str_name="uyb_"+strDate; //이름을 가져온다.
            //File fileRoute = null;
            //fileRoute = Environment.getExternalStorageDirectory(); //sdcard 파일경로 선언
            File files = new File("/sdcard/uyb/"+str_name+".jpg"); //temp폴더에 이름으로 저장된 jpeg파일 경로 선언
            if(files.exists()==true)  //파일유무확인
            {
                File dirName = new File("/sdcard/uyb/");  //디렉토리를 지정합니다.
                String ima = str_name; //공유할 이미지 파일 명
                File file = new File(dirName, ima); //image 파일의 경로를 설정합니다.
                Uri mSaveImageUri = Uri.fromFile(file); //file의 경로를 uri로 변경합니다.
                Intent intent = new Intent(Intent.ACTION_SEND); //전송 메소드를 호출합니다. Intent.ACTION_SEND
                intent.setType("image/jpg"); //jpg 이미지를 공유 하기 위해 Type을 정의합니다.
                intent.setType("text/plain");
                intent.putExtra(intent.EXTRA_TEXT,"내가 만든 어여쁜 코디를 보시라요");
                intent.putExtra(Intent.EXTRA_STREAM, mSaveImageUri); //사진의 Uri를 가지고 옵니다.
                startActivity(Intent.createChooser(intent, "Choose")); //Activity를 이용하여 호출 합니다.
                /*Intent intentSend  = new Intent(Intent.ACTION_SEND);
                //intentSend.setType("image/jpg");
//이름으로 저장된 파일의 경로를 넣어서 공유하기
                //intentSend.putExtra(Intent.EXTRA_STREAM, Uri.parse("/sdcard/uyb"+str_name+".jpg"));
               //startActivity(Intent.createChooser(intentSend, "공유")); //공유하기 창 띄우기

                boolean fbAppFound = false;
                List<ResolveInfo> resolveInfoList = getPackageManager().queryIntentActivities(intentSend, 0);
                for (ResolveInfo info : resolveInfoList) {
                    // 페이스북 패키지명이 com.facebook.katana 인데 바뀔 가능성은 거의 0
                    // 페이스북 메신저 앱은 com.facebook.orca
                    if (info.activityInfo.packageName.toLowerCase().startsWith("com.facebook.katana")) {
                        intentSend.setPackage(info.activityInfo.packageName);
                        fbAppFound = true;
                        break;
                    }
                }*/
            }else{
//파일이 없다면 저장을 해달라는 토스트메세지를 띄운다.
                Toast.makeText(getApplicationContext(), "갤러리에 저장을 먼저 해주세요", Toast.LENGTH_LONG).show();
            }

        }else if(v.getId()==R.id.save) {

            layout = (RelativeLayout) findViewById(R.id.rela);
            share.setImageResource(0);
            save.setImageResource(0);
            clo.setImageResource(0);
            try {
                Handler handler1=new Handler();
                handler1.postDelayed(new Runnable()
                {
                    @Override
                    public void run() {
                        layout = (RelativeLayout) findViewById(R.id.rela);
                        share.setImageResource(R.drawable.facebookbtn);
                        save.setImageResource(R.drawable.gallerysavebtn);
                        clo.setImageResource(R.drawable.closetsavebtn);
                    }
                },100);
                View v1 = layout.getRootView();
                v1.setDrawingCacheEnabled(true);
                Bitmap bm = v1.getDrawingCache();
                screenshot(bm);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (v.getId() == R.id.clo) {
            Handler handler1 = new Handler();
            clo.setImageResource(R.drawable.closetsavebtn_press);
            handler1.postDelayed(new Runnable() {
                @Override
                public void run() {
                    clo.setImageResource(R.drawable.closetsavebtn);
                }
            }, 100);
            if (GridActivity.colnum >= 6) {
                menu.flag=0;
                Toast.makeText(getApplicationContext(), "옷장이 꽉 찼습니다! 초기화 해주세요", Toast.LENGTH_LONG).show();

            } else {
                if (strDate == null) {
                    Toast.makeText(getApplicationContext(), "갤러리에 저장을 먼저 해주세요", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(success.this, GridActivity.class);
                    intent.putExtra("top", topp);
                    intent.putExtra("pants", pantsp);
                    intent.putExtra("str", strDate);
                    startActivity(intent);
                }
            }
        }
    }
    public void screenshot(Bitmap bm) {
        try {

            SimpleDateFormat formatter=new SimpleDateFormat("yy-MM-dd-hh-mm-ss");
            Date today=new Date();
            strDate=formatter.format(today);
            File path = new File("/sdcard/uyb");  //파일디렉토리명입력
            if (!path.isDirectory()) {
                path.mkdirs();
            }
            String temp = "/sdcard/uyb";   //파일디렉토리명입력
            temp = temp + "/uyb_"+strDate;
            temp = temp + ".jpg";
            FileOutputStream out = new FileOutputStream(temp);
            bm=Bitmap.createBitmap(bm,70,100,700,1050);
            bm.compress(Bitmap.CompressFormat.JPEG, 100, out);
            Toast.makeText(getApplicationContext(),"저장완료", Toast.LENGTH_SHORT).show();
            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://"+temp)));

        } catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(),"저장실패", Toast.LENGTH_SHORT).show();
            Log.d("FileNotFoundException:", e.getMessage());
        }
    }
}