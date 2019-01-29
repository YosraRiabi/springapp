package com.riabi.springapp.service;

import com.riabi.springapp.domain.Role;
import com.riabi.springapp.repository.RoleRepository;
import org.springframework.stereotype.Service;

@Service
public class RoleService {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public Role findByName(String name){

        return roleRepository.findByName(name);
    }
}
