package com.digital.library.app.service;

import com.digital.library.app.exception.ServiceException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GenericService<T,E> {
	
	Flux<T> findAll() throws ServiceException;

	Mono<T> findById(E e) throws ServiceException;

}
