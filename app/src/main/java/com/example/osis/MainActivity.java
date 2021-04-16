package com.example.osis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    TextView Nis,Pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btn_login);
        Nis = (TextView) findViewById(R.id.nis);
        Pass = (TextView) findViewById(R.id.pass);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Nis.getText().toString().equals("admin") &&
                        Pass.getText().toString().equals("admin")) {

                    //kondisi jika login benar
                    Toast.makeText(getApplicationContext(), "Login Berhasil Selamat Datang Admin", Toast.LENGTH_SHORT).show();
                    OpenmenuAdmin();

                } if (Nis.getText().toString().equals("1") &&
                        Pass.getText().toString().equals("1")) {

                    //kondisi jika login benar
                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Openmenu();

                } else {
                    //jika login gagal
                    Toast.makeText(getApplicationContext(), "Nis atau Password Anda Salah",
                            Toast.LENGTH_SHORT).show();

                }
            }

        });

    }
    public void Openmenu(){
        Intent intent= new Intent(this, menu.class);
        startActivity(intent);
    }

    public void OpenmenuAdmin(){
        Intent intent= new Intent(this, MenuAdmin.class);
        startActivity(intent);
    }

}