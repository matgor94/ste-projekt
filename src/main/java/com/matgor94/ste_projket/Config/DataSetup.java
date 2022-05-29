package com.matgor94.ste_projket.Config;

import com.matgor94.ste_projket.Domain.Model.User;
import com.matgor94.ste_projket.Domain.Repository.UserRepository;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.atomic.AtomicBoolean;

@Component
public class DataSetup {
    private AtomicBoolean atomicBoolean = new AtomicBoolean(false);
    private final UserRepository userRepository;

    public DataSetup(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    @EventListener
    public void loadData(ContextRefreshedEvent contextRefreshedEvent){
        if(!atomicBoolean.getAndSet(true)){
            User user = new User(null, "94070900444", "Mateusz", "Górczyński", "maly316@vp.pl", "123456789", "Baboszewo 50", "haslo123", "ROLE_USER");
            userRepository.save(user);

            User user1 = new User(null, "85121218957", "Jan", "Kowalski", "jankowlaski@wp.pl","758963254", "Płock, Płońska 30", "qwerty123", "ROLE_USER");
            userRepository.save(user1);
        }
    }
}
