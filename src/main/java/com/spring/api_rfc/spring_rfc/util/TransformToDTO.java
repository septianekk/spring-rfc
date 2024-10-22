package com.spring.api_rfc.spring_rfc.util;


import com.spring.api_rfc.spring_rfc.handler.ResponseHandler;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public class TransformToDTO {
    private String sortBy = "";
    private String sort = "";

    public ResponseEntity<Object> transformObject(Map<String,Object> mapz, List ls, Page page
            , String filterBy, String value, List componentFiltering, HttpServletRequest request)//<PENAMBAHAN 21-12-2023>
    {
        sortBy = page.getSort().toString().split(":")[0];
        sortBy = sortBy.equals("UNSORTED")?"id":sortBy;
        sort   = sortBy.equals("UNSORTED")?"asc":page.getSort().toString().split(":")[1];
        mapz.put("content",ls);
        mapz.put("total_items",page.getTotalElements());
        mapz.put("page_number",page.getNumber());
        mapz.put("total_pages",page.getTotalPages());
        mapz.put("sort",sort.trim().toLowerCase());
        mapz.put("number_of_elements",page.getNumberOfElements());
        mapz.put("column_name",filterBy);
//        mapz.put("component-filter",componentFiltering);
        mapz.put("value",value);
        return new ResponseHandler().
                generateResponse("Permintaan data berhasil",
                        HttpStatus.OK,
                        mapz,
                        null,
                        request);
    }
}
