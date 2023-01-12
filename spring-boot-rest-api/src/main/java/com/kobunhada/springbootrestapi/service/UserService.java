package com.kobunhada.springbootrestapi.service;

import com.kobunhada.springbootrestapi.model.User;

import java.util.List;
import org.springframework.stereotype.Service;
@Service
public interface UserService {
    List<User> getUsers();
    User getUser(Long id);
    User createUser(User user);
    User updateUser(Long id, User user);
    void deleteUser(Long id);
}
