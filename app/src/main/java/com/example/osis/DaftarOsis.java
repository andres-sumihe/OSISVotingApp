package com.example.osis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DaftarOsis extends AppCompatActivity {
    TextView namao,niso,kelaso,jeniso;
    Button inputo,kembalio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_osis);

        namao = (TextView) findViewById(R.id.namaosis);
        niso = (TextView) findViewById(R.id.nisosis);
        kelaso = (TextView) findViewById(R.id.kelasosis);
        jeniso = (TextView) findViewById(R.id.jenisosis);
        inputo = (Button) findViewById(R.id.inputosis);
        kembalio = (Button) findViewById(R.id.kembalikeadmin2);

        kembalio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kembaliadmin2();
            }
        });
    }

    public void kembaliadmin2(){
        Intent intent= new Intent(this, MenuAdmin.class);
        startActivity(intent);
    }
}