import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { RouterModule } from '@angular/router'
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ProductsComponent } from './products/products.component';
import { HeaderComponent } from './header/header.component';
import { LoginComponent } from './login/login.component';
import { HttpClientModule } from '@angular/common/http';
import { UpdateProductComponent } from './products/update-product/update-product.component';
import { FormsModule , ReactiveFormsModule } from '@angular/forms';
import { AddProductComponent } from './products/add-product/add-product.component';
import { OrdersComponent } from './orders/orders.component';

@NgModule({
  declarations: [
    AppComponent,
    ProductsComponent,
    HeaderComponent,
    LoginComponent,
    UpdateProductComponent,
    AddProductComponent,
    OrdersComponent,
    
    ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule.forRoot([
      {path: 'products' , component:ProductsComponent },
      {path: 'login' , component:LoginComponent },
      {path: 'products/updateProduct/:id' , component:UpdateProductComponent } ,
      {path: 'products/addProduct' , component:AddProductComponent } ,
      {path: 'orders' , component:OrdersComponent },
      {path: '' , component:HeaderComponent },
    ])
  ],
  providers: [OrdersComponent],
  bootstrap: [AppComponent]
})
export class AppModule {

 }
