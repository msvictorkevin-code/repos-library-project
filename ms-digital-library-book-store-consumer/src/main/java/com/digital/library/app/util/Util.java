package com.digital.library.app.util;

import com.digital.library.app.entity.LoanBook;
import com.digital.library.app.entity.LoanBookDetails;
import com.digital.library.app.model.LoanBookDetailsModel;
import com.digital.library.app.model.LoanBookModel;

import java.util.List;
import java.util.stream.Collectors;

public class Util {

    public static LoanBook buildLoanBook(LoanBookModel loanBookModel) {
        LoanBook loanBook = new LoanBook();
        loanBook.setIdLoan(loanBookModel.getIdLoan());
        loanBook.setUserAccountId(loanBookModel.getUserAccountId());
        loanBook.setQuantityTotal(loanBookModel.getQuantityTotal());
        loanBook.setLoanDate(loanBookModel.getLoanDate());
        loanBook.setReturnDate(loanBookModel.getReturnDate());
        loanBook.setAdditionalInformation(loanBookModel.getAdditionalInformation());
        return loanBook;
    }

    public static List<LoanBookDetails> buildLoanBookDetails(List<LoanBookDetailsModel> detailsList, LoanBook loanBook) {
        List<LoanBookDetails> detailsListMerge = detailsList.stream().map(x ->
                {
                    LoanBookDetails loanBookDetails = new LoanBookDetails();
                    loanBookDetails.setIdLoanDetail(x.getIdLoanDetail());
                    loanBookDetails.setIdLoan(loanBook.getIdLoan());
                    loanBookDetails.setCodeIsbn(x.getCodeIsbn());
                    loanBookDetails.setBookName(x.getBookName());
                    loanBookDetails.setBorrowedAmount(x.getBorrowedAmount());
                    return loanBookDetails;
                }
        ).collect(Collectors.toList());
        return detailsListMerge;
    }
}
