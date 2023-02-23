package com.digital.library.app.model;

import lombok.Data;

import java.util.List;

@Data
public class LoanModel {

    private LoanBookModel loanBookModel;
    private List<LoanBookDetailsModel> detailsList;
}
