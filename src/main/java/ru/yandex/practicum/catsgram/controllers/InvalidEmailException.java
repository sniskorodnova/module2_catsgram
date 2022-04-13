package ru.yandex.practicum.catsgram.controllers;

public class InvalidEmailException extends Exception {
    public InvalidEmailException(String message) {
        System.out.println(message);
    }
}
