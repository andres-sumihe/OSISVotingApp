package com.example.osis;

public class muridModels {
    String nama_murid, pass_murid;
    int nis_murid;

    public muridModels(){

    }

    public muridModels(int nis_murid, String nama_murid, String pass_murid){
        this.nis_murid = nis_murid;
        this.nama_murid = nama_murid;
        this.pass_murid = pass_murid;
    }

    public int getNis_murid(){ return nis_murid; }

    public void setNis_murid(int nis_murid) { this.nis_murid = nis_murid; }

    public String getNama_murid(){ return  nama_murid; }

    public void setNama_murid(String nama_murid) { this.nama_murid = nama_murid; }

    public String getPass_murid() { return pass_murid; }

    public void setPass_murid(String pass_murid) { this.pass_murid = pass_murid; }
}
