package com.example.osis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DaftarSiswa extends AppCompatActivity {
    TextView namas,niss,passs;
    Button kembalis,inputs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daftar_siswa);

        namas = (TextView) findViewById(R.id.namasiswa);
        niss = (TextView) findViewById(R.id.nisiswa);
        passs = (TextView) findViewById(R.id.passsiswa);
        kembalis = (Button) findViewById(R.id.kembalikeadmin1);
        inputs = (Button) findViewById(R.id.inputsiswa);

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