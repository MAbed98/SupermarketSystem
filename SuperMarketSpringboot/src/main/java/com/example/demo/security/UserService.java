//package com.example.demo.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//import java.util.Collections;
//import java.util.List;
//
//@Service
//public class UserService implements UserDetailsService { /*Implementation to UserDetailsService >> will no generate password during running*/
//
//    @Autowired
//    private UserRepo userRepo ;
//
//    @Bean
//    private PasswordEncoder passwordEncoder(){
//        return new BCryptPasswordEncoder() ;
//    }
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return new User("mohammad" , passwordEncoder().encode("password"), AuthorityUtils.NO_AUTHORITIES);
//    }
//
//    public void save(AppUser user){ // Save User in database
//        user.setUserPassword(passwordEncoder().encode(user.getPassword()));
//        this.userRepo.save(user) ;
//    }
//
//    public List<AppUser> findAll()
//    {
//        return userRepo.findAll() ;
//    }
//}
