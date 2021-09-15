//package com.example.demo.security;
//
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.config.http.SessionCreationPolicy;
//
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    private final String []PUBLIC_ENDPOINTS = {
//            "/api/v1/auth/**"
//    };
//    @Override
//    protected void configure(HttpSecurity http) throws Exception{
//             http
//                     .cors().and().csrf().disable() // to cookies
//                     .sessionManagement()
//                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS) // because we used jwt (Spring Security will never create an HttpSession and it will never use it to obtain the SecurityContext)
//                            .and()
//                     .authorizeRequests() // this sellect if you need crate a path open by  authorize or public
//                        .antMatchers(PUBLIC_ENDPOINTS).permitAll() // acsess to this path without need user and pass
//                     .anyRequest().authenticated()
//                     .and()
//                     .httpBasic() ;
//             //// لحد الان رح يسجل الدخول اذا كان الباسوورد صح بغض النظر عن اليوزر
//
//    }
//}
