package hieu.userservice.service;

import hieu.userservice.dto.ResponseDto;
import hieu.userservice.entity.User;

public interface UserService {
    User saveUser(User user);

    ResponseDto getUser(Long userId);
}
