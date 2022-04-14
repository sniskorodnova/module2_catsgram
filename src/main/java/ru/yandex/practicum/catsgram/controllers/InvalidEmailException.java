package ru.yandex.practicum.catsgram.controllers;

public class InvalidEmailException extends RuntimeException {
    public InvalidEmailException(String message) {
        super(message);
    }
}
