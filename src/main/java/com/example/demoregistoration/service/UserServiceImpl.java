package com.example.demoregistoration.service;

import com.example.demoregistoration.entity.User;
import com.example.demoregistoration.repo.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    @Override
    public User saveUser(User user) {
        User newUser = new User();
        newUser.setFName(user.getFName());
        newUser.setLName(user.getLName());
        newUser.setEmail(user.getEmail());
        User addNewUser = userRepo.save(newUser);
        return addNewUser;
    }

    @Override
    public List<User> getAllUsers() {
        List<User> allUsers = userRepo.findAll();
        return allUsers;
    }

    @Override
    public User getUserById(Long id) {
       User UserById = userRepo.findById(id).get();
        return UserById;
    }

    @Override
    public void deleteUser(Long id) {
        userRepo.deleteById(id);

    }
}
