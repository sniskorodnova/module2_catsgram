package ru.yandex.practicum.catsgram.controllers;

public class UserAlreadyExistException extends Exception {
    public UserAlreadyExistException(String message) {
        System.out.println(message);
    }
}
