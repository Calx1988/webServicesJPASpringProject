package webservices_springboot_jpa.webservices_springboot_jpa.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import webservices_springboot_jpa.webservices_springboot_jpa.entities.User;
import webservices_springboot_jpa.webservices_springboot_jpa.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> optionalUser = userRepository.findById(id);
        return optionalUser.get();
    }
}
