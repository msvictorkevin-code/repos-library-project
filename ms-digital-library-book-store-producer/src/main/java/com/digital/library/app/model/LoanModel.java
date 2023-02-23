package com.digital.library.app.model;

import lombok.Data;

import java.util.List;

@Data
public class LoanModel {

    private LoanBook loanBook;
    private List<LoanBookDetails> detailsList;
}
