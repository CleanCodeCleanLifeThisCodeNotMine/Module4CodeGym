package org.example.blog.service;

import java.util.List;
import org.example.blog.model.Blog;

public interface IGenerateService<T> {
    List<T> findAll();

    void save(T t);

    T findById(Long id);

    void remove(Long id);
}
