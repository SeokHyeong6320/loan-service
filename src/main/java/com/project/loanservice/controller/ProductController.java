package com.project.loanservice.controller;

import com.project.loanservice.dto.ProductPayload;
import com.project.loanservice.response.DataResponse;
import com.project.loanservice.response.ResponseStatus;
import org.springframework.http.ResponseEntity;

public interface ProductController {

    ResponseEntity<DataResponse> getProductInfo(String organizationCode);

    ResponseEntity<ResponseStatus> obtainProductInfo(ProductPayload productPayload);
}
