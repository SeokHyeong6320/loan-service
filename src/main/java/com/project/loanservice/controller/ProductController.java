package com.project.loanservice.controller;

import com.project.loanservice.dto.ProductInput;
import com.project.loanservice.response.Response;
import com.project.loanservice.response.ResponseStatus;
import org.springframework.http.ResponseEntity;

public interface ProductController {

    ResponseEntity<Response> getProductInfo(String organizationCode);

    ResponseEntity<ResponseStatus> obtainProductInfo(ProductInput productInput);
}
