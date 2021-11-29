package com.taliaapr.wedone;

public class DataBajuToko {
    private String namaBajuToko;
    private String hargaSewaToko;
    private Integer imgBajuToko;

    public String getNamaBajuToko() {
        return namaBajuToko;
    }

    public void setNamaBajuToko(String namaBajuToko) {
        this.namaBajuToko = namaBajuToko;
    }

    public String getHargaSewaToko() {
        return hargaSewaToko;
    }

    public void setHargaSewaToko(String hargaSewaToko) {
        this.hargaSewaToko = hargaSewaToko;
    }

    public Integer getImgBajuToko() {
        return imgBajuToko;
    }

    public void setImgBajuToko(Integer imgBajuToko) {
        this.imgBajuToko = imgBajuToko;
    }

    public DataBajuToko(String namaBajuToko, String hargaSewaToko, Integer imgBajuToko) {
        this.namaBajuToko = namaBajuToko;
        this.hargaSewaToko = hargaSewaToko;
        this.imgBajuToko = imgBajuToko;
    }


}
