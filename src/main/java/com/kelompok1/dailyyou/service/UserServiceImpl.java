package com.kelompok1.dailyyou.service;

import com.kelompok1.dailyyou.configuration.exception.CommonException;
import com.kelompok1.dailyyou.mapper.UserMapper;
import com.kelompok1.dailyyou.model.dto.RegisterDto;
import com.kelompok1.dailyyou.model.dto.UserDto;
import com.kelompok1.dailyyou.model.entity.User;
import com.kelompok1.dailyyou.repository.UserRepository;
import com.kelompok1.dailyyou.service.UserService;
import com.kelompok1.dailyyou.webclient.KeyCloakWebClient;

import org.keycloak.admin.client.CreatedResponseUtil;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.core.Response;
import java.util.Date;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final KeyCloakWebClient keyCloakWebClient;

    public UserServiceImpl(UserRepository repository, UserMapper userMapper, KeyCloakWebClient keyCloakWebClient) {
        this.userRepository = repository;
        this.userMapper = userMapper;
        this.keyCloakWebClient = keyCloakWebClient;
    }

    @Override
    public UserDto findByUsername(String username) {
        return userMapper.toUserDto(userRepository.findByUsername(username).get());
    }

    @Override
    public RegisterDto saveRegister(RegisterDto registerDto) {
        /* Ada Kemungkinan terdaftar di keycloak tapi gagal simpen ke table biodata
         * abaikan dulu*/
        //lower case email
        registerDto.setEmail(registerDto.getEmail().toLowerCase());
        User user = userMapper.fromRegisterDto(registerDto);
//        validateRegister(biodata);
        user.setCreatedBy(registerDto.getEmail());
        user.setCreatedOn(new Date());

        Response response = keyCloakWebClient.doRegister(registerDto);
        if (response.getStatus() == HttpStatus.CREATED.value()) {
            try {
                String userId = CreatedResponseUtil.getCreatedId(response);
                user.setUserKeyId(userId);
                registerDto = userMapper.toRegisterDto(userRepository.save(user));
                // sendSuccessRegistrationMail(biodata.getEmail(), biodata.getNama());
                return registerDto;
            } catch (Exception e) {
                keyCloakWebClient.deleteUser(response);
                throw new RuntimeException(e);
            }
        } else {
            throw new CommonException("Gagal Register");

        }
    }

}