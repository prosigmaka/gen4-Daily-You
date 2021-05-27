package com.kelompok1.dailyyou.service;


import com.kelompok1.dailyyou.configuration.exception.CartItemNotExistException;
import com.kelompok1.dailyyou.model.dto.AddToCartDto;
import com.kelompok1.dailyyou.model.dto.CartDto;
import com.kelompok1.dailyyou.model.dto.CartItemDto;
import com.kelompok1.dailyyou.model.entity.Cart;
import com.kelompok1.dailyyou.model.entity.Product;
import com.kelompok1.dailyyou.model.entity.User;
import com.kelompok1.dailyyou.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceImp implements OrderService{
    @Autowired
    private  CartRepository cartRepository;


}