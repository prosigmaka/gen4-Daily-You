package com.kelompok1.dailyyou.controller.mvc;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/")
public class BaseMvcController {

    @GetMapping("dashboard")
    public String dashboard() {
        return "dashboardUser/index";
    }

    @GetMapping("dashboardUser")
    public String dashboardUser() {
        return "dashboardUser/user";
    }

    @GetMapping("dashboardAdm")
    public String dashboardAdm() {
        return "dashboardAdmin/admin";
    }

    @GetMapping("report")
    public String report() {
        return "report/report";
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

    @GetMapping("addProduct")
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

    @GetMapping("checkout")
    public String checkout() {
        return "checkout/checkout";
    }

    @GetMapping("shopping")
    public String shopping() { return "detail/shopping"; }

    @GetMapping( "login")
    public String login() {

        //authenticate the role of someone who logged in
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String check = authentication.getAuthorities().toString();

        if(check.equals("[ROLE_USER]")){
            return "dashboardUser/user";
        } else if(check.equals("[ROLE_ADMIN]")){
            return "dashboardAdmin/admin";
        }
        else {
            return "user/login";
        }
    }
}