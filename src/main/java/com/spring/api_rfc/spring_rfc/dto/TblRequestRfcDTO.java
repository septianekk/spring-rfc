package com.spring.api_rfc.spring_rfc.dto;


import java.util.Date;

public class TblRequestRfcDTO {

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
    private Date tglEstimasi;
    private Date tglExecute;

    public String getSqaCode() {
        return sqaCode;
    }

    public void setSqaCode(String sqaCode) {
        this.sqaCode = sqaCode;
    }

    public String getSqaName() {
        return sqaName;
    }

    public void setSqaName(String sqaName) {
        this.sqaName = sqaName;
    }

    private String sqaCode;
    private String sqaName;
    public String getProgrammerCode() {
        return programmerCode;
    }

    public void setProgrammerCode(String programmerCode) {
        this.programmerCode = programmerCode;
    }

    public String getProgrammerName() {
        return programmerName;
    }

    public void setProgrammerName(String programmerName) {
        this.programmerName = programmerName;
    }

    private String programmerCode;
    private String programmerName;
    public String getLingkupTerdampak() {
        return lingkupTerdampak;
    }

    public void setLingkupTerdampak(String lingkupTerdampak) {
        this.lingkupTerdampak = lingkupTerdampak;
    }

    private String lingkupTerdampak;
    public Date getTglExecute() {
        return tglExecute;
    }

    public void setTglExecute(Date tglExecute) {
        this.tglExecute = tglExecute;
    }

    public Date getTglEstimasi() {
        return tglEstimasi;
    }

    public void setTglEstimasi(Date tglEstimasi) {
        this.tglEstimasi = tglEstimasi;
    }

    private String status;
    private String prioritasPengerjaan;

    public String getPrioritasPengerjaan() {
        return prioritasPengerjaan;
    }

    public void setPrioritasPengerjaan(String prioritasPengerjaan) {
        this.prioritasPengerjaan = prioritasPengerjaan;
    }

    public String getKeteranganTambahan2() {
        return keteranganTambahan2;
    }

    public void setKeteranganTambahan2(String keteranganTambahan2) {
        this.keteranganTambahan2 = keteranganTambahan2;
    }

    private String keteranganTambahan2;

    public String getRuangLingkup() {
        return ruangLingkup;
    }

    public void setRuangLingkup(String ruangLingkup) {
        this.ruangLingkup = ruangLingkup;
    }

    private String ruangLingkup;

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
