package com.riabi.springapp.repository;

import com.riabi.springapp.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {

        Optional<User> findByEmail(String email);
}
