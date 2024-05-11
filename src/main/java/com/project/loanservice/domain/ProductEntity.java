package com.project.loanservice.domain;

import com.project.loanservice.converter.OrganizationCodeConverter;
import com.project.loanservice.converter.ProductConverter;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "PRODUCT_INFO")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prod_id")
    private Long id;

    @Convert(converter = OrganizationCodeConverter.class)
    @Column(name = "org_cd")
    private Organization organization;

    @Convert(converter = ProductConverter.CodeConverter.class)
    @Column(name = "prod_cd")
    private Product prodCode;

    @Convert(converter = ProductConverter.NameConverter.class)
    @Column(name = "prod_nm")
    private Product prodName;

    @Column(name = "prod_min_intr")
    private Double minInterest;

    @Column(name = "prod_max_intr")
    private Double maxInterest;




    /**
     * product name, code 값 동시에 넣어주기 위해 Builder 패턴 커스텀
     */
    @Builder
    public ProductEntity(
            Long id,
            Organization organization,
            Product product,
            Double minInterest, Double maxInterest
    ) {
        this.id = id;
        this.organization = organization;
        this.prodCode = product;
        this.prodName = product;
        this.minInterest = minInterest;
        this.maxInterest = maxInterest;
    }
}
