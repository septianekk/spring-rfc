package com.spring.api_rfc.spring_rfc.dto;

import java.time.LocalDateTime;

public class SignProgrammer {

    private Long requestId;
    private String programmerCode;
    private String programmerName;
    private String modifiedBy;
    private LocalDateTime modifiedDate;

    public Long getRequestId() {
        return requestId;
    }

    public void setRequestId(Long requestId) {
        this.requestId = requestId;
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
