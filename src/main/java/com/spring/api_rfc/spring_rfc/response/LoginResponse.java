package com.spring.api_rfc.spring_rfc.response;

public class LoginResponse {

    private String token;

    private String refreshToken;

    private long expiresIn;

    private String nik;
    private String name;
    private String branch;
    private String division;
    private String departement;
    private String unit;
    private String position;

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSm_code() {
        return sm_code;
    }

    public void setSm_code(String sm_code) {
        this.sm_code = sm_code;
    }

    public String getSm_name() {
        return sm_name;
    }

    public void setSm_name(String sm_name) {
        this.sm_name = sm_name;
    }

    private String level;

    public String getPrivilege() {
        return privilege;
    }

    public void setPrivilege(String privilege) {
        this.privilege = privilege;
    }

    private String sm_code;
    private String sm_name;
    private String privilege;
    
    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public long getExpiresIn() {
        return this.expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getRefreshToken() {
        return this.refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

//    private String token;
//
//    private long expiresIn;
//
//    public LoginResponse setToken(String token) {
//        token = token;
//        return this;
//    }
//
//    public long getExpiresIn() {
//        return expiresIn;
//    }
//
//    public LoginResponse setExpiresIn(long expiresIn) {
//        expiresIn = expiresIn;
//        return this;
//    }
//
//    public String getToken() {
//        return token;
//    }

}
