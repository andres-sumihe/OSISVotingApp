package com.example.osis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;

public class menu extends AppCompatActivity {
    VideoView videoVieW3,videoVieW4;
    Button Pilih1,Pilih2,kembalis;
    ImageButton ImageButton3,ImageButton4;
    private MediaController mediaController;
    protected Cursor cursor;
    //DatabaseHelper databaseHelper;
    TextView text01, text02, text03, text04;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        videoVieW3 = (VideoView) findViewById(R.id.videoView3);
        videoVieW4 = (VideoView) findViewById(R.id.videoView4);
        kembalis = (Button) findViewById(R.id.kembalisiswa);
        Pilih1 = (Button) findViewById(R.id.Pilih1);
        Pilih2 = (Button) findViewById(R.id.Pilih2);
        ImageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        ImageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        text01 = (TextView) findViewById(R.id.textView01);
        text02 = (TextView) findViewById(R.id.textView02);
        text03 = (TextView) findViewById(R.id.textView03);
        text04 = (TextView) findViewById(R.id.textView04);

        ImageButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp1();
            }
        });


        ImageButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp2();
            }
        });
        Pilih1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "Anda memilih kandidat Pertama !", Toast.LENGTH_SHORT).show();
            }
        });
        Pilih2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                Toast.makeText(getApplicationContext(), "Anda memilih kandidat Kedua !", Toast.LENGTH_SHORT).show();
            }
        });

        kembalis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kembalisiswa();
            }
        });

        //databaseHelper = new DatabaseHelper(this);
        //text01 = findViewById(R.id.textView01);
        //text02 = findViewById(R.id.textView02);
        //text03 = findViewById(R.id.textView03);
       // text04 = findViewById(R.id.textView04);
       // SQLiteDatabase db = databaseHelper.getReadableDatabase();
       // cursor = db.rawQuery("SELECT * FROM biodata WHERE nama = '" +
      //          getIntent().getStringExtra("nama") + "'", null);
      //  cursor.moveToFirst();
      //  if (cursor.getCount() > 0) {
       //     cursor.moveToPosition(0);
      //      text01.setText(cursor.getString(0));
        //    text02.setText(cursor.getString(1));
        //    text03.setText(cursor.getString(2));
         //   text04.setText(cursor.getString(3));
      //  }

    }

    public void mp1() {
        mediaController = new MediaController(this);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.mikaila);
        //digunakan untuk mengidentifikasi resource seperti lokasi video
        videoVieW3.setVideoURI(uri);
        videoVieW3.setMediaController(mediaController);
        mediaController.setAnchorView(videoVieW3);
        //menampilkan media controller video
        videoVieW3.start();
    }

    public void mp2() {
        mediaController = new MediaController(this);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.rangga);
        //digunakan untuk mengidentifikasi resource seperti lokasi video
        videoVieW4.setVideoURI(uri);
        videoVieW4.setMediaController(mediaController);
        mediaController.setAnchorView(videoVieW4);
        //menampilkan media controller video
        videoVieW4.start();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    public void Kembalisiswa(){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}

