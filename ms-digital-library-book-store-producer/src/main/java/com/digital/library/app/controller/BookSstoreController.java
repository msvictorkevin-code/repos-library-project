package com.digital.library.app.controller;

import com.digital.library.app.constants.Constants;
import com.digital.library.app.model.LoanModel;
import com.digital.library.app.producer.BookStoreProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(Constants.API_BOOK_STORE_PRODUCER)
public class BookSstoreController {

    private BookStoreProducer bookStoreProducer;

    public BookSstoreController(BookStoreProducer bookStoreProducer) {
        this.bookStoreProducer = bookStoreProducer;
    }

    @PostMapping
    public ResponseEntity<?> send(@RequestBody LoanModel loanModel) {

        try {
            bookStoreProducer.sendMessage(loanModel);
            return ResponseEntity.ok().build();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return ResponseEntity.internalServerError().build();
        }

    }

    ;
}
