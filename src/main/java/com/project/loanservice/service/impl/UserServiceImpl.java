package com.project.loanservice.service.impl;

import com.project.loanservice.repository.UserRepository;
import com.project.loanservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
}
