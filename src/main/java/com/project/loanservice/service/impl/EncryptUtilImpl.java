package com.project.loanservice.service.impl;

import com.project.loanservice.service.EncryptUtil;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EncryptUtilImpl implements EncryptUtil {

    @Override
    public String generateUserKey() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
