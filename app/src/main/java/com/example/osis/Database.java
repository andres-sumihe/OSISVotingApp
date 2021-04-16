package com.example.osis;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

public class Database extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "PemilihanOsis";

    // table murid
    private static final String TABLE_MURID = "murid";

    // column tables murid
    private static final String KEY_NIS_MURID = "nis_murid";
    private static final String KEY_NAMA_MURID = "nama_murid";
    private static final String KEY_PASS_MURID = "pass_murid";

    //table osis
    private static final String TABLE_OSIS = "osis";

    // column tables osis
    private static final String KEY_NIS_OSIS = "nis_osis";
    private static final String KEY_NAMA_OSIS = "nama_osis";
    private static final String KEY_JENIS_KELAMIN = "jenis_kelamin";
    private static final String KEY_KELAS = "kelas";
    private static final String KEY_VOTING_COUNT = "voting_count";

    //table notif
    private static final String TABLE_NOTIF = "notif";

    //column table notif
    private static final String KEY_NOTIF_NO_ID = "notif_no";
    private static final String KEY_JUDUL = "judul";
    private static final String KEY_ISI = "isi";
    private static final String DATABASE_SELECT_USERS = "users";
    //create table
    //murid
    String CREATE_MURID_TABLE = "CREATE TABLE " + TABLE_MURID + "("
            + KEY_NIS_MURID + " TEXT PRIMARY KEY,"
            + KEY_NAMA_MURID + " TEXT,"
            + KEY_PASS_MURID + " TEXT" + ")";
    //osis
    String CREATE_OSIS_TABLE = "CREATE TABLE " + TABLE_OSIS + "("
            + KEY_NIS_OSIS + " INTEGER PRIMARY KEY,"
            + KEY_NAMA_OSIS + " TEXT,"
            + KEY_JENIS_KELAMIN + " TEXT,"
            + KEY_KELAS + " TEXT,"
            + KEY_VOTING_COUNT + " INTEGER" + ")";

    //notif
    String CREATE_NOTIF_TABLE = "CREATE TABLE " + TABLE_NOTIF + "("
            + KEY_NOTIF_NO_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
            + KEY_JUDUL+ " TEXT,"
            + KEY_ISI + " TEXT" + ")";

    public Database(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_MURID_TABLE);
        db.execSQL(CREATE_OSIS_TABLE);
        db.execSQL(CREATE_NOTIF_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_MURID);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_OSIS);
        db.execSQL("DROP TABLE IF EXISTS " +TABLE_NOTIF);
        onCreate(db);
    }

    //Function for table Murid

    //Add Murid
    public void addMurid(muridModels muridModels){
        SQLiteDatabase db  = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NIS_MURID, muridModels.getNis_murid());
        values.put(KEY_NAMA_MURID, muridModels.getNama_murid());
        values.put(KEY_PASS_MURID, muridModels.getPass_murid());
        db.insert(TABLE_MURID, null, values);
    }

    //Read Murid
    public ArrayList<HashMap<String, String>> getAllRecordMurid() {
        ArrayList<HashMap<String, String>> muridList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_MURID;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst())
            do {
            HashMap<String,String> murid = new HashMap<>();
            murid.put("nis_murid", cursor.getString(cursor.getColumnIndex(KEY_NIS_MURID)));
            murid.put("nama_murid", cursor.getString(cursor.getColumnIndex(KEY_NAMA_MURID)));
            murid.put("pass_murid", cursor.getString(cursor.getColumnIndex(KEY_PASS_MURID)));
            muridList.add(murid);
        } while (cursor.moveToNext());
        return muridList;
    }

    //Delete Murid
    public void deleteMuridByNIS(int nis_murid){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_MURID, KEY_NIS_MURID+ " = ?",
                new String[] { String.valueOf(nis_murid)});
        db.close();
    }

    //Function for table OSIS

    //Add OSIS
    public void addOSIS(osisModels osisModels){
        SQLiteDatabase db  = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_NIS_OSIS, osisModels.getNis_osis());
        values.put(KEY_NAMA_OSIS, osisModels.getNama_osis());
        values.put(KEY_JENIS_KELAMIN, osisModels.getJenis_kelamin());
        values.put(KEY_KELAS, osisModels.getKelas());
        values.put(KEY_VOTING_COUNT, osisModels.getVoting_count());
        db.insert(TABLE_OSIS, null, values);
    }

    //Read OSIS
    public ArrayList<HashMap<String, String>> getAllRecordOSIS() {
        ArrayList<HashMap<String, String>> osisList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_OSIS;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            while(!cursor.isAfterLast()){
                HashMap<String,String> osis = new HashMap<>();
                osis.put("nis_osis", cursor.getString(cursor.getColumnIndex(KEY_NIS_OSIS)));
                osis.put("nama_osis", cursor.getString(cursor.getColumnIndex(KEY_NAMA_OSIS)));
                osis.put("jenis_kelamin", cursor.getString(cursor.getColumnIndex(KEY_JENIS_KELAMIN)));
                osis.put("kelas", cursor.getString(cursor.getColumnIndex(KEY_KELAS)));
                osis.put("voting_count", cursor.getString(cursor.getColumnIndex(KEY_VOTING_COUNT)));
                osisList.add(osis);
                cursor.moveToNext();
            }
        };
        return osisList;
    }

    //Delete OSIS
    public void deleteOSISByNIS(int nis_osis){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_OSIS, KEY_NIS_OSIS+ " = ?",
                new String[] { String.valueOf(nis_osis)});
        db.close();
    }

    //Function for table Notif
    //Add Notif
    public void addNotif(notifModels notifModels){
        SQLiteDatabase db  = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_JUDUL, notifModels.getJudul());
        values.put(KEY_ISI, notifModels.getIsi());
        db.insert(TABLE_NOTIF, null, values);
        Log.d("ROW Add", "Berhasil Upload");
        db.close();
    }

    //Read Notif
    public ArrayList<HashMap<String, String>> getAllRecordNotif() {
        ArrayList<HashMap<String, String>> notifList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NOTIF;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                HashMap<String,String> notif = new HashMap<>();
                notif.put("notif_no",cursor.getString(cursor.getColumnIndex(KEY_NOTIF_NO_ID)));
                notif.put("judul",cursor.getString(cursor.getColumnIndex(KEY_JUDUL)));
                notif.put("isi", cursor.getString(cursor.getColumnIndex(KEY_ISI)));
                notifList.add(notif);
            } while (cursor.moveToNext());
        }
        return notifList;
    }

    //Delete Notif
    public void deleteNotifByID(int notif_no_id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(TABLE_NOTIF, KEY_NOTIF_NO_ID+ " = ?",
                new String[] { String.valueOf(notif_no_id)});
        db.close();
    }

    //Delete All Notif
    public void deleteAllNotif(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("delete from "+ TABLE_NOTIF);
    }

    public Cursor fetchUser(String NIS, String pass) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor myCursor = db.query(TABLE_MURID,
                new String[]{KEY_NIS_MURID, KEY_PASS_MURID},
                KEY_NIS_MURID + "='" + NIS + "' AND " +
                        KEY_PASS_MURID + "='" + pass + "'", null, null, null, null);

        if (myCursor != null) {
            myCursor.moveToFirst();
        }
        return myCursor;
    }

    public Database open() throws SQLException {
        SQLiteDatabase db = this.getWritableDatabase();
        return this;
    }


}
