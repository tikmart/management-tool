package am.hitech.service;

import am.hitech.model.Role;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RoleService {
    Role findById(int id);

    Page<Role> getAll(Pageable pageable);
}
