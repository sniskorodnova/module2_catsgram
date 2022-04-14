package ru.yandex.practicum.catsgram.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.zalando.logbook.Logbook;
import ru.yandex.practicum.catsgram.models.Post;
import java.util.ArrayList;
import java.util.List;

@RestController
public class PostController {
    private final List<Post> posts = new ArrayList<>();
    private static final Logger log = LoggerFactory.getLogger(PostController.class);
    Logbook logbook = Logbook.create();

    @GetMapping("/posts")
    public List<Post> findAll() {
        log.debug("Текущее количество постов: {}", posts.size());
        return posts;
    }

    @PostMapping(value = "/post")
    public void create(@RequestBody Post post) {
        posts.add(post);
    }
}