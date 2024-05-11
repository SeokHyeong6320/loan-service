package com.project.loanservice.service;

import com.project.loanservice.dto.ProductDto;
import com.project.loanservice.dto.ProductPayload;

import java.util.List;

public interface ProductService {
    List<ProductPayload> getProductInfo(String organizationCode);

    void saveProductInfo(ProductPayload productPayload);
}
