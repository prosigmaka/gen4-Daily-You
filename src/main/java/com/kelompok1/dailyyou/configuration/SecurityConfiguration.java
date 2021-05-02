package com.kelompok1.dailyyou.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import com.kelompok1.dailyyou.service.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    private UserServiceImpl userServiceImpl;

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
        auth.setUserDetailsService(userServiceImpl);
        auth.setPasswordEncoder(passwordEncoder());
        return auth;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        // Authorization : Proses yang menentukan resource mana saja yang diperbolehkan untuk diakses
        http.authorizeRequests()

                .antMatchers("/dashboard*").permitAll()

                .antMatchers("/login*").permitAll()
                .antMatchers("/signup*").permitAll()

                .antMatchers("/assets/**").permitAll()


                .antMatchers("/aboutUs*").permitAll()
                .antMatchers("/educationPillars*").permitAll()
                .antMatchers("/healthPillars*").permitAll()
                .antMatchers("/womenPillars*").permitAll()
                .antMatchers("/environmentPillars*").permitAll()


                .antMatchers("/product/**").permitAll()
                .antMatchers("/dashboardUser*").hasRole("USER")
                .antMatchers("/dashboardAdm*").hasRole("ADMIN")
//                .antMatchers("/checkout*").hasRole("ROLE_USER")

                //Mendeskripsikan siapa yang mengakses resource
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
//                .defaultSuccessUrl("/dashboardUser")
//                .defaultSuccessUrl("/dashboardAdm")

                .and()
                .logout()
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .permitAll();
    }
}