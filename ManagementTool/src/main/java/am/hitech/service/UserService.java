package am.hitech.service;

import am.hitech.model.User;
import am.hitech.model.dto.request.UserRequestDto;
import am.hitech.util.exception.DuplicateException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    User findById(int id);

    Page<User> getAll(Pageable pageable);


    void create(UserRequestDto requestDto) throws DuplicateException;
}
