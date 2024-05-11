package com.project.loanservice.service.impl;

import com.project.loanservice.domain.Organization;
import com.project.loanservice.dto.ProductDto;
import com.project.loanservice.dto.ProductPayload;
import com.project.loanservice.exception.CustomServiceException;
import com.project.loanservice.exception.ErrorCode;
import com.project.loanservice.repository.ProductRepository;
import com.project.loanservice.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CacheManager cacheManager;

    @Override
    @CacheEvict(value = "Products", key = "#productPayload.organizationCode", cacheManager = "redisCacheManager")
    public void saveProductInfo(ProductPayload productPayload) {

        productRepository.save(
                productPayload.toDto().toEntity()
        );
    }



    @Override
    @Cacheable(value = "Products", key = "#organizationCode", cacheManager = "redisCacheManager")
    public List<ProductPayload> getProductInfo(String organizationCode) {

        try {
            Organization organization = Organization.fromCode(organizationCode);

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
