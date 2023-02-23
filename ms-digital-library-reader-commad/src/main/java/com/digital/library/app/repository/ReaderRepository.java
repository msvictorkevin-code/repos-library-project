package com.digital.library.app.repository;

import com.digital.library.app.document.Reader;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;


public interface ReaderRepository extends ReactiveMongoRepository<Reader, String> {
}
