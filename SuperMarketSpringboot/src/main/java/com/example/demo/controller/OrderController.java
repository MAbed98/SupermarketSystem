package com.example.demo.controller;

import com.example.demo.model.Order;
import com.example.demo.model.Product;
import com.example.demo.repository.OrderRepo;
import com.example.demo.repository.ProductRepo;
import org.apache.tomcat.util.buf.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/order")
@RestController //  to building RESTful web services
public class OrderController {

    @Autowired
    private OrderRepo orderRepo ;
    @Autowired
    private ProductRepo productRepo ;

    @PostMapping("/createOrder/{customerName}/{customerPhone}/{orderDate}")
    public  String CreatOrder(
            @PathVariable String customerName , @PathVariable String customerPhone ,
            @PathVariable String orderDate , @RequestBody int [][]arrOfProduct){

//        String productToString = product.entrySet()
//                .stream()
//                .map(e -> "productId: "+e.getKey()+", NumberOfPices: "+e.getValue())
//                .collect(Collectors.joining("&"));

        String products = "(id : numberOfPices): [ " ;

        for (int i = 0; i < arrOfProduct.length ; i++) {
            products += arrOfProduct[i][0] + " : " + arrOfProduct[i][1] + " , ";
            updateNumberOfPices(arrOfProduct[i][0], arrOfProduct[i][1]) ;
        }

        products = products.substring(0,products.length()-2) + " ]" ;
//        System.out.println("name: " + customerName + " phone: " + customerPhone +" Date: " + String.valueOf(orderDate) + " Products: " + products );
        orderRepo.save( new Order(customerName , customerPhone , orderDate, products ) ) ;
        return "Done";

    }

    public void updateNumberOfPices(int id, int numberOfPicesSold) {
        Product product = productRepo.getProductById(id);
        if(this.productRepo.findById(id).isPresent()){
            product.setId(id);
            product.setNumber_of_items(product.getNumber_of_items() - numberOfPicesSold);
            this.productRepo.save(product) ;
        }
//        product.setNumber_of_items(numberOfPicesSold);
//        productRepo.save(product);
    }

}
