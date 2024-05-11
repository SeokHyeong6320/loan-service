package com.project.loanservice.controller.impl;

import com.project.loanservice.controller.ProductController;
import com.project.loanservice.dto.ProductPayload;
import com.project.loanservice.response.DataResponse;
import com.project.loanservice.response.ResponseStatus;
import com.project.loanservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fintech/v1/product")
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;

    @Override
    @GetMapping("/{organizationCode}")
    public ResponseEntity<DataResponse> getProductInfo
            (@PathVariable String organizationCode) {

        List<ProductPayload> productPayloads =
                productService.getProductInfo(organizationCode);


        return ResponseEntity.ok(
                new DataResponse(productPayloads, ResponseStatus.onSuccess())
        );
    }

    @PostMapping("/information")
    public ResponseEntity<ResponseStatus> obtainProductInfo(
            @RequestBody ProductPayload productPayload
            ) {

        productService.saveProductInfo(productPayload);

        return ResponseEntity.ok(ResponseStatus.onSuccess());
    }


}
