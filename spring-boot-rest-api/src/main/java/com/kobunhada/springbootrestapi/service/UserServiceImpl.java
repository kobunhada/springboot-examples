package com.kobunhada.springbootrestapi.service;
import com.kobunhada.springbootrestapi.model.User;
import com.kobunhada.springbootrestapi.repository.UserRepository;

import java.util.Optional;
import java.util.List;
import org.springframework.stereotype.Service;

import static com.kobunhada.common.utils.Utils.replaceNullToDefaultValue;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (optionalUser.isEmpty()) {
            throw new Error("This user don't exist..." + "id=" + id);
        }

        return userRepository.findById(id).get();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(Long id, User requestBody) {
        User user = getUser(id);
        user.setFirstName(replaceNullToDefaultValue(
                user.getFirstName(), requestBody.getFirstName())
        );
        user.setFamilyName(replaceNullToDefaultValue(
                user.getFamilyName(), requestBody.getFamilyName())
        );
        user.setAge(requestBody.getAge());
        user.setAddress(replaceNullToDefaultValue(
                user.getAddress(), requestBody.getAddress())
        );
        user.setPhoneNumber(replaceNullToDefaultValue(
                user.getPhoneNumber(), requestBody.getPhoneNumber())
        );

        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        getUser(id);
        userRepository.deleteById(id);
    }
}
