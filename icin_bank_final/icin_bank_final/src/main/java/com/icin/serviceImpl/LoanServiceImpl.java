package com.icin.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icin.dao.LoanDao;
import com.icin.model.Loan;
import com.icin.model.User;
import com.icin.service.LoanService;
@Service
public class LoanServiceImpl implements LoanService{
	@Autowired
	LoanDao loandao;

	@Override
	public Loan createLoan(Loan loan,User user) {
		loan.setUser(user);
		return loandao.save(loan);
		
	}

	@Override
	public List<Loan> AllLoans() {
		return loandao.findAll();
	}

	@Override
	public Loan findLoanById(long id) {
		return loandao.getOne(id);
	}

	@Override
	public void LoanRequestTrue(long id) {
		Loan loan=loandao.getOne(id);
		loan.setAccepted(true);
		loandao.save(loan);
	}
	
	@Override
	public void LoanRequestFalse(long id) {
		Loan loan=loandao.getOne(id);
		loan.setAccepted(false);
		loandao.save(loan);
		
	}

}
