package com.spring.api_rfc.spring_rfc.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class LoginUserDto {

    @NotNull
    @NotBlank
    @NotEmpty
    private String nik;

    public @NotNull @NotBlank @NotEmpty String getNik() {
        return nik;
    }

    public void setNik(@NotNull @NotBlank @NotEmpty String nik) {
        this.nik = nik;
    }

    public @NotNull @NotBlank @NotEmpty String getPassword() {
        return password;
    }

    public void setPassword(@NotNull @NotBlank @NotEmpty String password) {
        this.password = password;
    }

    @NotNull
    @NotBlank
    @NotEmpty
    private String password;

}
