//package com.example.demo.util;
//
//import com.example.demo.security.AppUser;
//import com.example.demo.security.UserService;
//import org.apache.juli.logging.Log;
//import org.apache.juli.logging.LogFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.stereotype.Component;
//
//@Component
//public class FirstTimeInitilizer implements CommandLineRunner {
//
//    private final Log logger = LogFactory.getLog(FirstTimeInitilizer.class);
//    @Autowired
//    private UserService userService ;
//    @Override
//    public void run(String... args) throws Exception {
//
//        // حظ الاشي اللي بدك ينعمل اول ما تعمل رن
//        // check if we have user:
//        if(userService.findAll().isEmpty()){
//        logger.info("No users account found. crating some users");
//
//
//            AppUser user = new AppUser("mohammadabed1162016@gmail.com" , "password" , "Mohammad") ;
//            userService.save(user);
//        }
//        //if no user, create new user
//        System.out.println("Hello wOrld");
//    }
//}
