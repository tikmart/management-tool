package am.hitech.service.impl;

import am.hitech.model.Role;
import am.hitech.model.User;
import am.hitech.repository.RoleRepository;
import am.hitech.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Role findById(int id) {
        return roleRepository.findById(id);
    }

    @Override
    public Page<Role> getAll(Pageable pageable) {
        Page<Role> roles = roleRepository.getAll(pageable);
        return roles;

    }
}
