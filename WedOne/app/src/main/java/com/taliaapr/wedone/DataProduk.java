package com.taliaapr.wedone;

public class DataProduk {
    private String namaBajuProduk;
    private String hargaSewaProduk;
    private String deskripsiProduk;
    private Integer imgBajuProduk;



    public DataProduk(String namaBajuProduk, String hargaSewaProduk, Integer imgBajuProduk, String deskripsiProduk) {
        this.namaBajuProduk = namaBajuProduk;
        this.hargaSewaProduk = hargaSewaProduk;
        this.deskripsiProduk = deskripsiProduk;
        this.imgBajuProduk = imgBajuProduk;
    }

    public String getNamaBajuProduk() {
        return namaBajuProduk;
    }

    public void setNamaBajuProduk(String namaBajuProduk) {
        this.namaBajuProduk = namaBajuProduk;
    }

    public String getHargaSewaProduk() {
        return hargaSewaProduk;
    }

    public void setHargaSewaProduk(String hargaSewaProduk) {
        this.hargaSewaProduk = hargaSewaProduk;
    }

    public String getDeskripsiProduk() {
        return deskripsiProduk;
    }

    public void setDeskripsiProduk(String deskripsiProduk) {
        this.deskripsiProduk = deskripsiProduk;
    }

    public Integer getImgBajuProduk() {
        return imgBajuProduk;
    }

    public void setImgBajuProduk(Integer imgBajuProduk) {
        this.imgBajuProduk = imgBajuProduk;
    }





}
