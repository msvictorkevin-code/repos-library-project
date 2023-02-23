package com.digital.library.app.repository;

import com.digital.library.app.entity.LoanBookDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanBookDetailsRepository extends JpaRepository<LoanBookDetails,Long> {
}
