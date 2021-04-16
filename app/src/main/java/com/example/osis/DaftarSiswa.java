package com.example.osis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class DaftarSiswa extends AppCompatActivity {
    EditText namas,niss,passs;
    Button kembalis,inputs;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_siswa);
        db = new Database(this);
        muridModels murid = new muridModels();
        namas = (EditText) findViewById(R.id.namasiswa);
        niss = (EditText) findViewById(R.id.nisiswa);
        passs = (EditText) findViewById(R.id.passsiswa);
        kembalis = (Button) findViewById(R.id.kembalikeadmin1);
        inputs = (Button) findViewById(R.id.inputsiswa);



        inputs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                murid.setNama_murid(namas.getText().toString());
                murid.setNis_murid(niss.getText().toString());
                murid.setPass_murid(passs.getText().toString());
                db.addMurid(murid);
            }
        });
        kembalis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kembaliadmin1();
            }
        });
    }

    public void kembaliadmin1(){
        Intent intent= new Intent(this, MenuAdmin.class);
        startActivity(intent);
    }


}