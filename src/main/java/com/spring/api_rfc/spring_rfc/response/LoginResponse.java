package com.spring.api_rfc.spring_rfc.response;

public class LoginResponse {

    private String token;

    private String refreshToken;

    private long expiresIn;

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
