package com.taliaapr.wedone;

public class DataBajuAdat {
    private String namaBajuAdat;
    private String hargaSewaAdat;
    private Integer imgBajuAdat;

    public DataBajuAdat(String namaBajuAdat, String hargaSewaAdat, Integer imgBajuAdat) {
        this.namaBajuAdat = namaBajuAdat;
        this.hargaSewaAdat = hargaSewaAdat;
        this.imgBajuAdat = imgBajuAdat;
    }

    public String getNamaBajuAdat() {
        return namaBajuAdat;
    }

    public void setNamaBajuAdat(String namaBajuAdat) {
        this.namaBajuAdat = namaBajuAdat;
    }

    public String getHargaSewaAdat() {
        return hargaSewaAdat;
    }

    public void setHargaSewaAdat(String hargaSewaAdat) {
        this.hargaSewaAdat = hargaSewaAdat;
    }

    public Integer getImgBajuAdat() {
        return imgBajuAdat;
    }

    public void setImgBajuAdat(Integer imgBajuAdat) {
        this.imgBajuAdat = imgBajuAdat;
    }
}
