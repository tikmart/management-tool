package am.hitech.controller;

import am.hitech.model.User;
import am.hitech.model.dto.request.UserRequestDto;
import am.hitech.service.UserService;
import am.hitech.util.exception.DuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<User> findById(@RequestParam int id) {
        User user = userService.findById(id);
        return ResponseEntity.ok(user);
    }

    @GetMapping("/get-all")
    public ResponseEntity<?> getAll(@PageableDefault Pageable pageable) {
        Page<User> users = userService.getAll(pageable);
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid UserRequestDto requestDto) throws DuplicateException {

        userService.create(requestDto);
        return ResponseEntity.ok().build();
    }
}
