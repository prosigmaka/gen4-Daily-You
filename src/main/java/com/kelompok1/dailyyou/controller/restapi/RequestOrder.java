package com.kelompok1.dailyyou.controller.restapi;

import lombok.Data;
import java.util.Map;

@Data
public class RequestOrder {
    private Map<Integer, Integer> cart;
}
