package com.project.loanservice.repository;

import com.project.loanservice.domain.Organization;
import com.project.loanservice.domain.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

    List<ProductEntity> findAllByOrganization(Organization organization);
}
