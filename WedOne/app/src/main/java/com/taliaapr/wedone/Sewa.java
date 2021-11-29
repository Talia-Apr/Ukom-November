package com.taliaapr.wedone;

public class Sewa {
    private String namaBajuSewa;
    private String hargaPerSewa;
    private Integer imgBajuSewa;

    public Sewa(String namaBajuSewa, String hargaPerSewa, Integer imgBajuSewa) {
        this.namaBajuSewa = namaBajuSewa;
        this.hargaPerSewa = hargaPerSewa;
        this.imgBajuSewa = imgBajuSewa;
    }

    public String getNamaBajuSewa() {
        return namaBajuSewa;
    }

    public void setNamaBajuSewa(String namaBajuSewa) {
        this.namaBajuSewa = namaBajuSewa;
    }

    public String getHargaPerSewa() {
        return hargaPerSewa;
    }

    public void setHargaPerSewa(String hargaPerSewa) {
        this.hargaPerSewa = hargaPerSewa;
    }

    public Integer getImgBajuSewa() {
        return imgBajuSewa;
    }

    public void setImgBajuSewa(Integer imgBajuSewa) {
        this.imgBajuSewa = imgBajuSewa;
    }




}
