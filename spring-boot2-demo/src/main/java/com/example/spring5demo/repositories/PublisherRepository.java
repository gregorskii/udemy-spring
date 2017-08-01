package com.example.spring5demo.repositories;

import com.example.spring5demo.models.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> { }
