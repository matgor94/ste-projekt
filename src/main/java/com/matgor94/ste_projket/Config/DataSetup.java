package com.matgor94.ste_projket.Config;

import com.matgor94.ste_projket.Domain.Model.User;
import com.matgor94.ste_projket.Domain.Repository.UserRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class DataSetup {
    private AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;


    public DataSetup(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @EventListener
    public void loadData(ContextRefreshedEvent contextRefreshedEvent){
        if(!atomicBoolean.getAndSet(true)){
            String password = passwordEncoder.encode("haslo123");
            User user = new User(null, "94070900444", "Mateusz", "Górczyński", "maly316@vp.pl", "123456789", "Baboszewo 50", password, 2550.45, "ROLE_USER");
            userRepository.save(user);

            String password1 = passwordEncoder.encode("qwerty123");
            User user1 = new User(null, "85121218957", "Jan", "Kowalski", "jankowlaski@wp.pl","758963254", "Płock, Płońska 30", password1, 8759.47, "ROLE_USER");
            userRepository.save(user1);
        }
    }
}
