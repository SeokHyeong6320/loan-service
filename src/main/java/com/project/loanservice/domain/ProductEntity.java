package com.project.loanservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "PRODUCT_INFO")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "org_cd")
    private String orgCode;

    @Column(name = "prod_cd")
    private String prodCode;

    @Column(name = "prod_nm")
    private String prodName;

    @Column(name = "prod_min_intr")
    private Double minInterest;

    @Column(name = "prod_max_intr")
    private Double maxInterest;
}
