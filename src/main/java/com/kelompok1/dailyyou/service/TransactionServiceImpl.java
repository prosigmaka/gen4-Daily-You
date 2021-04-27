package com.kelompok1.dailyyou.service;

import com.kelompok1.dailyyou.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Transactional
@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private OrderDetailsRepository orderDetailsRepository;


    @Override
    public Transaction saveTransactionMaterDetail(Transaction transaction) {
        return null;
    }
}
