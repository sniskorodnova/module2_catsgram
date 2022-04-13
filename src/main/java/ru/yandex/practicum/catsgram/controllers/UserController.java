package ru.yandex.practicum.catsgram.controllers;

import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.catsgram.models.User;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@RestController
public class UserController {
    private HashSet<User> users = new HashSet<>();

    @GetMapping("/users")
    public HashSet<User> getAllUsers() {
        return users;
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        try {
            if (user.getEmail() == null || user.getEmail().isBlank()) {
                throw new InvalidEmailException("Почта не может быть пустой.");
            } else {
                if (!users.contains(user)) {
                    users.add(user);
                } else {
                    throw new UserAlreadyExistException("Пользователь с такой почтой уже существует.");
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @PutMapping("/users")
    public void editUser(@RequestBody User user) {
        try {
            if (user.getEmail() == null || user.getEmail().isBlank()) {
                throw new InvalidEmailException("Почта не может быть пустой.");
            } else {
                if (!users.contains(user)) {
                    users.add(user);
                } else {
                    users.remove(user);
                    users.add(user);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
