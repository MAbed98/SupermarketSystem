import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Products } from '../models/products';


@Injectable({
  providedIn: 'root'
})
export class OrdersService {

  url: String = "http://localhost:8084/order"
  // /Mohammad/05651000/2020-04-24
  constructor(private http: HttpClient) { }


  addOrder(order: Object , phone:String , name:String , date:String): Observable<Object> {
    console.log("AddOrder")
    return this.http.post(this.url + "/createOrder/"+name +"/"+ phone +"/"+ date , order );
  }


}
