package com.project.loanservice.controller.impl;

import com.project.loanservice.controller.ProductController;
import com.project.loanservice.dto.ProductInput;
import com.project.loanservice.response.Response;
import com.project.loanservice.response.ResponseStatus;
import com.project.loanservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fintech/v1/product")
@RequiredArgsConstructor
public class ProductControllerImpl implements ProductController {

    private final ProductService productService;

    @Override
    @GetMapping("/{organizationCode}")
    public ResponseEntity<Response> getProductInfo
            (@PathVariable String organizationCode) {


        return ResponseEntity.ok(
                new Response(null, ResponseStatus.onSuccess())
        );
    }

    @PostMapping("/information")
    public ResponseEntity<ResponseStatus> obtainProductInfo(
            @RequestBody ProductInput productInput
            ) {

        return ResponseEntity.ok(ResponseStatus.onSuccess());
    }


}
