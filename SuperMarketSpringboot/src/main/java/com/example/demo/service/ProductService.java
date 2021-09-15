package com.example.demo.service;


import com.example.demo.error.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@Service
public class ProductService  {

    @Autowired
    private ProductRepo productRepo ;







}
