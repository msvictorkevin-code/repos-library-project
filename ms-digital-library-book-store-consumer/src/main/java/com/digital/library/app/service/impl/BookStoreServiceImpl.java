package com.digital.library.app.service.impl;

import com.digital.library.app.entity.LoanBook;
import com.digital.library.app.entity.LoanBookDetails;
import com.digital.library.app.model.LoanBookDetailsModel;
import com.digital.library.app.model.LoanModel;
import com.digital.library.app.repository.LoanBookDetailsRepository;
import com.digital.library.app.repository.LoanBookRepository;
import com.digital.library.app.service.BookStoreService;
import com.digital.library.app.util.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class BookStoreServiceImpl implements BookStoreService {

    private LoanBookDetailsRepository loanBookDetailsRepository;

    private LoanBookRepository loanBookRepository;

    public BookStoreServiceImpl(LoanBookDetailsRepository loanBookDetailsRepository, LoanBookRepository loanBookRepository) {
        this.loanBookDetailsRepository = loanBookDetailsRepository;
        this.loanBookRepository = loanBookRepository;
    }

    @Transactional
    @Override
    public boolean saveLoan(LoanModel loanModel) {


        LoanBook loanBook = null;
        List<LoanBookDetails> detailsList = null;
        try {
            // Se construye
            loanBook = Util.buildLoanBook(loanModel.getLoanBookModel());
            // Se registra y setea
            loanBook = loanBookRepository.save(loanBook);

            detailsList = Util.buildLoanBookDetails(loanModel.getDetailsList(),loanBook);

            detailsList = loanBookDetailsRepository.saveAll(detailsList);
            return true;
        } catch (Exception ex) {
            log.info("message:" + ex.getMessage());
        }


        return false;
    }
}
