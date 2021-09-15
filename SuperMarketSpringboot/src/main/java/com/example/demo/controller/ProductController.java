package com.example.demo.controller;

import com.example.demo.error.ResourceNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.sax.SAXSource;

@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/product")
@RestController //  to building RESTful web services
public class ProductController {

    
    @Autowired
    private ProductRepo productRepo ;

    @GetMapping("/getAllProducts")
    public Iterable<Product> getAllProducts() {
        return productRepo.findAll() ;

    }
    @GetMapping("/getSearchProducts/{searchStr}")
    public Iterable<Product> getSearchProducts(@PathVariable(value = "searchStr") String searchStr
            , @RequestParam(required = false , defaultValue = "10", value = "pageSize") int pageSize) {
        System.out.println("searchStr: ");

        System.out.println(productRepo.getSearchProducts(searchStr , pageSize));
        return productRepo.getSearchProducts(searchStr , pageSize) ;
//        return productRepo.findAll() ;

    }
    @GetMapping("getProductById/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable(value = "id") int productId)
            throws ResourceNotFoundException {
        System.out.println("getProductById");
        Product product = productRepo.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
        return ResponseEntity.ok().body(product);
    }

    @PostMapping("/addProduct")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {

        productRepo.save(product) ;
        return ResponseEntity.ok().body(product);
    }

    @DeleteMapping("/deleteProductById/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable int id) {

        if(this.productRepo.findById(id).isPresent()){
            this.productRepo.deleteById(id);
            return new ResponseEntity<>(HttpStatus.OK) ;
        }
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND) ;
        }

    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable int id , @RequestBody Product product) throws ResourceNotFoundException {

        System.out.println("Update");
//        Product p = this.productRepo.findById(id)
//                .orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + id)) ;
        System.out.println("product:" + product.getName());
        if(this.productRepo.findById(id).isPresent()){
            product.setId(id);
            return new ResponseEntity<>(this.productRepo.save(product) , HttpStatus.OK) ;
        }
        else return new  ResponseEntity<>(HttpStatus.NOT_FOUND) ;

//        p.setName(product.getName());
//        p.setActive(product.isActive());
//        p.setCategory(product.getCategory());
//        p.setExpiry_date(product.getExpiry_date());
//        p.setHeight(product.getHeight());
//        p.setLength(product.getLength());
//        p.setMade_in(product.getMade_in());
//        p.setNumber_of_items(product.getNumber_of_items());
//        p.setPrice(product.getPrice());
//        p.setProduction_date(product.getProduction_date());
//        p.setWidth(product.getWidth());

//        final Product updatedCar = productRepo.save(product);
//        return ResponseEntity.ok(updatedCar);

//        return new ResponseEntity<>(this.productRepo.save(product) , HttpStatus.OK) ;

    }


}
