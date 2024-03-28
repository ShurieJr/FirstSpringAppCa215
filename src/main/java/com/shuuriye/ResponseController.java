package com.shuuriye;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class ResponseController {
    @GetMapping("/ok")
    public ResponseEntity getOk() {
        //200
        return ResponseEntity.ok("ok message!");
    }

    @GetMapping("/notfound")
    public ResponseEntity getNotFound() {
        //404
        //return ResponseEntity.notFound().build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not found");
    }

    @GetMapping("/badrequest")
    public ResponseEntity getBadRequest() {
        //400 status code
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("bad request");
    }
    @GetMapping("/withHeaders")
    public ResponseEntity getWithHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("custom-message" , "with-headers");
        return ResponseEntity.status(HttpStatus.OK).headers(httpHeaders).body("with-headers example");
    }

    @GetMapping("/error")
    public ResponseEntity getError() {
        //500 status code
        Map<String, String> errorDetails = new HashMap<>();
        errorDetails.put("Error:" , "something went wrong");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDetails);
    }

}
