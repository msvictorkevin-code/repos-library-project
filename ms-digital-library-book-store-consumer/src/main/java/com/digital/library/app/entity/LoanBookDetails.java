package com.digital.library.app.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;

@ToString
@Data
@Entity
@Table(name = "loan_book_details")
public class LoanBookDetails {
    private int idLoanDetail; // Ignorar por que genera la sequencia
    private int idLoan; // Se toma el pk de la tabla loan book
    private String codeIsbn;
    private String bookName;
    private String borrowedAmount;
}
