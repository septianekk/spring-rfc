package com.spring.api_rfc.spring_rfc.dto;

import java.time.LocalDateTime;
import java.util.Date;

public class SubmitValidateDto {

    private Long requestId;
    private String assignCode;
    private String assignName;
    private String lingkupTerdampak;
    private String prioritasPengerjaan;
    private String evaluasiResiko;

    private LocalDateTime tglExecute;
    private LocalDateTime tglEstimasi;
    private String rekomendasiAlternatif;
    private String validateCode;
    private String validateName;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String modifiedBy;
    private LocalDateTime modifiedDate;

    private String status;

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
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

    public LocalDateTime getTglExecute() {
        return tglExecute;
    }

    public void setTglExecute(LocalDateTime tglExecute) {
        this.tglExecute = tglExecute;
    }

    public LocalDateTime getTglEstimasi() {
        return tglEstimasi;
    }

    public void setTglEstimasi(LocalDateTime tglEstimasi) {
        this.tglEstimasi = tglEstimasi;
    }

    public String getRekomendasiAlternatif() {
        return rekomendasiAlternatif;
    }

    public void setRekomendasiAlternatif(String rekomendasiAlternatif) {
        this.rekomendasiAlternatif = rekomendasiAlternatif;
    }

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

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }





}
