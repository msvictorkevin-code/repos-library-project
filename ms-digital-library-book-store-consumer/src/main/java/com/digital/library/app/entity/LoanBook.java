package com.digital.library.app.entity;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@ToString
@Data
@Entity
@Table(name = "loan_book")
public class LoanBook {
    private int idLoan; // Ignorar por que genera la sequencia
    private int userAccountId;
    private int quantityTotal;
    private Date loanDate;
    private Date returnDate;
    private String additionalInformation;
}
