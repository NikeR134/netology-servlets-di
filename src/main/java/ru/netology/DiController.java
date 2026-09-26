package ru.netology;

import org.springframework.stereotype.Component;

@Component
public class DiController extends PostController {
    public DiController(DiService service) { super(service); }
}
