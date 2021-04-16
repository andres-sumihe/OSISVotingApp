package com.example.osis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MenuAdmin extends AppCompatActivity {
    Button btnKembali;
    ImageButton siswaa,osiss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_admin);

        btnKembali = (Button) findViewById(R.id.kembaliadmin);
        siswaa = (ImageButton) findViewById(R.id.siswa);
        osiss = (ImageButton) findViewById(R.id.osis);

        btnKembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                kembaliadmin();
            }
        });

        siswaa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                daftarSiswa();
            }
        });

        osiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                daftarOsis();
            }
        });

    }

    public void kembaliadmin(){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }
    public void daftarOsis(){
        Intent intent= new Intent(this, DaftarOsis.class);
        startActivity(intent);
    }
    public void daftarSiswa(){
        Intent intent= new Intent(this, DaftarSiswa.class);
        startActivity(intent);
    }


}