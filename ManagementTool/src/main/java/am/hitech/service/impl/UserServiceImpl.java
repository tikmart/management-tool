package am.hitech.service.impl;

import am.hitech.model.User;
import am.hitech.model.dto.request.UserRequestDto;
import am.hitech.repository.UserRepository;
import am.hitech.service.UserService;
import am.hitech.util.ErrorMessage;
import am.hitech.util.exception.DuplicateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public User findById(int id) {
        return userRepository.findById(id);

    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        Page<User> users = userRepository.getAll(pageable);
        return users;

    }

    @Override
    public void create(UserRequestDto requestDto) throws DuplicateException {

        if (userRepository.existsByEmail(requestDto.getEmail())) {

            throw new DuplicateException(ErrorMessage.DUPLICATE_EMAIL);
        }
        User user = convertToUser(requestDto, new User());
        userRepository.save(user);
    }

    private User convertToUser(UserRequestDto requestDto, User user) {
        user.setFirstName(requestDto.getFirstName());
        user.setLastName(requestDto.getLastName());
        user.setEmail(requestDto.getEmail());
        user.setPassword(requestDto.getPassword());
        user.setRole(requestDto.getRole());
        user.setStatus(requestDto.getStatus());
        return user;
    }
}
