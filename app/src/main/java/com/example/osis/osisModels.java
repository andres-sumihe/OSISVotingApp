package com.example.osis;

public class osisModels {
    String nama_osis, jenis_kelamin, kelas;
    int nis_osis, voting_count;

    public osisModels(){

    }

    public osisModels(int nis_osis, String nama_osis, String jenis_kelamin, String kelas, int voting_count){
        this.nis_osis = nis_osis;
        this.nama_osis = nama_osis;
        this.jenis_kelamin = jenis_kelamin;
        this.kelas = kelas;
        this.voting_count = voting_count;

    }

    public int getNis_osis(){ return nis_osis; }

    public void setNis_osis(int nis_osis) { this.nis_osis = nis_osis; }

    public String getNama_osis(){ return nama_osis; }

    public void setNama_osis(String nama_osis) { this.nama_osis = nama_osis; }

    public String getJenis_kelamin(){ return jenis_kelamin; }

    public void setJenis_kelamin(String jenis_kelamin) { this.jenis_kelamin = jenis_kelamin; }

    public String getKelas(){ return kelas; }

    public void setKelas(String kelas) { this.kelas = kelas; }

    public int getVoting_count(){ return voting_count; }

    public void setVoting_count(int voting_count) { this.voting_count = voting_count; }
}
