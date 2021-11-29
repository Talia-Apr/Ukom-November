package com.taliaapr.wedone;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class History {
    @SerializedName("idorder")
    @Expose
    private Integer idorder;
    @SerializedName("idpelanggan")
    @Expose
    private Integer idpelanggan;
    @SerializedName("namatoko")
    @Expose
    private String namatoko;
    @SerializedName("alamattoko")
    @Expose
    private String alamattoko;
    @SerializedName("namabaju")
    @Expose
    private String namabaju;
    @SerializedName("tglorder")
    @Expose
    private String tglorder;
    @SerializedName("tglkembali")
    @Expose
    private String tglkembali;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("bayar")
    @Expose
    private Integer bayar;
    @SerializedName("kembali")
    @Expose
    private Integer kembali;
    @SerializedName("status")
    @Expose
    private Integer status;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("pelanggan")
    @Expose
    private String pelanggan;
    @SerializedName("alamat")
    @Expose
    private String alamat;
    @SerializedName("telp")
    @Expose
    private String telp;

    public Integer getIdorder() {
        return idorder;
    }

    public void setIdorder(Integer idorder) {
        this.idorder = idorder;
    }

    public Integer getIdpelanggan() {
        return idpelanggan;
    }

    public void setIdpelanggan(Integer idpelanggan) {
        this.idpelanggan = idpelanggan;
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

    public String getNamabaju() {
        return namabaju;
    }

    public void setNamabaju(String namabaju) {
        this.namabaju = namabaju;
    }

    public String getTglorder() {
        return tglorder;
    }

    public void setTglorder(String tglorder) {
        this.tglorder = tglorder;
    }

    public String getTglkembali() {
        return tglkembali;
    }

    public void setTglkembali(String tglkembali) {
        this.tglkembali = tglkembali;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getBayar() {
        return bayar;
    }

    public void setBayar(Integer bayar) {
        this.bayar = bayar;
    }

    public Integer getKembali() {
        return kembali;
    }

    public void setKembali(Integer kembali) {
        this.kembali = kembali;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public String getPelanggan() {
        return pelanggan;
    }

    public void setPelanggan(String pelanggan) {
        this.pelanggan = pelanggan;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getTelp() {
        return telp;
    }

    public void setTelp(String telp) {
        this.telp = telp;
    }

//    private String namaTokoHistory;
//    private String alamatTokoHistory;
//    private String bajuSewaHistory;
//    private String tanggalSewaHistory;
//    private String tanggalAkhirHistory;
//    private String hargaSewaHistory;
//
//    public History(String namaTokoHistory, String alamatTokoHistory, String bajuSewaHistory,
//                   String tanggalSewaHistory, String tanggalAkhirHistory, String hargaSewaHistory) {
//        this.namaTokoHistory = namaTokoHistory;
//        this.alamatTokoHistory = alamatTokoHistory;
//        this.bajuSewaHistory = bajuSewaHistory;
//        this.tanggalSewaHistory = tanggalSewaHistory;
//        this.tanggalAkhirHistory = tanggalAkhirHistory;
//        this.hargaSewaHistory = hargaSewaHistory;
//    }
//
//    public String getNamaTokoHistory() {
//        return namaTokoHistory;
//    }
//
//    public void setNamaTokoHistory(String namaTokoHistory) {
//        this.namaTokoHistory = namaTokoHistory;
//    }
//
//    public String getAlamatTokoHistory() {
//        return alamatTokoHistory;
//    }
//
//    public void setAlamatTokoHistory(String alamatTokoHistory) {
//        this.alamatTokoHistory = alamatTokoHistory;
//    }
//
//    public String getBajuSewaHistory() {
//        return bajuSewaHistory;
//    }
//
//    public void setBajuSewaHistory(String bajuSewaHistory) {
//        this.bajuSewaHistory = bajuSewaHistory;
//    }
//
//    public String getHargaSewaHistory() {
//        return hargaSewaHistory;
//    }
//
//    public void setHargaSewaHistory(String hargaSewaHistory) {
//        this.hargaSewaHistory = hargaSewaHistory;
//    }
//
//    public String getTanggalSewaHistory() {
//        return tanggalSewaHistory;
//    }
//
//    public void setTanggalSewaHistory(String tanggalSewaHistory) {
//        this.tanggalSewaHistory = tanggalSewaHistory;
//    }
//
//    public String getTanggalAkhirHistory() {
//        return tanggalAkhirHistory;
//    }
//
//    public void setTanggalAkhirHistory(String tanggalAkhirHistory) {
//        this.tanggalAkhirHistory = tanggalAkhirHistory;
//    }

}
