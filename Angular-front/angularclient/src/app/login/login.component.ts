import { Component, OnInit } from '@angular/core';
import { UserService} from '../service/user-service.service'


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  credentials = {username : '' , password:''}

  constructor(private userService:UserService) { }

  ngOnInit() {
  }

  login(){
    this.userService.authenticate(this.credentials , ()=>{});
    return false;
  }

}
