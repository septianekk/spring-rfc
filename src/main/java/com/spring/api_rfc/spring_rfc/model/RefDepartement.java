package com.spring.api_rfc.spring_rfc.model;


import jakarta.persistence.*;

@Table(name = "ref_privilege_position")
@Entity
public class RefDepartement {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long ID;

    @Column(name = "Departement")
    private String departement;

    public Long getID() {
        return ID;
    }

    public void setID(Long ID) {
        this.ID = ID;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    @Column(name = "Position")
    private String position;

    @Column(name = "Privilege")
    private String privilege;

}
