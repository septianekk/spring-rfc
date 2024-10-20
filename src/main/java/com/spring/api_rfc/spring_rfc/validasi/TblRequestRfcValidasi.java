package com.spring.api_rfc.spring_rfc.validasi;


import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.annotation.CreatedDate;

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
    @NotNull
    @NotBlank
    @NotEmpty
    private String dampak;
    @CreatedDate
    private Date tglRequest;

    private String createdBy;
    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    private String status;


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
