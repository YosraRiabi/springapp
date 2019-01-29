package com.riabi.springapp.service;

import com.riabi.springapp.domain.User;
import com.riabi.springapp.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {

    private final Logger logger = LoggerFactory.getLogger(UserService.class);
   // private final RoleService roleService;
    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    private final RoleService roleService;
    private final MailService mailService;

    public UserService(UserRepository userRepository, RoleService roleService, MailService mailService) {
       // this.roleService = roleService;
        this.userRepository = userRepository;
        this.roleService = roleService;
        this.mailService = mailService;
        encoder = new BCryptPasswordEncoder();
    }

    public User register(User user) {
        //take the password from the form and encode
        String secret = "{bcrypt}" + encoder.encode("password");
        user.setPassword(secret);

        //confirm password
        user.setConfirmPassword(secret);

        //assign a role to this user
        user.addRole(roleService.findByName("ROLE_USER"));

        //set an activation code
        user.setActivationCode(UUID.randomUUID().toString());

        //disable the user

        //save the user

        //send the activation email
        sendActivationEmail(user);

        //return user
        return user;
    }

    public User save(User user){
       return userRepository.save(user);
    }

    @Transactional
    public void saveUsers(User... users) {
        for(User user : users) {
            logger.info("Saving User: " + user.getEmail());
            userRepository.save(user);
        }
    }

    public void sendActivationEmail(User user){
        mailService.sendActivationEmail(user);
    }

    public void sendWelcomeEmail(User user){
        mailService.sendWelcomeEmail(user);
    }

    public Optional<User> findByEmailAndActivationCode(String email, String activationCode){
       return userRepository.findByEmailAndActivationCode(email, activationCode);
    }

}