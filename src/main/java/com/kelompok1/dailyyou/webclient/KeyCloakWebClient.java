package com.kelompok1.dailyyou.webclient;

import com.kelompok1.dailyyou.configuration.exception.CommonException;
import com.kelompok1.dailyyou.model.dto.RegisterDto;
import com.kelompok1.dailyyou.model.dto.keycloak.TokenResponseDto;
import com.kelompok1.dailyyou.model.dto.request.LoginRequestDto;
import com.kelompok1.dailyyou.util.KeyCloakUtil;
import org.keycloak.KeycloakPrincipal;
import org.keycloak.KeycloakSecurityContext;
import org.keycloak.adapters.springsecurity.token.KeycloakAuthenticationToken;
import org.keycloak.admin.client.CreatedResponseUtil;
import org.keycloak.admin.client.Keycloak;
import org.keycloak.admin.client.KeycloakBuilder;
import org.keycloak.admin.client.resource.UserResource;
import org.keycloak.admin.client.resource.UsersResource;
import org.keycloak.representations.AccessToken;
import org.keycloak.representations.idm.CredentialRepresentation;
import org.keycloak.representations.idm.RoleRepresentation;
import org.keycloak.representations.idm.UserRepresentation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import javax.ws.rs.core.Response;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KeyCloakWebClient {
    @Value("${keycloak.resource}")
    private String clientId;
    @Value("${keycloak.credentials.secret}")
    private String clientSecret;

    @Value("${app.keycloak.master.resource}")
    private String masterClientId;
    @Value("${app.keycloak.master.credentials.secret}")
    private String masterClientSecret;

    private WebClient client = WebClient.create("https://siska.prosigmaka.com/auth/realms/gen4/protocol/openid-connect");

    @Value("${keycloak.auth-server-url}")
    private String authServerUrl;

    @Value("${keycloak.realm}")
    private String realms;

    private Keycloak getInstance() {
        return KeycloakBuilder
                .builder()
                .serverUrl(authServerUrl)
                .realm("master")
                .grantType("client_credentials")
                .clientId(masterClientId)
                .clientSecret(masterClientSecret)
                .build();
    }

    public TokenResponseDto getToken(LoginRequestDto loginRequestDto) {

        MultiValueMap<String, String> bodyMap = new LinkedMultiValueMap<>();
        bodyMap.add("grant_type", "password");
        bodyMap.add("client_id", clientId);
        bodyMap.add("client_secret", clientSecret);
        bodyMap.add("username", loginRequestDto.getUsername());
        bodyMap.add("password", loginRequestDto.getPassword());
        Mono<TokenResponseDto> result = client.post()
                .uri("/token")
                .body(BodyInserters.fromFormData(bodyMap))
                .accept(MediaType.APPLICATION_JSON)
                .exchangeToMono(response -> {
                    if (response.statusCode().equals(HttpStatus.OK)) {
                        return response.bodyToMono(TokenResponseDto.class);
                    } else {
                        throw new CommonException("Username / Password Salah");
                    }
//                    else if (response.statusCode().is4xxClientError()) {
//                        return response.bodyToMono(KeycloakDto.class);
//                    }else if (response.statusCode().is5xxServerError()) {
//                        return response.bodyToMono(KeycloakDto.class);
//                    } else {
//                        System.out.println(response.bodyToMono(String.class).block());
//                        return response.bodyToMono(String.class);
//                    }
                });

                        //retrieve().bodyToMono(TokenResponseDto.class);

        return result.block();
    }

    public Response doRegister(RegisterDto registerDto) {
        CredentialRepresentation credential = new CredentialRepresentation();
        credential.setType(CredentialRepresentation.PASSWORD);
        credential.setValue(registerDto.getPassword());
        credential.setTemporary(Boolean.FALSE);
        UserRepresentation user = new UserRepresentation();
        user.setUsername(registerDto.getUsername());
        user.setFirstName(registerDto.getEmail());
        user.setLastName(registerDto.getUsername());
        user.setEmail(registerDto.getEmail());
        user.setEnabled(Boolean.TRUE);
        Map<String, List<String>> attributes = new HashMap<>();
        attributes.put("alamat", Arrays.asList(registerDto.getAlamat()));
        attributes.put("noHp", Arrays.asList(registerDto.getNoHp()));
        attributes.put("ktp", Arrays.asList(registerDto.getKtp()));
        user.setAttributes(attributes);
        user.setCredentials(Arrays.asList(credential));

        UsersResource usersResource = getInstance().realm(realms).users();
        Response response = usersResource.create(user);
//        final int status = response.getStatus();
//        if (status != HttpStatus.CREATED.value()) {


        String userId = CreatedResponseUtil.getCreatedId(response);
        RoleRepresentation realmRolePendaftaran = getInstance().realm(realms).roles()//
                .get("role_user").toRepresentation();


        UserResource userResource = usersResource.get(userId);
        userResource.roles().realmLevel() //
                .add(Arrays.asList(realmRolePendaftaran));


        return response;
//        }
//        final String createdId = KeyCloakUtil.getCreatedId(response);
        // Reset password
//        CredentialRepresentation newCredential = new CredentialRepresentation();
//        UserResource userResource = getInstance().realm(realms).users().get(createdId);
//        newCredential.setType(CredentialRepresentation.PASSWORD);
//        newCredential.setValue(password);
//        newCredential.setTemporary(false);
//        userResource.resetPassword(newCredential);
//        return HttpStatus.CREATED.value();
    }

    public AccessToken getAccessToken(WebRequest req){
        KeycloakAuthenticationToken token = (KeycloakAuthenticationToken) req.getUserPrincipal();
        if(token == null) {
            return null;
        } else {
            KeycloakPrincipal principal=(KeycloakPrincipal)token.getPrincipal();
            KeycloakSecurityContext session = principal.getKeycloakSecurityContext();
            AccessToken accessToken = session.getToken();
            return accessToken;
        }


//        UserRepresentation u = userResource.toRepresentation();
//        String username = accessToken.getPreferredUsername();
//        emailID = accessToken.getEmail();
//        lastname = accessToken.getFamilyName();
//        firstname = accessToken.getGivenName();
//        realmName = accessToken.getIssuer();
//        Access realmAccess = accessToken.getRealmAccess();
//        roles = realmAccess.getRoles();

    }

    public void deleteUser(Response response){
        final String createdId = KeyCloakUtil.getCreatedId(response);
        UserResource userResource = getInstance().realm(realms).users().get(createdId);
        userResource.remove();
    }

    public UserRepresentation getUserRepresentation(WebRequest request){
        UserResource userResource = getUserResource(request);
        return userResource.toRepresentation();
    }

    public UserResource getUserResource(WebRequest request){
        AccessToken accessToken = getAccessToken(request);
        return getInstance().realm(realms).users().get(accessToken.getSubject());
    }

    public void logout(WebRequest request){
        UserResource userResource = getUserResource(request);
        userResource.logout();
    }

    public void changePassword(WebRequest request, String newPassword){
        UserResource userResource = getUserResource(request);
        CredentialRepresentation newCredential = new CredentialRepresentation();
        newCredential.setType(CredentialRepresentation.PASSWORD);
        newCredential.setValue(newPassword);
        newCredential.setTemporary(false);
        userResource.resetPassword(newCredential);
    }

    public void forgetPassword(String idUser, String newPassword){
        UserResource userResource = getInstance().realm(realms).users().get(idUser);
        CredentialRepresentation newCredential = new CredentialRepresentation();
        newCredential.setType(CredentialRepresentation.PASSWORD);
        newCredential.setValue(newPassword);
        newCredential.setTemporary(false);
        userResource.resetPassword(newCredential);
    }


}



