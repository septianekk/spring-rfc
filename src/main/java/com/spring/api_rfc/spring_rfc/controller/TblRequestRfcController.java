package com.spring.api_rfc.spring_rfc.controller;


import com.spring.api_rfc.spring_rfc.model.TblRequestRfc;
import com.spring.api_rfc.spring_rfc.repo.TblRequestRfcRepository;
import com.spring.api_rfc.spring_rfc.service.TblRequestRfcService;
import com.spring.api_rfc.spring_rfc.validasi.TblRequestRfcValidasi;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api")
public class TblRequestRfcController {

    @Autowired
    private TblRequestRfcService tblRequestRfcService;

    @Autowired
    private TblRequestRfcRepository tblRequestRfcRepository;

    private Map<String,Object> sortMap = new HashMap<>();
    private final String defaultSortingColumnRfc = "id";

    private void setSortMap(){
        sortMap.put("nik", "nik");
        sortMap.put("nama", "nama");
        sortMap.put("divisi", "divisi");
        sortMap.put("nama-sistem", "namaSistem");
        sortMap.put("deskripsi", "deskripsi");
        sortMap.put("kategori-perubahan", "kategoriPerubahan");
        sortMap.put("alasan-perubahan", "alasanPerubahan");
        sortMap.put("tgl-request", "tglRequest");
        sortMap.put("status", "status");
    }

    @GetMapping("/all/{page}/{sort}/{sort-by}")
    public ResponseEntity<Object> findAll(
            @PathVariable(value = "page") Integer page,
            @PathVariable(value = "sort") String sort,
            @PathVariable(value = "sort-by") String sortBy,
            @RequestParam("size") Integer size,
            HttpServletRequest request
    ){
        page = (page==null)?0:page;
        sort   = sort.equalsIgnoreCase("desc")?"desc":"asc";
        Object objSortBy = sortMap.get(sortBy);
        objSortBy = sortMap.get(sortBy)==null?defaultSortingColumnRfc : sortMap.get(sortBy);
        Pageable pageable =  PageRequest.of(page,
                (size==null)?10:size,
                sort.equals("desc")? Sort.by(objSortBy.toString()).descending():Sort.by(sortBy));
        return tblRequestRfcService.findAll(pageable,request);
    }

    @GetMapping("/req/all")
    public ResponseEntity<Object> findAll() {
//        return ResponseEntity.ok(tblRequestRfcService.findAll());
        return null;
    }

    @GetMapping("/req/{request_id}")
    public ResponseEntity<Object> findById(@PathVariable(value = "request_id") Long requestId, HttpServletRequest request) {
        return ResponseEntity.ok(tblRequestRfcService.findById(requestId, request));
    }

    @PostMapping("/insert-req")
    public ResponseEntity<Object> save(@Valid @RequestBody TblRequestRfcValidasi tblRequestRfcValidasi,
                                       HttpServletRequest request) {
        return tblRequestRfcService.save(tblRequestRfcService.convertToEntity(tblRequestRfcValidasi), request);
    }


}
