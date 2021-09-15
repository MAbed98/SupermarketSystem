//package com.example.demo.security;
//
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import java.util.Date;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.Objects;
//
//@Component
//public class tokenUtil {
//
//
//
//
//    private long TOKEN_VALIDITY = 604800L ;
//    public String generteToken(UserDetails userDetails){
//
//        //Steps to create token :
//        //1- claims
//        //2- expration
//        //3- sign
//        //4- compact
//
//        //1- claims:
//        Map<String, Objects> claims = new HashMap<>() ;
//        claims.put("sub",userDetails.getUsername()) ;
//        claims.put("created" , new Date() ) ;
//        return Jwts.builder()
//                .setClaims(claims)
//                //2- expration:
//                .setExpiration(generateExpirationDate())
//                .signWith(SignatureAlgorithm.HS512)
//                .compact() ;
//    }
//
//    private Date generateExpirationDate() {
//
//        return new Date(System.currentTimeMillis() + TOKEN_VALIDITY * 1000 ) ;
//
//    }
//}
