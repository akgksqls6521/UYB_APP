package kr.hs.emirim.uyb.hellouyb;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class winter extends AppCompatActivity {
    ImageButton back, next,downback,downnext;
    ImageView imV,imvDown;
    Gallery gallery;
    int[] selected = new int[20];
    int topposition = 0;
    int pantsposition=0;
    int gotop,godown;
    Intent intent;
    ImageButton button1,button2;
    int[] top_gallery=new int[20];
    int[] pants_gallery=new int[20];
    RelativeLayout layout;
    Bitmap bm;
    int[] top={R.drawable.winter_up1,R.drawable.winter_up2,R.drawable.winter_up3,R.drawable.winter_up4,R.drawable.winter_up5,R.drawable.winter_up6,R.drawable.winter_up7,R.drawable.winter_up8,0};
    int[] pants={R.drawable.winter_down1,R.drawable.winter_down2,R.drawable.winter_down3,R.drawable.winter_down4,R.drawable.winter_down5,R.drawable.winter_down6,R.drawable.winter_down7,R.drawable.winter_down8};
    MyGalleryAdapter adapter = new MyGalleryAdapter(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gallery = (Gallery) findViewById(R.id.gallery_1);
        back = (ImageButton) findViewById(R.id.topback);
        next = (ImageButton) findViewById(R.id.topnext);
        downback=(ImageButton)findViewById(R.id.pantsback);
        downnext=(ImageButton)findViewById(R.id.pantsnext);
        imV = (ImageView) findViewById(R.id.cth_top);
        imvDown=(ImageView)findViewById(R.id.cth_pants);
        layout=(RelativeLayout)findViewById(R.id.rela);
        layout.setBackgroundResource(R.drawable.wintersbg);
        gallery.setAdapter(adapter);
        button1 = (ImageButton) findViewById(R.id.but_1);
        button2=(ImageButton)findViewById(R.id.but_2);
        layout = (RelativeLayout)findViewById(R.id.rela);
        top_gallery[0]=R.drawable.winter_up1_gallery;
        top_gallery[1]=R.drawable.winter_up2_gallery;
        top_gallery[2]=R.drawable.winter_up3_gallery;
        top_gallery[3]=R.drawable.winter_up4_gallery;
        top_gallery[4]=R.drawable.winter_up5_gallery;
        top_gallery[5]=R.drawable.winter_up6_gallery;
        top_gallery[6]=R.drawable.winter_up7_gallery;
        top_gallery[7]=R.drawable.winter_up8_gallery;
        pants_gallery[0]=R.drawable.winter_down1_gallery;
        pants_gallery[1]=R.drawable.winter_down2_gallery;
        pants_gallery[2]=R.drawable.winter_down3_gallery;
        pants_gallery[3]=R.drawable.winter_down4_gallery;
        pants_gallery[4]=R.drawable.winter_down5_gallery;
        pants_gallery[5]=R.drawable.winter_down6_gallery;
        pants_gallery[6]=R.drawable.winter_down7_gallery;
        pants_gallery[7]=R.drawable.winter_down8_gallery;
        if(codi.cthflag==1){
            intent=getIntent();
            int t= intent.getExtras().getInt("loadtop");
            int p = intent.getExtras().getInt("loadpants");
            imV.setImageResource(t);
            imvDown.setImageResource(p);
        }

        button1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Handler handler1=new Handler();
                button1.setImageResource(R.drawable.completebtn_press);
                handler1.postDelayed(new Runnable()
                {
                    @Override
                    public void run() {
                        button1.setImageResource(R.drawable.completebtn);
                    }
                },100);

                intent = new Intent(winter.this,success.class);
                intent.putExtra("bg",R.drawable.wintersbg);
                intent.putExtra("top", gotop);
                intent.putExtra("pants",godown);
                startActivity(intent);
                finish();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Handler handler1=new Handler();
                button2.setImageResource(R.drawable.refreshbtn_press);
                handler1.postDelayed(new Runnable()
                {
                    @Override
                    public void run() {
                        button2.setImageResource(R.drawable.refreshbtn);
                    }
                },100);

                imV.setImageResource(0);
                imvDown.setImageResource(0);
                gotop=0;
                godown=0;
            }
        });

        back.setOnClickListener(new View.OnClickListener() {//이벤트 처리자!-익명클래스를 사용해 핸들러 구현
            @Override
            public void onClick(View v) {
                selected[0]=R.drawable.winter_up1;
                selected[1]=R.drawable.winter_up2;
                selected[2]=R.drawable.winter_up3;
                selected[3]=R.drawable.winter_up4;
                selected[4]=R.drawable.winter_up5;
                selected[5]=R.drawable.winter_up6;
                selected[6]=R.drawable.winter_up7;
                selected[7]=R.drawable.winter_up8;
                if(topposition==0)
                    topposition=top.length-1;
                else
                    topposition--;
                imV.setImageResource(top[topposition]);
                gotop=top[topposition];
                adapter.notifyDataSetChanged();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {//이벤트 처리자!-익명클래스를 사용해 핸들러 구현
            @Override
            public void onClick(View v) {
                selected[0]=R.drawable.winter_up1;
                selected[1]=R.drawable.winter_up2;
                selected[2]=R.drawable.winter_up3;
                selected[3]=R.drawable.winter_up4;
                selected[4]=R.drawable.winter_up5;
                selected[5]=R.drawable.winter_up6;
                selected[6]=R.drawable.winter_up7;
                selected[7]=R.drawable.winter_up8;
                if(topposition==top.length-1)
                    topposition=0;
                else
                    topposition++;

                imV.setImageResource(top[topposition]);
                gotop=top[topposition];
                adapter.notifyDataSetChanged();
            }
        });
        downback.setOnClickListener(new View.OnClickListener() {//이벤트 처리자!-익명클래스를 사용해 핸들러 구현
            @Override
            public void onClick(View v) {
                selected[0]=R.drawable.winter_down1;
                selected[1]=R.drawable.winter_down2;
                selected[2]=R.drawable.winter_down3;
                selected[3]=R.drawable.winter_down4;
                selected[4]=R.drawable.winter_down5;
                selected[5]=R.drawable.winter_down6;
                selected[6]=R.drawable.winter_down7;
                selected[7]=R.drawable.winter_down8;
                adapter.notifyDataSetChanged();
                if(pantsposition==0)
                    pantsposition=pants.length-1;
                else
                    pantsposition--;
                imvDown.setImageResource(pants[pantsposition]);
                godown=pants[pantsposition];
            }
        });

        downnext.setOnClickListener(new View.OnClickListener() {//이벤트 처리자!-익명클래스를 사용해 핸들러 구현
                                        @Override
                                        public void onClick(View v) {
                                            selected[0]=R.drawable.winter_down1;
                                            selected[1]=R.drawable.winter_down2;
                                            selected[2]=R.drawable.winter_down3;
                                            selected[3]=R.drawable.winter_down4;
                                            selected[4]=R.drawable.winter_down5;
                                            selected[5]=R.drawable.winter_down6;
                                            selected[6]=R.drawable.winter_down7;
                                            selected[7]=R.drawable.winter_down8;
                                            adapter.notifyDataSetChanged();
                                            if(pantsposition==pants.length-1)
                                                pantsposition=0;
                                            else
                                                pantsposition++;

                                            imvDown.setImageResource(pants[pantsposition]);
                                            godown=pants[pantsposition];

                                        }
                                    }
        );
    }
    public void screenshot(Bitmap bm) {
        try {
            SimpleDateFormat formatter=new SimpleDateFormat("yy-MM-dd-hh-mm-ss");
            Date today=new Date();
            String strDate=formatter.format(today);
            File path = new File("/sdcard/uyb");  //파일디렉토리명입력
            if (!path.isDirectory()) {
                path.mkdirs();
            }
            String temp = "/sdcard/uyb";   //파일디렉토리명입력
            temp = temp + "/uyb_"+strDate;
            temp = temp + ".jpg";
            FileOutputStream out = new FileOutputStream(temp);
            bm=Bitmap.createBitmap(bm,120,100,550,950);
            bm.compress(Bitmap.CompressFormat.JPEG, 100, out);
            Toast.makeText(getApplicationContext(),"저장완료", Toast.LENGTH_SHORT).show();
            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE,
                    Uri.parse("file://" + Environment.getExternalStorageDirectory())));

        } catch (FileNotFoundException e) {
            Toast.makeText(getApplicationContext(),"저장실패", Toast.LENGTH_SHORT).show();
            Log.d("FileNotFoundException:", e.getMessage());
        }
    }


    public class MyGalleryAdapter extends BaseAdapter {
        //Intent i=getIntent();
        //int [] selected=i.getIntArrayExtra("station");
        // int[] selected=i.getExtras().getIntArray("station");
        Context context;

        MyGalleryAdapter(Context context) {
            this.context = context;//context 는 참조변수로 받은 context값이다
        }

        @Override
        public int getCount() {
            return selected.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ImageView imgV = new ImageView(context.getApplicationContext());//위에 필드를 저장해놨기때문에 .. 이 갤러리가 사용되는 문맥이 필요한데? 이건 마이갤러리어댑터 만들때 저장이 되었구나!
            imgV.setLayoutParams(new Gallery.LayoutParams(100, 150));//px단위임
            imgV.setScaleType(ImageView.ScaleType.FIT_CENTER);//가장자리가 잘릴수도있음
            imgV.setPadding(5, 5, 5, 5);
            if(selected[0]==R.drawable.winter_down1) {
                imgV.setImageResource(pants_gallery[position]);
            }else imgV.setImageResource(top_gallery[position]);
            final int pos = position;
            imgV.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if(selected[0]==0){
                        //String s=Integer.toString(pos);
                        //Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
                        gotop=top[pos];
                        imV.setImageResource(top[pos]);
                    }
                    if(selected[0]==R.drawable.winter_up1) {
                        imV.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        gotop=selected[pos];
                        imV.setImageResource(selected[pos]);//이미지리소스설정
                        return false;
                    }else{
                        imvDown.setScaleType(ImageView.ScaleType.FIT_CENTER);
                        godown=selected[pos];
                        imvDown.setImageResource(selected[pos]);//이미지리소스설정
                        return false;
                    }
                }
            });
            return imgV;
        }
    }
}

