package com.example.osis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DaftarOsis extends AppCompatActivity {
    EditText namao,niso,kelaso,jeniso;
    Button inputo,kembalio;
    Database db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_osis);
        osisModels osis = new osisModels();
        db = new Database(this);
        namao = (EditText) findViewById(R.id.namaosis);
        niso = (EditText) findViewById(R.id.nisosis);
        kelaso = (EditText) findViewById(R.id.kelasosis);
        jeniso = (EditText) findViewById(R.id.jenisosis);
        inputo = (Button) findViewById(R.id.inputosis);
        kembalio = (Button) findViewById(R.id.kembalikeadmin2);

        inputo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                osis.setNama_osis(namao.getText().toString());
                osis.setNis_osis(Integer.parseInt(niso.getText().toString()));
                osis.setKelas(kelaso.getText().toString());
                osis.setJenis_kelamin(jeniso.getText().toString());
                db.addOSIS(osis);
            }
        });
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