package com.hgsachin.springWebApp.repositories;

import com.hgsachin.springWebApp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
