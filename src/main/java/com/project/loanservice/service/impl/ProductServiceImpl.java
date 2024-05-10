package com.project.loanservice.service.impl;

import com.project.loanservice.repository.ProductRepository;
import com.project.loanservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
}
