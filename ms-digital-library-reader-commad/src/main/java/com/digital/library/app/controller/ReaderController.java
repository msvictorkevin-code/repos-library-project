package com.digital.library.app.controller;

import com.digital.library.app.constants.Constants;
import com.digital.library.app.dto.request.ReaderRequest;
import com.digital.library.app.dto.response.ReaderResponse;
import com.digital.library.app.exception.ServiceException;
import com.digital.library.app.service.ReaderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
@RequestMapping(Constants.API_READER_COMMAND)
public class ReaderController {

    private ReaderService readerService;

    public ReaderController(ReaderService readerService) {
        this.readerService = readerService;
    }

    @PostMapping
    public ResponseEntity<Mono<ReaderResponse>> save(@RequestBody ReaderRequest request) {
        try {

            return ResponseEntity.status(HttpStatus.CREATED).body(readerService.save(request));
        } catch (ServiceException e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }
    }




}
