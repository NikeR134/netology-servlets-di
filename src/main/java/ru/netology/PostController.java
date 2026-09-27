package ru.netology;

import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class PostController {
    private final PostService service;
    public PostController(PostService service) { this.service = service; }
    public List<Post> all() { return service.all(); }
    public Post getById(long id) { return service.getById(id); }
    public Post save(Post post) { return service.save(post); }
    public boolean removeById(long id) { return service.removeById(id); }
}

