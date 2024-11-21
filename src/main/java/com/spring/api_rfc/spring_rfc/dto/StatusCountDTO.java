package com.spring.api_rfc.spring_rfc.dto;

public class StatusCountDTO {

    private String status;
    private int countPending;
    private int countOnprogress;
    private int countCompleted;

    // Getter and Setter methods

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCountPending() {
        return countPending;
    }

    public void setCountPending(int countPending) {
        this.countPending = countPending;
    }

    public int getCountOnprogress() {
        return countOnprogress;
    }

    public void setCountOnprogress(int countOnprogress) {
        this.countOnprogress = countOnprogress;
    }

    public int getCountCompleted() {
        return countCompleted;
    }

    public void setCountCompleted(int countCompleted) {
        this.countCompleted = countCompleted;
    }

}
