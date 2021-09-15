import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { Router } from '@angular/router';
import { User } from '../models/User.ts';
import { LoginService } from '../services/loginService.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  // ,  private loginService: LoginService
  constructor(private router:Router ,  private loginService: LoginService ){}
  // If user is logged in, set value to true
  private setLoggedIn(value: boolean): void {
    this.loginService.setLoggedIn(value);
  }
  @Output("viewHeader") viewHeader = new EventEmitter<boolean>() ; // EventEmitter: Event pinding
  // @Output("viewHeader") viewHeader: boolean = true ; // EventEmitter: Event pindi

  // viewHeader = false  ;
  user: User = new User();
  submitted = false;
  loggined=false;


  ngOnInit(): void {
  }

  save() {
    // this.loginService
    // .createUser(this.user).subscribe(data => {
    //   console.log(data)
    //   this.user = new User();
    //   // this.gotoList();
    // }, 
    // error => console.log(error));
  }
  signin() {
    this.submitted = true;
    this.save();    
  }
  onClick()
  {
    this.setLoggedIn(true)
    this.viewHeader.emit(true);
    this.router.navigate(['../products']);
    console.log(this.viewHeader);
  }

}
