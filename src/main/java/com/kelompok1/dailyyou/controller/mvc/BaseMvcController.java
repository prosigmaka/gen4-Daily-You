package com.kelompok1.dailyyou.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class BaseMvcController {
    //    dashboard
    @GetMapping("dashboard")
    public String dashboard() {
        return "dashboard/index";
    }

    @GetMapping("add-product")
    public String addProduct() {
        return "product/add";
    }

    @GetMapping("update-product")
    public String updateProduct() {
        return "product/update";
    }

    @GetMapping("all-product")
    public String allProduct() {
        return "product/index";
    }

    @GetMapping("manage-product")
    public String manageProduct() {
        return "product/product";
    }


    @GetMapping("make-up")
    public String makeUp() {
        return "product/makeup";
    }

    @GetMapping("body-care")
    public String bodyCare() {
        return "product/bodycare";
    }

    @GetMapping("skin-care")
    public String skinCare() {
        return "product/skincare";
    }
}
