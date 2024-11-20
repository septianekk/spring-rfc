package com.spring.api_rfc.spring_rfc.dto;


import java.time.LocalDateTime;
import java.util.Date;

public class ValidateDto {

    private Long requestId;;
    private String status;
    private String approvalName;
    private String validateNote;
    private String createdBy;
    private String modifiedBy;
    private String sqaCode;
    private String sqaName;

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

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    private String createdDate;
    private LocalDateTime modifiedDate;

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

    private String validateCode;
    private String validateName;

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getApprovalName() {
        return approvalName;
    }

    public void setApprovalName(String approvalName) {
        this.approvalName = approvalName;
    }

    public String getValidateNote() {
        return validateNote;
    }

    public void setValidateNote(String validateNote) {
        this.validateNote = validateNote;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }
}
