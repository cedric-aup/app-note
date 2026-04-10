package com.gestion.note_app.services;

import com.gestion.note_app.models.User;
import com.gestion.note_app.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AuthService {
    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository){
        this.userRepository=userRepository;
    }

    public User register(User user){
        if(userRepository.findByEmail(user.getEmail()).isPresent()){
            throw new RuntimeException("L'utilisateur existe déjà");
        }
        return userRepository.save(user);
    }

    public User login (User user){
        User user1 = userRepository.findByEmail(user.getEmail())
                .orElseThrow(() -> new RuntimeException("Utilisateur Introuvable"));

        if(!user1.getMdp().equals(user.getMdp())){
            throw new RuntimeException("Le mdp est incorrect");
        }
        return user1;

    }



}
