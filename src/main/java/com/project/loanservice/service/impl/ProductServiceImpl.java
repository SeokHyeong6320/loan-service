package com.project.loanservice.service.impl;

import com.project.loanservice.domain.Organization;
import com.project.loanservice.dto.ProductDto;
import com.project.loanservice.dto.ProductPayload;
import com.project.loanservice.exception.CustomServiceException;
import com.project.loanservice.exception.ErrorCode;
import com.project.loanservice.repository.ProductRepository;
import com.project.loanservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional
    public void saveProductInfo(ProductPayload productPayload) {

        productRepository.save(
                productPayload.toDto().toEntity()
        );
    }


    @Override
    @Transactional(readOnly = true)
    public List<ProductPayload> getProductInfo(String organizationCode) {

        try {
            Organization organization = Organization.valueOf(organizationCode);

            return productRepository.findAllByOrganization(organization)
                    .stream()
                    .map(ProductDto::fromEntity)
                    .map(ProductPayload::fromDto)
                    .collect(Collectors.toList());

        } catch (IllegalArgumentException e) {
            throw new CustomServiceException(ErrorCode.PRODUCT_NOT_FOUND);
        }
    }
}
