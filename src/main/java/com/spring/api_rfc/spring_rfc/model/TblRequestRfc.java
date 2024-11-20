package com.spring.api_rfc.spring_rfc.model;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "tbl_request_rfc")
public class TblRequestRfc {

    @Id
    @Column(name = "Request_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long requestId;
    @Column(name = "NIK", length = 11, unique = true, nullable = false)
    private String nik;
    @Column(name = "Nama", length = 50)
    private String nama;
    @Column(name = "Divisi", length = 50)
    private String divisi;
    @Column(name = "Nama_Sistem", length = 100)
    private String namaSistem;
    @Lob
    @Column(name = "Deskripsi")
    private String deskripsi;
    @Column(name = "Kategori_Perubahan", length = 50)
    private String kategoriPerubahan;
    @Lob
    @Column(name = "Alasan_Perubahan")
    private String alasanPerubahan;
    @Column(name = "Ruang_lingkup", length = 100)
    private String ruangLingkup;
    @Lob
    @Column(name = "Dampak")
    private String dampak;

    @Column(name = "Tgl_Request",insertable = true,updatable = false)
    private Date tglRequest;
    @Column(name = "Tgl_Execute",insertable = true,updatable = false)
    private Date tglExecute;


    @Column(name = "Tgl_Estimasi",insertable = true,updatable = false)
    private Date tglEstimasi;
    @Column(name = "Assign_Code", length = 20)
    private String assignCode;
    @Column(name = "Assign_Name", length = 50)
    private String assignName;
    @Column(name = "Progremmer_Code", length = 20)
    private String programmerCode;
    @Column(name = "Programmer_Name", length = 100)
    private String programmerName;
    @Column(name = "SQA_Code", length = 20)
    private String sqaCode;
    @Column(name = "SQA_Name", length = 50)
    private String sqaName;
    @Lob
    @Column(name = "Lingkup_Terdampak")
    private String lingkupTerdampak;
    @Column(name = "Prioritas_Pengerjaan", length = 20)
    private String prioritasPengerjaan;
    @Column(name = "Evaluasi_Resiko", length = 50)
    private String evaluasiResiko;
    @Column(name = "Estimasi_Durasi_Pengerjaan", length = 50)
    private String estimasiDurasiPengerjaan;
    @Column(name = "Rekomendasi_Alternatif", length = 100)
    private String rekomendasiAlternatif;
    @Lob
    @Column(name = "Keterangan_Tambahan2")
    private String keteranganTambahan2;
    @Column(name = "Bukti_SS_Before")
    private String buktiSsBefore;
    @Column(name = "Bukti_SS_After")
    private String buktiSsAfter;
    @Column(name = "Status", length = 20)
    private String status;
    @Column(name = "Approval_Code", length = 20)
    private String approvalCode;
    @Column(name = "Approval_Name", length = 50)
    private String approvalName;
    @Lob
    @Column(name = "Approval_Note")
    private String approvalNote;
    @Lob
    @Column(name = "Validate_Note")
    private String validateNote;

    @Column(name = "Validate_Code")
    private String validateCode;

    @Column(name = "Validate_Name")
    private String validateName;

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public String getValidateName() {
        return validateName;
    }

    public void setValidateName(String validateName) {
        this.validateName = validateName;
    }

    @UpdateTimestamp
    @Column(name = "Modified_Date",insertable = false,updatable = true)
    private LocalDate modifiedDate;

    public LocalDate getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDate modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @Column(name = "ModifiedBy", length = 50)
    private String modifiedBy;
    @CreationTimestamp
    private Timestamp createdDate;
    @Column(name = "Created_By", length = 50)
    private String createdBy;

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

    public String getRuangLingkup() {
        return ruangLingkup;
    }

    public void setRuangLingkup(String ruangLingkup) {
        this.ruangLingkup = ruangLingkup;
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

    public String getAssignCode() {
        return assignCode;
    }

    public void setAssignCode(String assignCode) {
        this.assignCode = assignCode;
    }

    public String getAssignName() {
        return assignName;
    }

    public void setAssignName(String assignName) {
        this.assignName = assignName;
    }

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

    public String getLingkupTerdampak() {
        return lingkupTerdampak;
    }

    public void setLingkupTerdampak(String lingkupTerdampak) {
        this.lingkupTerdampak = lingkupTerdampak;
    }

    public String getPrioritasPengerjaan() {
        return prioritasPengerjaan;
    }

    public void setPrioritasPengerjaan(String prioritasPengerjaan) {
        this.prioritasPengerjaan = prioritasPengerjaan;
    }

    public String getEvaluasiResiko() {
        return evaluasiResiko;
    }

    public void setEvaluasiResiko(String evaluasiResiko) {
        this.evaluasiResiko = evaluasiResiko;
    }

    public String getEstimasiDurasiPengerjaan() {
        return estimasiDurasiPengerjaan;
    }

    public void setEstimasiDurasiPengerjaan(String estimasiDurasiPengerjaan) {
        this.estimasiDurasiPengerjaan = estimasiDurasiPengerjaan;
    }

    public String getRekomendasiAlternatif() {
        return rekomendasiAlternatif;
    }

    public void setRekomendasiAlternatif(String rekomendasiAlternatif) {
        this.rekomendasiAlternatif = rekomendasiAlternatif;
    }

    public String getKeteranganTambahan2() {
        return keteranganTambahan2;
    }

    public void setKeteranganTambahan2(String keteranganTambahan2) {
        this.keteranganTambahan2 = keteranganTambahan2;
    }

    public String getBuktiSsBefore() {
        return buktiSsBefore;
    }

    public void setBuktiSsBefore(String buktiSsBefore) {
        this.buktiSsBefore = buktiSsBefore;
    }

    public String getBuktiSsAfter() {
        return buktiSsAfter;
    }

    public void setBuktiSsAfter(String buktiSsAfter) {
        this.buktiSsAfter = buktiSsAfter;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
    }

    public String getApprovalNote() {
        return approvalNote;
    }

    public void setApprovalNote(String approvalNote) {
        this.approvalNote = approvalNote;
    }

    public String getValidateNote() {
        return validateNote;
    }

    public void setValidateNote(String validateNote) {
        this.validateNote = validateNote;
    }



    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}
