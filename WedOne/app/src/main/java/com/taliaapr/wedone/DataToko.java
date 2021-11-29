package com.taliaapr.wedone;

public class DataToko {
    private String imgToko;
    private String namaToko;

    public String getImgToko() {
        return imgToko;
    }

    public void setImgToko(String imgToko) {
        this.imgToko = imgToko;
    }

    public String getNamaToko() {
        return namaToko;
    }

    public void setNamaToko(String namaToko) {
        this.namaToko = namaToko;
    }

    public DataToko(String imgToko, String namaToko) {
        this.imgToko = imgToko;
        this.namaToko = namaToko;
    }


}
