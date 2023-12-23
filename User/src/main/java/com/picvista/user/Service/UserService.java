package com.picvista.user.Service;

import com.picvista.user.Model.User;
import com.picvista.user.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUserById(int user_id) {
        return userRepository.findById(user_id)
                .orElseThrow();
    }
    public Iterable<User> getUsers(){
        return userRepository.findAll();
    }
    public void saveUser(User user) {
        userRepository.save(user);
    }
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}
