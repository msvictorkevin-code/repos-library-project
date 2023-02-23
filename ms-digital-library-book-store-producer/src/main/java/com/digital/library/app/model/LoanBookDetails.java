package com.digital.library.app.model;

import lombok.Data;

@Data
public class LoanBookDetails {
    private int idLoanDetail;
    private String codeIsbn;
    private String bookName;
    private String borrowedAmount;
}
/*
prestamo libro dtalle
idlPrestamoDetalle idLoanDetail
CodigoIsbn CodeIsbn
nombrelibro bookname
cantidad prestada borrowed amount
Descripcion Description


* */
