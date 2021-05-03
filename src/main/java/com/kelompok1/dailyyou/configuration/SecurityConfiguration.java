package com.kelompok1.dailyyou.configuration;

import org.springframework.http.HttpMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.kelompok1.dailyyou.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService)
                .passwordEncoder(passwordEncoder);
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

                .antMatchers("/dashboardUser*").hasAuthority("ROLE_USER")
                .antMatchers("/dashboardAdm*").hasAuthority("ROLE_ADMIN")

                .antMatchers(HttpMethod.POST, "/controller/**").permitAll()
                .antMatchers(HttpMethod.GET, "/controller/**").permitAll()


                //Mendeskripsikan siapa yang mengakses resource
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .loginProcessingUrl("/perform_login")
                .successHandler(myAuthenticationSuccessHandler)
                .failureUrl("/login?error=true")

                .and()
                .logout()
                .logoutUrl("/perform_logout")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout=true")
                .deleteCookies("JSESSIONID");
    }
}