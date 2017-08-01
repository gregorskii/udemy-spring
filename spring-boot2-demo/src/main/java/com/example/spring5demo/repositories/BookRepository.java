package com.example.spring5demo.repositories;

import com.example.spring5demo.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> { }
