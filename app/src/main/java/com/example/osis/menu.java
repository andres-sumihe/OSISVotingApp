package com.example.osis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import java.util.ArrayList;
import java.util.HashMap;

public class menu extends AppCompatActivity {
    Button kembali;
    protected Cursor cursor;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        db = new Database(this);
        ArrayList<HashMap<String, String>> listCalon = db.getAllRecordOSIS();
        Log.d("SIZE", ""+listCalon.size());
        for(int i = 0; i < listCalon.size(); i++){
            String a = listCalon.get(i).get("nama_osis");
            Log.d("Test"+i, a);
        }
        kembali = findViewById(R.id.kembali);
        ListView lv = (ListView) findViewById(R.id.listViewCalon);
        ListAdapter adapter = new SimpleAdapter(menu.this, listCalon, R.layout.listview_calon,new String[]
                {"nama_osis","kelas"}, new int[]{R.id.namaList, R.id.kelasList});
        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listView, View itemView, int itemPosition, long itemId) {
//                int weight = Integer.parseInt(mWeight.getText().toString());
                HashMap<String, String> data = (HashMap<String, String>) lv.getItemAtPosition(itemPosition);
                Intent intent = new Intent(menu.this, TampilanCalon.class );
                intent.putExtra("nama", data.get("nama_osis"));
                intent.putExtra("nis", data.get("nis_osis"));
                intent.putExtra("jk", data.get("jenis_kelamin"));
                intent.putExtra("kelas", data.get("kelas"));
                startActivity(intent);
            }
        });
        kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Kembalisiswa();
            }
        });

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

