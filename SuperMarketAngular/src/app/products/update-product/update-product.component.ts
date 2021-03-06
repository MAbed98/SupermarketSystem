import { Component, ElementRef, OnInit, ViewChild } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ProductService } from 'src/app/services/product.service';
import { Products } from 'src/app/models/products';
import { FormBuilder, FormGroup } from '@angular/forms';
import { CommonService } from 'src/app/services/Common.Service';
import { LoginService } from 'src/app/services/loginService.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  productToBeUpdate: Products = new Products;
  updatedForm!: FormGroup;
  id: number = 0;
  product: Products | undefined ;

  mySelect ='2';
  selectedValue: boolean = this.productToBeUpdate.active;

  data = [
    {
      id: 1,
      name: 'true'
    },
    {
      id: 2,
      name: 'false'
    } ];


  @ViewChild('productNameInput', { static: false }) productNameInput: ElementRef | undefined; // to pass local refernce to out of compnent
  @ViewChild('productPriceInput', { static: false }) productPriceInput: ElementRef | undefined; // to pass local refernce to out of compnent
  @ViewChild('productProductionDateInput', { static: false }) productProductionDateInput: ElementRef | undefined; // to pass local refernce to out of compnent
  @ViewChild('productExpiryDateInput', { static: false }) productExpiryDateInput: ElementRef | undefined; // to pass local refernce to out of compnent
  @ViewChild('productNumberOfItemsInput', { static: false }) productNumberOfItemsInput: ElementRef | undefined; // to pass local refernce to out of compnent
  @ViewChild('productCategoryInput', { static: false }) productCategoryInput: ElementRef | undefined; // to pass local refernce to out of compnent
  @ViewChild('productwidthInput', { static: false }) productwidthInput: ElementRef | undefined; // to pass local refernce to out of compnent
  @ViewChild('productlengthInput', { static: false }) productlengthInput: ElementRef | undefined; // to pass local refernce to out of compnent
  @ViewChild('productHeightInput', { static: false }) productHeightInput: ElementRef | undefined; // to pass local refernce to out of compnent
  @ViewChild('productMadeInInput', { static: false }) productMadeInInput: ElementRef | undefined; // to pass local refernce to out of compnent
  // @ViewChild('productActiveInput', { static: false }) productActiveInput: ElementRef | undefined; // to pass local refernce to out of compnent
  // constructor(private route: ActivatedRoute,private router: Router,
  //   private productService: ProductService) { } 
  constructor(private productService: ProductService ,  private commonService : CommonService , 
    private fb:FormBuilder ,private router: Router , private route: ActivatedRoute ,  private loginService: LoginService){ }
   
    private setLoggedIn(value: boolean): void {
      this.loginService.setLoggedIn(value);
    }
    ngOnInit() {
    this.setLoggedIn(true) ;
    this.product = new Products();
    this.id = this.route.snapshot.params['id'];
    this.productService.getProduct(this.id).subscribe(product2 => this.productToBeUpdate = product2) ;
    // this.mySelect = (this.product.active == true)?'1':'2';
    // console.log("::::::::::::::" + this.productToBeUpdate.active  )
    this.updatedForm = this.fb.group({
      name:[''],
      price:[''],
      production_date:[''] ,
      expiry_date:[''] ,
      number_of_items:['']  ,
      category:[''] ,
      width:  [''] ,
      height:[''] ,
      length:[''] ,
      made_in: [''],
      active:[''],

    }) ;

  }
  selectChange() {
    this.selectedValue = this.commonService.getDropDownText(this.mySelect, this.data)[0].name;
}
  updateProduct() {
   
    this.productService.updateProduct(this.id, this.updatedForm.value)
      .subscribe(data => {
        console.log(data);
        this.product = new Products();
        this.gotoList();
      }, error => console.log(error));

  }

  update() {
    
    console.log(this.productMadeInInput?.nativeElement.value)
    this.updatedForm.setValue({
      name: this.productNameInput?.nativeElement.value ,
      price: this.productPriceInput?.nativeElement.value,
      production_date: this.productProductionDateInput?.nativeElement.value ,
      expiry_date: this.productExpiryDateInput?.nativeElement.value ,
      number_of_items: this.productNumberOfItemsInput?.nativeElement.value  ,
      category: this.productCategoryInput?.nativeElement.value ,
      made_in: this.productMadeInInput?.nativeElement.value ,
      width:  this.productwidthInput?.nativeElement.value,
      height: this.productHeightInput?.nativeElement.value ,
      length: this.productlengthInput ?.nativeElement.value ,
      active: this.selectedValue
    })  ;


    this.updateProduct(  );    
  }

  gotoList() {
    this.router.navigate(['/products']);
  }
}
