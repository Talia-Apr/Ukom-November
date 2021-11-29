package com.taliaapr.wedone;

public class Penyewa {
    private String namaPenyewa;
    private String alamatPenyewa;
    private String bajuPenyewa;
    private String tanggalSewaPenyewa;
    private String tanggalAkhirPenyewa;
    private String hargaSewaBaju;

    public Penyewa(String namaPenyewa, String alamatPenyewa, String bajuPenyewa, String tanggalSewaPenyewa, String tanggalAkhirPenyewa, String hargaSewaBaju) {
        this.namaPenyewa = namaPenyewa;
        this.alamatPenyewa = alamatPenyewa;
        this.bajuPenyewa = bajuPenyewa;
        this.tanggalSewaPenyewa = tanggalSewaPenyewa;
        this.tanggalAkhirPenyewa = tanggalAkhirPenyewa;
        this.hargaSewaBaju = hargaSewaBaju;
    }

    public String getNamaPenyewa() {
        return namaPenyewa;
    }

    public void setNamaPenyewa(String namaPenyewa) {
        this.namaPenyewa = namaPenyewa;
    }

    public String getAlamatPenyewa() {
        return alamatPenyewa;
    }

    public void setAlamatPenyewa(String alamatPenyewa) {
        this.alamatPenyewa = alamatPenyewa;
    }

    public String getBajuPenyewa() {
        return bajuPenyewa;
    }

    public void setBajuPenyewa(String bajuPenyewa) {
        this.bajuPenyewa = bajuPenyewa;
    }

    public String getTanggalSewaPenyewa() {
        return tanggalSewaPenyewa;
    }

    public void setTanggalSewaPenyewa(String tanggalSewaPenyewa) {
        this.tanggalSewaPenyewa = tanggalSewaPenyewa;
    }

    public String getTanggalAkhirPenyewa() {
        return tanggalAkhirPenyewa;
    }

    public void setTanggalAkhirPenyewa(String tanggalAkhirPenyewa) {
        this.tanggalAkhirPenyewa = tanggalAkhirPenyewa;
    }

    public String getHargaSewaBaju() {
        return hargaSewaBaju;
    }

    public void setHargaSewaBaju(String hargaSewaBaju) {
        this.hargaSewaBaju = hargaSewaBaju;
    }

}
