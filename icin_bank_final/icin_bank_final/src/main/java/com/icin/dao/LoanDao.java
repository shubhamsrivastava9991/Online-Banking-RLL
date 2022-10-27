package com.icin.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icin.model.Loan;

public interface LoanDao extends JpaRepository<Loan,Long> {

}
