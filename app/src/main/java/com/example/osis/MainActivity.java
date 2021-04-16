package com.example.osis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    Button btnLogin;
    TextView Nis,Pass;
    muridModels mM;
    Database mydb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLogin = (Button) findViewById(R.id.btn_login);
        Nis = (TextView) findViewById(R.id.nis);
        Pass = (TextView) findViewById(R.id.pass);
        mydb = new Database(this);
        mM = new muridModels();

        //mydb.addMurid(new muridModels("10101", "Andres Freixa Sumihe", "andres"));

        ArrayList<HashMap<String, String>> muridList = mydb.getAllRecordMurid();
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Nis.getText().toString().equals("admin") &&
                        Pass.getText().toString().equals("admin")) {

                    //kondisi jika login benar
                    Toast.makeText(getApplicationContext(), "Login Berhasil Selamat Datang Admin", Toast.LENGTH_SHORT).show();
                    OpenmenuAdmin();
                }
                mydb.open();
                Cursor cur = mydb.fetchUser( Nis.getText().toString(), Pass.getText().toString());
                if(cur.getCount()!=0) {
                    String usn1=cur.getString(0);
                    String usn2=cur.getString(1);
                    if(usn1.equals(Nis.getText().toString())&&usn2.equals(Pass.getText().toString())) {
                        //kondisi jika login benar
                        Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                        Openmenu();

                    }
                    else {

                    }
                }else{
                    //jika login gagal
                    Toast.makeText(getApplicationContext(), "Nis atau Password Anda Salah", Toast.LENGTH_SHORT).show();
                }

                /*if (Nis.getText().toString().equals("1") &&
                        Pass.getText().toString().equals("1")) {

                    //kondisi jika login benar
                    Toast.makeText(getApplicationContext(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                    Openmenu();

                } else {
                    //jika login gagal
                    Toast.makeText(getApplicationContext(), "Nis atau Password Anda Salah",
                            Toast.LENGTH_SHORT).show();

                }
                */



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