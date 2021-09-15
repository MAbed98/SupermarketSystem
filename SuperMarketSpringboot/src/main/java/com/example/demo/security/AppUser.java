//package com.example.demo.security;
//
//import com.fasterxml.jackson.annotation.JsonIgnore;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//
//import javax.persistence.*;
//import java.util.Collection;
//import java.util.Date;
//
//
//@Entity
//@Table(name = "users")
//public class AppUser implements UserDetails
//{
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "id")
//    private int id;
//
//    @Column
//    private String email;
//
//
//    @Column
//   @JsonIgnore   // no returned in response
//    private String userPassword;
//
//    @Column
//    private String username2;
//    ;
//
//    @Column
//    @Temporal(TemporalType.TIMESTAMP)
//    protected Date createdDate;
//
//    private AppUser() {
//    }
//
//    public AppUser(String email, String userPassword, String username2) {
//        this.email = email;
//        this.userPassword = userPassword;
//        this.username2 = username2;
//    }
//
//
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return null;
//    }
//
//    @Override
//    public String getPassword() {
//        return userPassword;
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//
//    public void setUserPassword(String userPassword) {
//        this.userPassword = userPassword;
//    }
//
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getUsername2() {
//        return username2;
//    }
//
//    public void setUsername2(String username2) {
//        this.username2 = username2;
//    }
//}