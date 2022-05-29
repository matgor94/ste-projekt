package com.matgor94.ste_projket.Domain.Repository;

import com.matgor94.ste_projket.Domain.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository  extends JpaRepository<User, Long> {
}
