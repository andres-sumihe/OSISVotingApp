package com.example.osis;

public class muridModels {
    String nama_murid, pass_murid, nis_murid;

    public muridModels(){

    }

    public muridModels(String nis_murid, String nama_murid, String pass_murid){
        this.nis_murid = nis_murid;
        this.nama_murid = nama_murid;
        this.pass_murid = pass_murid;
    }

    public String getNis_murid(){ return nis_murid; }

    public void setNis_murid(String nis_murid) { this.nis_murid = nis_murid; }

    public String getNama_murid(){ return  nama_murid; }

    public void setNama_murid(String nama_murid) { this.nama_murid = nama_murid; }

    public String getPass_murid() { return pass_murid; }

    public void setPass_murid(String pass_murid) { this.pass_murid = pass_murid; }
}
