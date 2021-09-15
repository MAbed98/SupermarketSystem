import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Products } from '../models/products';

@Injectable({
  providedIn: 'root'
})
export class ProductService {

  url: String = 'http://localhost:8084/product';

  constructor(private http: HttpClient) { }

    getProductsList(): Observable<Products[]> {

    return this.http.get<Products[]>(this.url + "/getAllProducts");
  }

  addProduct(product: Object): Observable<Object> {
    return this.http.post(this.url + "/addProduct", product);
  }

  getProduct(id: number): Observable<any> {
    return this.http.get<Products[]>(this.url + "/getProductById/" + id ) ;
  }



  updateProduct(id: number, product: Products): Observable<Object> {
    return this.http.put<Products>(this.url + "/updateProduct/" + id , product);
  }

  deleteProduct(id: number): Observable<any> {
    return this.http.delete<Products>(this.url+"/deleteProductById/"+id);
  }

  getSearchProductsList(searchStr: String): Observable<Products[]> {

    return this.http.get<Products[]>(this.url + "/getSearchProducts/" + searchStr );
  }

}
