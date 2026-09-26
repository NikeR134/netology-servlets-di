package ru.netology;

import org.springframework.stereotype.Service;

@Service
public class DiService extends PostService {
    public DiService(DiRepository repository) { super(repository); }
}
