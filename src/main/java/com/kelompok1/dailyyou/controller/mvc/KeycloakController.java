package com.kelompok1.dailyyou.controller.mvc;

import com.kelompok1.dailyyou.model.DefaultResponse;
import com.kelompok1.dailyyou.model.dto.keycloak.TokenResponseDto;
import com.kelompok1.dailyyou.model.dto.request.LoginRequestDto;
import com.kelompok1.dailyyou.webclient.KeyCloakWebClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth")
public class KeycloakController {
    private final KeyCloakWebClient keyCloakWebClient;

    public KeycloakController(KeyCloakWebClient keyCloakWebClient) {
        this.keyCloakWebClient = keyCloakWebClient;
    }

    @PostMapping(path = "/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public DefaultResponse<TokenResponseDto> getToken(LoginRequestDto loginRequestDto){
        TokenResponseDto tokenResponseDto = keyCloakWebClient.getToken(loginRequestDto);
        return DefaultResponse.ok(tokenResponseDto);
    }

}
