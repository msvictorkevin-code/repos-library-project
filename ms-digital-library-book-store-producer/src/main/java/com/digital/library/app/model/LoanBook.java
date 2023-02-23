package com.digital.library.app.model;

import lombok.Data;

import java.util.Date;

@Data
public class LoanBook {
    private int idLoan;
    private int userAccountId;
    private int quantityTotal;
    private Date loanDate;
    private Date returnDate;
    private String additionalInformation;
}



/*
*
tabla
prestamo libro
idprestamo idLoan
user_account_id
quantityTotal prestados borrowed amount
fecha de prestamo loan date
fecha de devolucion return date
* */