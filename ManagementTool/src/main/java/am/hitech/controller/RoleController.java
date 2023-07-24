package am.hitech.controller;

import am.hitech.model.Role;
import am.hitech.model.User;
import am.hitech.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public ResponseEntity<Role> getById(@RequestParam int id) {
        Role role = roleService.findById(id);

        return ResponseEntity.ok(role);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(@PageableDefault Pageable pageable) {
        Page<Role> roles = roleService.getAll(pageable);
        return ResponseEntity.ok(roles);
    }

}
