package com.spring.api_rfc.spring_rfc.model;

import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Table(name = "user_employee")
@Entity
public class User implements UserDetails{


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Employee_ID;

    @Column(name = "nik", unique = true)
    private String nik;

    private String dsr_code;
    private String referal_code;
    private String name;
    private String date_of_birth;
    private String image_photo;
    private String email;
    private String email_dika;
    private String employee_type;
    private String employee_type_group;
    private String branch;
    private String division;
    private String departement;
    private String unit;
    private String position;
    private String channel;
    private String group_type;
    private String level;
    private String product;
    private String status;
//    private String sm_code;
    @Column(name = "Sm_Code")
    private String smCode;
//    private String sm_name;
    @Column(name = "Sm_Name")
    private String smName;

    @Column(name = "password")
    private String password;
    private String password_pemol;
    private String password_change;
    private String password_reset;

    public String getImage_photo() {
        return image_photo;
    }

    public void setImage_photo(String image_photo) {
        this.image_photo = image_photo;
    }

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    private String token;
    private String privilege;
    public Long getEmployee_ID() {
        return Employee_ID;
    }

    public void setEmployee_ID(Long employee_ID) {
        Employee_ID = employee_ID;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getDsr_code() {
        return dsr_code;
    }

    public void setDsr_code(String dsr_code) {
        this.dsr_code = dsr_code;
    }

    public String getReferal_code() {
        return referal_code;
    }

    public void setReferal_code(String referal_code) {
        this.referal_code = referal_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getImage_Photo() {
        return image_photo;
    }

    public void setImage_Photo(String image_Photo) {
        image_photo = image_Photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail_dika() {
        return email_dika;
    }

    public void setEmail_dika(String email_dika) {
        this.email_dika = email_dika;
    }

    public String getEmployee_type() {
        return employee_type;
    }

    public void setEmployee_type(String employee_type) {
        this.employee_type = employee_type;
    }

    public String getEmployee_type_group() {
        return employee_type_group;
    }

    public void setEmployee_type_group(String employee_type_group) {
        this.employee_type_group = employee_type_group;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getDivision() {
        return division;
    }

    public void setDivision(String division) {
        this.division = division;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getGroup_type() {
        return group_type;
    }

    public void setGroup_type(String group_type) {
        this.group_type = group_type;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

//    public String getSm_code() {
//        return sm_code;
//    }
//
//    public void setSm_code(String sm_code) {
//        this.sm_code = sm_code;
//    }


    public String getSmCode() {
        return smCode;
    }

    public void setSmCode(String smCode) {
        this.smCode = smCode;
    }

//    public String getSm_name() {
//        return sm_name;
//    }
//
//    public void setSm_name(String sm_name) {
//        this.sm_name = sm_name;
//    }


    public String getSmName() {
        return smName;
    }

    public void setSmName(String smName) {
        this.smName = smName;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.nik;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

    @Override
    public boolean isAccountNonLocked() {
        return UserDetails.super.isAccountNonLocked();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return UserDetails.super.isCredentialsNonExpired();
    }

    @Override
    public boolean isEnabled() {
        return UserDetails.super.isEnabled();
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword_pemol() {
        return password_pemol;
    }

    public void setPassword_pemol(String password_pemol) {
        this.password_pemol = password_pemol;
    }

    public String getPassword_change() {
        return password_change;
    }

    public void setPassword_change(String password_change) {
        this.password_change = password_change;
    }

    public String getPassword_reset() {
        return password_reset;
    }

    public void setPassword_reset(String password_reset) {
        this.password_reset = password_reset;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }



}
