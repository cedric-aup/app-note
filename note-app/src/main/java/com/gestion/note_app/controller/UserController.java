package com.gestion.note_app.controller;

import com.gestion.note_app.models.User;
import com.gestion.note_app.services.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gestionApp")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService=userService;
    }

    @GetMapping("/getUserById/{id}")
    public User getUserById (@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("/createdUser")
    public void createdUser(@RequestBody User user){
        userService.createdUser(user);
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable Long id){
        userService.deleteById(id);
    }

    @GetMapping("/listUsers")
    public List<User> listUsers() {
        return userService.listUsers();
    }
}
