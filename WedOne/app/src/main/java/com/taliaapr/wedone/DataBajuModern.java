package com.taliaapr.wedone;

public class DataBajuModern {
    private String namaBajuModern;
    private String hargaSewaModern;
    private Integer imgBajuModern;

    public String getNamaBajuModern() {
        return namaBajuModern;
    }

    public void setNamaBajuModern(String namaBajuModern) {
        this.namaBajuModern = namaBajuModern;
    }

    public String getHargaSewaModern() {
        return hargaSewaModern;
    }

    public void setHargaSewaModern(String hargaSewaModern) {
        this.hargaSewaModern = hargaSewaModern;
    }

    public Integer getImgBajuModern() {
        return imgBajuModern;
    }

    public void setImgBajuModern(Integer imgBajuModern) {
        this.imgBajuModern = imgBajuModern;
    }

    public DataBajuModern(String namaBajuModern, String hargaSewaModern, Integer imgBajuModern) {
        this.namaBajuModern = namaBajuModern;
        this.hargaSewaModern = hargaSewaModern;
        this.imgBajuModern = imgBajuModern;
    }


}
