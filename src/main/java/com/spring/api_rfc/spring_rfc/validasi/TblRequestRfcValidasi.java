package com.spring.api_rfc.spring_rfc.validasi;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.Date;

public class TblRequestRfcValidasi {

    private Long requestId;
    @NotEmpty
    @Column(nullable = false)
    @NotNull
    @NotBlank
    @NotEmpty
    private String nik;
    @NotNull
    @NotBlank
    @NotEmpty
    private String nama;
    @NotNull
    @NotBlank
    @NotEmpty
    private String divisi;
    @NotNull
    @NotBlank
    @NotEmpty
    private String namaSistem;
    @NotNull
    @NotBlank
    @NotEmpty
    private String deskripsi;
    @NotNull
    @NotBlank
    @NotEmpty
    private String kategoriPerubahan;
    @NotNull
    @NotBlank
    @NotEmpty
    private String alasanPerubahan;

    public String getRuangLingkup() {
        return ruangLingkup;
    }

    public void setRuangLingkup(String ruangLingkup) {
        this.ruangLingkup = ruangLingkup;
    }

    @NotNull
    @NotBlank
    @NotEmpty
    private String dampak;

    private String ruangLingkup;

    public String getKeteranganTambahan2() {
        return keteranganTambahan2;
    }

    public void setKeteranganTambahan2(String keteranganTambahan2) {
        this.keteranganTambahan2 = keteranganTambahan2;
    }

    @NotNull
    @NotBlank
    @NotEmpty
    private String approvalCode;
    private String keteranganTambahan2;


    public @NotNull @NotBlank @NotEmpty String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(@NotNull @NotBlank @NotEmpty String approvalName) {
        this.approvalName = approvalName;
    }

    public @NotNull @NotBlank @NotEmpty String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(@NotNull @NotBlank @NotEmpty String approvalCode) {
        this.approvalCode = approvalCode;
    }

    @NotNull
    @NotBlank
    @NotEmpty
    private String approvalName;

    public Date getTglRequest() {
        return tglRequest;
    }

    private Date tglRequest;

    public void setTglRequest(Date tglRequest) {
        this.tglRequest = tglRequest;
    }

    private String createdBy;
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private String status;
    @CreationTimestamp
    private String createDate;


    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }


    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public @NotEmpty String getNik() {
        return nik;
    }

    public void setNik(@NotEmpty String nik) {
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

    public @NotNull @NotBlank @NotEmpty String getNamaSistem() {
        return namaSistem;
    }

    public void setNamaSistem(@NotNull @NotBlank @NotEmpty String namaSistem) {
        this.namaSistem = namaSistem;
    }

    public @NotNull @NotBlank @NotEmpty String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(@NotNull @NotBlank @NotEmpty String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public @NotNull @NotBlank @NotEmpty String getKategoriPerubahan() {
        return kategoriPerubahan;
    }

    public void setKategoriPerubahan(@NotNull @NotBlank @NotEmpty String kategoriPerubahan) {
        this.kategoriPerubahan = kategoriPerubahan;
    }

    public @NotNull @NotBlank @NotEmpty String getAlasanPerubahan() {
        return alasanPerubahan;
    }

    public void setAlasanPerubahan(@NotNull @NotBlank @NotEmpty String alasanPerubahan) {
        this.alasanPerubahan = alasanPerubahan;
    }

    public @NotNull @NotBlank @NotEmpty String getDampak() {
        return dampak;
    }

    public void setDampak(@NotNull @NotBlank @NotEmpty String dampak) {
        this.dampak = dampak;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
