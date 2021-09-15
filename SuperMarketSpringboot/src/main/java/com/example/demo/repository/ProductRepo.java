package com.example.demo.repository;

import com.example.demo.model.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepo extends CrudRepository<Product , Integer> {

//    public Product getProductById(int id) ;

    @Query(value =
            "Select * From super_market.products where id = :id ; ",
            nativeQuery = true)
    public Product getProductById( int id) ;

    @Query(value =
            "Select * From super_market.products where name like %:products% limit :pageSize ; ",
            nativeQuery = true)
    public List<Product> getSearchProducts(String products , int pageSize) ;

//    @Modifying
//    @Query(value ="update super_market.products set number_of_items = number_of_items - :numberOfPicesSold where id = :productId ;", nativeQuery = true)
//    public void UpdateNumberOfPices(@Param("productId") int productId ,@Param("numberOfPicesSold") int numberOfPicesSold) ;
//    public List<Product> getProductByIdAndNameLikeproducts(String products) ;

}
