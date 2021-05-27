package com.kelompok1.dailyyou.service;

import com.kelompok1.dailyyou.model.dto.RequestCartItemIdList;
import com.kelompok1.dailyyou.model.entity.OrderItems;

public interface CheckoutService {
    OrderItems checkoutOrderItem (RequestCartItemIdList requestCartItemIdList);
}
