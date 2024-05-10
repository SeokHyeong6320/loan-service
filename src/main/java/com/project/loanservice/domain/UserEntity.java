package com.project.loanservice.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "USER_INFO")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "usr_key")
    private String userKey;

    @Column(name = "usr_reg_num")
    private String userRegNum;

    @Column(name = "usr_nm")
    private String userName;

    @Column(name = "usr_inc_amt")
    private String userIncAmount;
}
