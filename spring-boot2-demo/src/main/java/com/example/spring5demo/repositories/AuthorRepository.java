package com.example.spring5demo.repositories;

import com.example.spring5demo.models.Author;
import org.springframework.data.repository.CrudRepository;

/**
 * Uses Spring CrudRepository and defines classes uses generics
 *
 * Extending CrudRepository in this Interface gives you complete CRUD against your Entity
 */
public interface AuthorRepository extends CrudRepository<Author, Long> { }
