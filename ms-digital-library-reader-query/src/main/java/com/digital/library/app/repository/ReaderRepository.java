package com.digital.library.app.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import com.digital.library.app.document.Reader;


public interface ReaderRepository extends ReactiveMongoRepository<Reader, String> {
}
