package com.example.demo;

import org.springframework.data.repository.CrudRepository;

public interface BookDao extends CrudRepository<Book, Long> {
}
