package com.matgor94.ste_projket.Domain.Service;

import com.matgor94.ste_projket.Domain.Model.User;
import com.matgor94.ste_projket.Domain.Repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@Repository
@Slf4j
public class UserService {
    @PersistenceContext
    protected EntityManager entityManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }


    public User addUser(User user){
        String passwordEncoded = passwordEncoder.encode(user.getPassword());
        user.setPassword(passwordEncoded);
        return userRepository.save(user);
    }

    public User getUser(Long id){
        return entityManager.find(User.class, id);
    }

    public List<User> getListOfUsers(){
        return userRepository.findAll();
    }
    public User editUser(User user){
        return entityManager.merge(user);
    }

    public void deleteUser(User user){
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
    }

    public Optional<User> userByEmail(String email){
        return userRepository.findUserByEmail(email);
    }
}
