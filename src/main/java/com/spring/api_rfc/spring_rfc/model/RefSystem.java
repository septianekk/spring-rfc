package com.spring.api_rfc.spring_rfc.model;


import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Date;

@Table(name = "ref_list_system")
@Entity
public class RefSystem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long System_ID;

    @Column(name = "System_Name")
    private String systemName;

    @Column(name = "Status")
    private String status;

    public RefSystem(String systemName, String status, String created_by, Timestamp created_date) {
        this.systemName = systemName;
        this.status = status;
        this.created_by = created_by;
        this.created_date = created_date;
    }

    public Timestamp getCreated_date(Date date) {
        return created_date;
    }

    public void setCreated_date(Timestamp created_date) {
        this.created_date = created_date;
    }

    public Long getSystem_ID() {
        return System_ID;
    }

    public void setSystem_ID(Long system_ID) {
        System_ID = system_ID;
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

    @Column(name = "Created_Date")
    private Timestamp created_date;

    @Column(name = "Created_By")
    private String created_by;

}
