package com.taliaapr.wedone;

import android.content.Intent;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DataBaju {
    @SerializedName("idmenu")
    @Expose
    private Integer idmenu;
    @SerializedName("idtoko")
    @Expose
    private Integer idtoko;
    @SerializedName("idkategori")
    @Expose
    private Integer idkategori;
    @SerializedName("menu")
    @Expose
    private String menu;
    @SerializedName("gambar")
    @Expose
    private String gambar;
    @SerializedName("fototoko")
    @Expose
    private String fototoko;
    @SerializedName("namatoko")
    @Expose
    private String namatoko;
    @SerializedName("alamattoko")
    @Expose
    private String alamattoko;
    @SerializedName("deskripsi")
    @Expose
    private String deskripsi;
    @SerializedName("harga")
    @Expose
    private Integer harga;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("kategori")
    @Expose
    private String kategori;

    public Integer getIdmenu() {
        return idmenu;
    }

    public void setIdmenu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public Integer getIdtoko() {
        return idtoko;
    }

    public void setIdtoko(Integer idtoko) {
        this.idtoko = idtoko;
    }

    public Integer getIdkategori() {
        return idkategori;
    }

    public void setIdkategori(Integer idkategori) {
        this.idkategori = idkategori;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getFototoko() {
        return fototoko;
    }

    public void setFototoko(String fototoko) {
        this.fototoko = fototoko;
    }

    public String getNamatoko() {
        return namatoko;
    }

    public void setNamatoko(String namatoko) {
        this.namatoko = namatoko;
    }

    public String getAlamattoko() {
        return alamattoko;
    }

    public void setAlamattoko(String alamattoko) {
        this.alamattoko = alamattoko;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public Integer getHarga() {
        return harga;
    }

    public void setHarga(Integer harga) {
        this.harga = harga;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

}
