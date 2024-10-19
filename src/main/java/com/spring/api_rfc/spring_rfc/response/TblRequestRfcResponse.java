package com.spring.api_rfc.spring_rfc.response;


import java.util.Date;

public class TblRequestRfcResponse {

    private Long requestId;
    private String nik;
    private String nama;
    private String divisi;
    private String namaSistem;
    private String deskripsi;
    private String kategoriPerubahan;
    private String alasanPerubahan;
    private String dampak;
    private Date tglRequest;
    private String status;

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getDivisi() {
        return divisi;
    }

    public void setDivisi(String divisi) {
        this.divisi = divisi;
    }

    public String getNamaSistem() {
        return namaSistem;
    }

    public void setNamaSistem(String namaSistem) {
        this.namaSistem = namaSistem;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getKategoriPerubahan() {
        return kategoriPerubahan;
    }

    public void setKategoriPerubahan(String kategoriPerubahan) {
        this.kategoriPerubahan = kategoriPerubahan;
    }

    public String getAlasanPerubahan() {
        return alasanPerubahan;
    }

    public void setAlasanPerubahan(String alasanPerubahan) {
        this.alasanPerubahan = alasanPerubahan;
    }

    public String getDampak() {
        return dampak;
    }

    public void setDampak(String dampak) {
        this.dampak = dampak;
    }

    public Date getTglRequest() {
        return tglRequest;
    }

    public void setTglRequest(Date tglRequest) {
        this.tglRequest = tglRequest;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
