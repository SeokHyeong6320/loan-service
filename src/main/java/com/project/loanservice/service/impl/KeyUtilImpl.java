package com.project.loanservice.service.impl;

import com.project.loanservice.service.KeyUtil;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class KeyUtilImpl implements KeyUtil {

    @Override
    public String generateUserKey() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}
