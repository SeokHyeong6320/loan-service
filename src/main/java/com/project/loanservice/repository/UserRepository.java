package com.project.loanservice.repository;

import com.project.loanservice.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Optional<UserEntity> findByUserKey(String userKey);

    boolean existsByUserRegNum(String regNum);

}
