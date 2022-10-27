package com.icin.controller;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.icin.model.Transaction;
import com.icin.exceptions.InvalidTransactionException;
import com.icin.service.TransactionService;

@RestController
public class TransactionController {

    @Autowired
    private TransactionService transactionService;
 
    @PostMapping(path = "/transfer")
    @CrossOrigin(origins = "http://localhost:4200")
    public Object transferMoney(@RequestBody Transaction transaction) {

    	  transactionService.transferMoney(transaction);
         
          return transaction;
        

    }
}
