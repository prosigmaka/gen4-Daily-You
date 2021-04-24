package com.kelompok1.dailyyou.model.dto;

import lombok.Data;

@Data
public class TransactionDto {
    private Integer idTransaction;
    private Integer idProduct;
    private Integer productQuantity;
    private Double totalPrice;
    private Double totalPricePayment;
    private Integer idPayment;
    private Integer idCustomer;
    private Integer idAlamat;

}