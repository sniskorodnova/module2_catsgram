package ru.yandex.practicum.catsgram.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import org.zalando.logbook.Logbook;
import ru.yandex.practicum.catsgram.models.User;
import java.util.HashSet;

@RestController
public class UserController {
    private HashSet<User> users = new HashSet<>();
    private static final Logger log = LoggerFactory.getLogger(PostController.class);
    Logbook logbook = Logbook.create();

    @GetMapping("/users")
    public HashSet<User> getAllUsers() {
        log.debug("Количество пользователей: {}", users.size());
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
