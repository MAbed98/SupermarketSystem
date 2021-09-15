import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {
  @Input('is-Login') isLoginPage: any
 


  showHeader: boolean = true
  constructor() { }

  ngOnInit(): void {
  }

}
