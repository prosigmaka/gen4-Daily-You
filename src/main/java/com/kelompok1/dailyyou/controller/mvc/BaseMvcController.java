package com.kelompok1.dailyyou.controller.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BaseMvcController {

    @RequestMapping(value= {"/dashboard"}, method=RequestMethod.GET)
    public ModelAndView dashboard() {
        ModelAndView model = new ModelAndView();

        model.setViewName("dashboard/index");
        return model;
    }

    @RequestMapping(value= {"/", "/login"}, method= RequestMethod.GET)
    public ModelAndView login() {
        ModelAndView model = new ModelAndView();

        model.setViewName("user/login");
        return model;
    }

    @GetMapping("dashboardUser")
    public String dashboardUser() {
        return "dashboard/index2";
    }

    @GetMapping("aboutUs")
    public String aboutUs() {
        return "profile/aboutUs";
    }

    @GetMapping("educationPillars")
    public String educationPillars() {
        return "activities/page1";
    }

    @GetMapping("healthPillars")
    public String healthPillars() {
        return "activities/page2";
    }

    @GetMapping("womenPillars")
    public String womenPillars() {
        return "activities/page3";
    }

    @GetMapping("environmentPillars")
    public String environmentPillars() {
        return "activities/page4";
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

}