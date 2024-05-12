package com.project.loanservice.dto;

import com.project.loanservice.domain.Organization;
import com.project.loanservice.domain.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPayload {

    private String organizationCode;
    private String productCode;
    private Double productMaximumInterest;
    private Double productMinimumInterest;
    private String productName;

    public ProductDto toDto() {
        return ProductDto.builder()
                .organization(Organization.fromCode(organizationCode))
                .product(
                        Product.findProduct(productName, productCode)
                )
                .maxInterest(productMaximumInterest)
                .minInterest(productMinimumInterest)
                .build();
    }

    public static ProductPayload fromDto(ProductDto productDto) {
        return ProductPayload.builder()
                .organizationCode(productDto.getOrganization().getCode())
                .productCode(productDto.getProduct().getCode())
                .productMaximumInterest(productDto.getMaxInterest())
                .productMinimumInterest(productDto.getMinInterest())
                .productName(productDto.getProduct().getName())
                .build();
    }


}
