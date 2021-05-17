package com.kelompok1.dailyyou.controller.mvc;

import com.kelompok1.dailyyou.model.DefaultResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;


@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping(path = "/anonym")
    public DefaultResponse getToken(){

        return DefaultResponse.ok("Gak Perlu token");
    }

    @GetMapping(path = "/role")
    @RolesAllowed("access_user")
    public DefaultResponse getData(){

        return DefaultResponse.ok("Perlu Token");
    }

}
