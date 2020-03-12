package com.hgsachin.springWebApp.repositories;

import com.hgsachin.springWebApp.domain.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
