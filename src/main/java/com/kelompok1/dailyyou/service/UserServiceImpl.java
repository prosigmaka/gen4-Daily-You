package com.kelompok1.dailyyou.service;

import com.kelompok1.dailyyou.model.entity.Users;
import com.kelompok1.dailyyou.model.entity.Role;
import com.kelompok1.dailyyou.repository.UserRepository;
import com.kelompok1.dailyyou.model.dto.UserRegistrationDto;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;

@Service("userService")
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Autowired
    private ModelMapper modelMapper;

    public UserServiceImpl(UserRepository userRepository) {
        super();
        this.userRepository = userRepository;
    }

    @Override
    public Users save(UserRegistrationDto registrationDto) {
//        Users users = new Users(registrationDto.getFirstName(),
//                registrationDto.getLastName(), registrationDto.getEmail(),
//                passwordEncoder.encode(registrationDto.getPassword()), Arrays.asList(new Role("ROLE_USER")));

        //		Role role = roleRepository.findById(1L).get();
        Users users = new Users();

//        Users users = modelMapper.map(UserRegistrationDto, Users.class);

        users.setFirstName(registrationDto.getFirstName());
        users.setLastName(registrationDto.getLastName());
        users.setEmail(registrationDto.getEmail());
        users.setPassword(passwordEncoder.encode(registrationDto.getPassword()));
        users.setRoleId(1L);

        return userRepository.save(users);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users = userRepository.findByEmail(username);
        if(users == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(users.getEmail(), users.getPassword(), mapRolesToAuthorities(Arrays.asList(users.getRoles())));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

}
