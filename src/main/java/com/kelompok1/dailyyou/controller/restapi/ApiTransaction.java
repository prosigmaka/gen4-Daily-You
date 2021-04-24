package com.kelompok1.dailyyou.controller.restapi;

import com.kelompok1.dailyyou.model.dto.TransactionDto;
import com.kelompok1.dailyyou.model.entity.Transaction;
import com.kelompok1.dailyyou.repository.TransactionRepository;
import com.kelompok1.dailyyou.service.TransactionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/transaction")
public class ApiTransaction {
    @Autowired
    TransactionRepository transactionRepository;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    TransactionService transactionService;


    @GetMapping()
    public List<TransactionDto> getListTransaction() {
        List<Transaction> transactionList = transactionRepository.findAll();
        List<TransactionDto> transactionDtos =
                transactionList.stream()
                        .map(transaction -> mapTransactionToTransactionDto(transaction))
                        .collect(Collectors.toList());
        return transactionDtos;
    }

    private TransactionDto mapTransactionToTransactionDto(Transaction transaction) {
        TransactionDto transactionDto = modelMapper.map(transaction, TransactionDto.class);



        return transactionDto;
    }

    @GetMapping("/{id}")
    public TransactionDto getTransaction(@PathVariable Integer id) {
        Transaction transaction = transactionRepository.findById(id).get();
        TransactionDto transactionDto = new TransactionDto();
        modelMapper.map(transaction, transactionDto);
        modelMapper.map(transaction.getId(), transactionDto);

        return transactionDto;
    }

    @PostMapping
    public TransactionDto editsaveTransaction(@RequestBody TransactionDto transactionDto) {
        Transaction transaction = modelMapper.map(transactionDto, Transaction.class);

        return transactionDtoDB;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        transactionRepository.deleteById(id);
    }

}
