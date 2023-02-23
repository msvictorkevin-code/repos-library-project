package com.digital.library.app.model;

import lombok.Data;

@Data
public class LoanBookDetailsModel {
    private int idLoanDetail; // Ignorar por que genera la sequencia
    private int idLoan; // Se toma el pk de la tabla loan book
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
