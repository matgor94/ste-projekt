package com.matgor94.ste_projket.Domain.Repository;

import com.matgor94.ste_projket.Domain.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository  extends JpaRepository<User, Long> {
    Optional<User> findUserByEmail(String email);
}
