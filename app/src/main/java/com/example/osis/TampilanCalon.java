package com.example.osis;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class TampilanCalon extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView namaCalon = (TextView) findViewById(R.id.namaCalonTampilan);
        TextView nisCalon = (TextView) findViewById(R.id.nisCalon);
        TextView jenisCalon = (TextView) findViewById(R.id.jenisKelaminTampilan);
        TextView kelasCalon = (TextView) findViewById(R.id.kelasCalonTampilan);
        Intent intent = getIntent();
        String nama = intent.getStringExtra("nama");
        String nis = intent.getStringExtra("nis");
        String jenis = intent.getStringExtra("jk");
        String kelas = intent.getStringExtra("kelas");
        Log.d("Data", nama + " " + nis + " " + jenis + " " + kelas + " " );

    }
}

