package com.iot.demo.websockCon.sercuirtyCon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Administrator on 2017/11/12 0012.
 */
@EnableWebSecurity
@Configuration
public class WebSercurityConfig extends WebSecurityConfigurerAdapter{

    @Autowired
    UserDetailSerImp userDetailSerImp;



    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /*super.configure(auth);
        auth.inMemoryAuthentication()
                .withUser("root")
                .password("root")
                .roles("USER");*/

        auth.userDetailsService(userDetailSerImp);
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {


        http.authorizeRequests().
                antMatchers("/myHandler","/pysent/**","/js/**","/lib/**","/regist","/registuser", "/webjars/**", "/register", "/api/common/**", "/image/**").permitAll()
                .anyRequest().authenticated()
                .and()
                    .formLogin().loginPage("/login").defaultSuccessUrl("/iot/iotcontroller", true).failureForwardUrl("/ee").permitAll()
                .and().
                    logout().permitAll()
        .and().csrf().disable();
    }
}
