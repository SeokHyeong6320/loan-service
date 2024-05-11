package com.project.loanservice.dto;

import com.project.loanservice.domain.Organization;
import com.project.loanservice.domain.Product;
import com.project.loanservice.domain.ProductEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private Organization organization;

    private Product product;

    private Double minInterest;

    private Double maxInterest;


    public ProductEntity toEntity() {
        return ProductEntity.builder()
                .organization(organization)
                .product(product)
                .minInterest(minInterest)
                .maxInterest(maxInterest)
                .build();
    }

    public static ProductDto fromEntity(ProductEntity entity) {
        return ProductDto.builder()
                .organization(entity.getOrganization())
                .product(entity.getProdCode())
                .maxInterest(entity.getMaxInterest())
                .minInterest(entity.getMinInterest())
                .build();
    }


}
