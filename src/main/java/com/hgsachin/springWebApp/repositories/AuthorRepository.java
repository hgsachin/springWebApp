package com.hgsachin.springWebApp.repositories;

import com.hgsachin.springWebApp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
