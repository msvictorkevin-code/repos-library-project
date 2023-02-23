package com.digital.library.app.repository;

import com.digital.library.app.entity.LoanBook;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanBookRepository extends JpaRepository<LoanBook, Long> {
}
