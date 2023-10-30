package com.kaidash.datingapp.service;

import com.kaidash.datingapp.entity.Role;
import com.kaidash.datingapp.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public Role getUserRole() {
        return roleRepository.findByName("USER").get();
    }
}

