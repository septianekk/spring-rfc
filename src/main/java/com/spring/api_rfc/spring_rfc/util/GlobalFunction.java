package com.spring.api_rfc.spring_rfc.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.spring.api_rfc.spring_rfc.handler.ResponseHandler;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class GlobalFunction {

    public static ResponseEntity<Object> dataHasSaved(HttpServletRequest request){
        return new ResponseHandler().generateResponse(
                "Data Berhasil ditambahkan",
                HttpStatus.CREATED,
                null,
                null,
                request
        );
    }

    public static ResponseEntity<?> dataFailedToSave(String errorCode, HttpServletRequest request){
        return new ResponseHandler().generateResponse(
                "Data Gagal disimpan",
                HttpStatus.INTERNAL_SERVER_ERROR,
                null,
                errorCode,
                request
        );
    }

    public static ResponseEntity<Object> dataNotFound(HttpServletRequest request){
        return new ResponseHandler().generateResponse(
                "Data Tidak ditemukan",
                HttpStatus.BAD_REQUEST,
                null,
                "X-01-002",
                request
        );
    }

    public static ResponseEntity<Object> dataSuccesRejected(HttpServletRequest request){
        return new ResponseHandler().generateResponse(
                "Data Berhasil di Reject",
                HttpStatus.OK,
                null,
                null,
                request
        );
    }

    public static ResponseEntity<Object> dataSuccesSubmitted(HttpServletRequest request){
        return new ResponseHandler().generateResponse(
                "Data Berhasil di Submit",
                HttpStatus.OK,
                null,
                null,
                request
        );
    }

    public static ResponseEntity<Object> dataListFound(List<?> dataList, HttpServletRequest request) {
        return new ResponseHandler().generateResponse(
                "Data berhasil ditemukan",
                HttpStatus.OK,
                dataList,
                null,
                request
        );
    }

    public static ResponseEntity<Object> dataByIdAlreadyFound(Object object, HttpServletRequest request){
        return new ResponseHandler().generateResponse(
                "Data ditemukan",
                HttpStatus.OK,
                object,
                null,
                request
        );
    }

    public static ResponseEntity<Object> failedToChange(String errorCode, HttpServletRequest request){
        return new ResponseHandler().generateResponse(
                "Data Gagal Validasi",
                HttpStatus.INTERNAL_SERVER_ERROR,
                null,
                errorCode,
                request
        );
    }

    public static ResponseEntity<Object> dataHasChanged(HttpServletRequest request){
        return new ResponseHandler().generateResponse(
                "Data Berhasil diubah",
                HttpStatus.OK,
                null,
                null,
                request
        );
    }

    public static ResponseEntity<Object> validatiFailed(String message, String errorCode, HttpServletRequest request){
        return new ResponseHandler().generateResponse(
                message,
                HttpStatus.BAD_REQUEST,
                null,
                errorCode,
                request
        );
    }

    public static ResponseEntity<Object> cantBeProcessed(String errorCode, HttpServletRequest request){
        return new ResponseHandler().generateResponse(
                "PERMINTAAN TIDAK DAPAT DIPROSES",
                HttpStatus.INTERNAL_SERVER_ERROR,
                null,
                errorCode,
                request
        );
    }

    public static ResponseEntity<Object> deleteFailed(String errorCode, HttpServletRequest request){
        return new ResponseHandler().generateResponse(
                "Data Gagal dihapus",
                HttpStatus.INTERNAL_SERVER_ERROR,
                null,
                errorCode,
                request
        );
    }

    public static ResponseEntity<Object> invalidCredential(HttpServletRequest request) {
        return new ResponseHandler().generateResponse(
              "Password Salah",
                HttpStatus.UNAUTHORIZED,
                null,
                "401",
                request
        );
    }

    public static ResponseEntity<Object> successWithToken(Object object, HttpServletRequest request) {
        return new ResponseHandler().generateResponse(
                "Berhasil Login",
                HttpStatus.OK,
                object,
                "200",
                request
        );
    }

    /**
     *
     * Convert data
     */
    public static String convertObjectToJson(Object object) throws JsonProcessingException {
        if (object == null) {
            return null;
        }
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(object);
    }



}
