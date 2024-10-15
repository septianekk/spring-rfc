package com.spring.api_rfc.spring_rfc.model;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

@Table(name = "ref_list_system")
@Entity
public class RefSystem {

    @Id
//    @Column(name = "system_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long systemId;

    @Column(name = "System_Name")
    private String systemName;

    @Column(name = "Status")
    private String status;

    public RefSystem(String systemName, String status, String created_by, Date createdDate) {
        this.systemName = systemName;
        this.status = status;
        this.created_by = created_by;
        this.createdDate = createdDate;
    }

    public RefSystem() {

    }

    public Long getSystemId() {
        return systemId;
    }

    public void setSystemId(Long systemId) {
        this.systemId = systemId;
    }

    public String getSystemName() {
        return systemName;
    }

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated_by() {
        return created_by;
    }

    public void setCreated_by(String created_by) {
        this.created_by = created_by;
    }

    //    @Column(name = "created_date")
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    @CreationTimestamp
    private Date createdDate;

    @Column(name = "Created_By")
    private String created_by;

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getCreatedDate(String createdBy) {
        return createdDate;
    }
}
