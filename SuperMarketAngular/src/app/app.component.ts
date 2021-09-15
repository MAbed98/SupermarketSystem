import { Component, Input, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Subscription } from 'rxjs';
import { LoginService } from './services/loginService.service';



@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit{

  public userLoggedIn!: boolean;
  private subscription!: Subscription;

  constructor(
    private loginService: LoginService ,
    private router: Router
  ) {  }


  @Input('viewHeader')viewHeader!: boolean;

   ngOnInit(): void {

        // get the current value
    this.subscription = this.loginService.getLoggedIn().subscribe(value => {
      this.userLoggedIn = value;
  });


  }

  ngOnDestroy(): void {

    if(this.subscription){
        this.subscription.unsubscribe();
    }
 
 }

  // viewHeader = false ;
  title = 'SuperMarketAngular';

  noHeader()
  {
    this.viewHeader = false
    console.log("test:  " , this.viewHeader)
  }

}
 
