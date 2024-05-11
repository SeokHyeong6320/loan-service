package com.project.loanservice.domain;

import com.project.loanservice.encrypt.Encrypt;
import jakarta.persistence.*;
import lombok.*;

@Entity(name = "USER_INFO")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Encrypt
    @Column(name = "usr_key")
    private String userKey;

    @Encrypt
    @Column(name = "usr_reg_num")
    private String userRegNum;

    @Column(name = "usr_nm")
    private String userName;

    @Column(name = "usr_inc_amt")
    private Long userIncAmount;
}
