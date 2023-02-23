package com.digital.library.app.service.impl;

import com.digital.library.app.dto.request.ReaderRequest;
import com.digital.library.app.dto.response.ReaderResponse;
import com.digital.library.app.exception.ServiceException;
import com.digital.library.app.repository.ReaderRepository;
import com.digital.library.app.service.ReaderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreaker;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class ReaderServiceImpl implements ReaderService {


    private ReaderRepository readerRepository;

    // Resilencia

    private CircuitBreaker circuitBreaker;

    public ReaderServiceImpl(ReaderRepository readerRepository, CircuitBreakerFactory<?, ?> circuitBreakerFactory) {
        this.readerRepository = readerRepository;
        this.circuitBreaker = circuitBreakerFactory.create("ms-digital-library-reader-query");
        ;
    }

    @Override
    public Flux<ReaderResponse> findAll() throws ServiceException {
        return circuitBreaker.run(() -> {
            // Plan A
            return readerRepository.findAll().flatMap(x -> Flux.just(ReaderResponse.builder()
                    .idReader(x.getIdReader())
                    .readerName(x.getReaderName())
                    .userName(x.getUserName())
                    .addressReader(x.getAddressReader())
                    .userProfileId(x.getUserProfileId()).build()));

        }, throwable -> getReaderResponseDTOArray());
    }

    private Flux<ReaderResponse> getReaderResponseDTOArray() {
        return Flux.just(ReaderResponse.builder()
                .idReader(null)
                .readerName(null)
                .userName(null)
                .addressReader(null)
                .userProfileId(null)
                .build());
    }

    @Override
    public Mono<ReaderResponse> findById(ReaderRequest readerRequest) throws ServiceException {

        return circuitBreaker.run(() -> {
            // Plan A
            return readerRepository.findById(readerRequest.getId()).flatMap(x -> {
                return Mono.just(ReaderResponse.builder()
                        .idReader(x.getIdReader())
                        .readerName(x.getReaderName())
                        .userName(x.getUserName())
                        .addressReader(x.getAddressReader())
                        .userProfileId(x.getUserProfileId()).build());
            });
        }, throwable -> getReaderResponseDTO());


    }

    private Mono<ReaderResponse> getReaderResponseDTO() {
        return Mono.just(ReaderResponse.builder()
                .idReader(null)
                .readerName(null)
                .userName(null)
                .addressReader(null)
                .userProfileId(null)
                .build());
    }
}
