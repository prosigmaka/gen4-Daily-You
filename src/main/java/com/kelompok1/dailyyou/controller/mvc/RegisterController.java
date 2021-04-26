package com.kelompok1.dailyyou.controller.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegisterController {

    //    dashboard
    @GetMapping("register")
    public String dashboard() {
        return "dashboard/index";
    }

//    @GetMapping(value = "/register")
//    public ModelAndView register(
//            @RequestParam(value = "error", required = false) String error,
//            @RequestParam(value = "logout", required = false) String logout,
//            @RequestParam(value = "denied", required = false) String denied) {
//
//        ModelAndView model = new ModelAndView();
//        if (error != null) {
//            model.addObject("msg", "Invalid username or password!");
//        }
//
//        if (logout != null) {
//            model.addObject("msg", "You've been logged out successfully.");
//        }
//
//        if (denied != null) {
//            model.addObject("msg", "Access Denied. Session Time Out");
//        }
//        model.setViewName("register");
//
//        return model;
//    }
}
