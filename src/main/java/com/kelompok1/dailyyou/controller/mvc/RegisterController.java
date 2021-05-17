package com.kelompok1.dailyyou.controller.mvc;

import com.kelompok1.dailyyou.model.DefaultResponse;
import com.kelompok1.dailyyou.model.dto.RegisterDto;
import com.kelompok1.dailyyou.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/register")
public class RegisterController {

    private final UserService userService;

    RegisterController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public DefaultResponse create(@RequestBody @Valid RegisterDto registerDto) {
        return DefaultResponse.ok(userService.saveRegister(registerDto));
    }
}
