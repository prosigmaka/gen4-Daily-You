package com.kelompok1.dailyyou.service;

import com.kelompok1.dailyyou.model.entity.Users;
import com.kelompok1.dailyyou.model.entity.Role;
import com.kelompok1.dailyyou.repository.UserRepository;
import com.kelompok1.dailyyou.model.dto.UserRegistrationDto;
import com.kelompok1.dailyyou.configuration.exception.CustomException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    //Untuk proses save data saat proses registrasi
    @Override
    public Users save(UserRegistrationDto registrationDto) throws CustomException {

        //Setting manual
        Users users = new Users();
        users.setFirstName(registrationDto.getFirstName());
        users.setLastName(registrationDto.getLastName());
        users.setUsername(registrationDto.getUsername());
        users.setPassword(passwordEncoder.encode(registrationDto.getPassword()));

        //Setting manual untuk role id 1 dengan tipe data Long adalah sebagai "User"
        users.setRoleId(1L);

        return userRepository.save(users);
    }

    // Proses Login dimana akan dicari usernamenya apakah sesuai apa tidak
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = userRepository.findByUsername(username);

        //Jika usernya tidak ada di database atau null
        if(users == null) {
            //maka akan akan dilemparkan ke "UsernameNotFoundException"
            throw new UsernameNotFoundException("Invalid username or password.");
//            users loginDto = new LoginDto();
//            loginDto.getIdUserLogin();
        }

        //Setelah itu akan di return nilainya ke user.
        return new org.springframework.security.core.userdetails.User(users.getUsername(), users.getPassword(), mapRolesToAuthorities(Arrays.asList(users.getRoles())));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
