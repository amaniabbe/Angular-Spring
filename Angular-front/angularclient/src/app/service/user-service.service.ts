import { Injectable } from '@angular/core';
import {CanActivate, Router} from '@angular/router';
import { HttpClient, HttpHeaders} from '@angular/common/http';
import { User } from '../model/user';
import { Observable } from 'rxjs';



@Injectable()
export class UserService implements CanActivate {


  private userUrl:string;
  
  authenticated = false;

  constructor(private http: HttpClient, private router:Router) { 
    this.userUrl = 'http://localhost:8080';
  }

  public findAll():Observable<User[]>{
    return this.http.get<User[]>(this.userUrl);
  }

  public save(user:User){
    return this.http.post<User>(this.userUrl + '/users', user);
  }

  authenticate(credentials , callback){
    const headers = new HttpHeaders(credentials ?{
      authorization : 'Basic' + btoa('user' + ':' + 'pass')
    }: {});

    this.http.get(this.userUrl + '/auth', {headers:headers}).subscribe(Response => {
       if(Response['name']){
         this.authenticated = true;
       } else {
         this.authenticated = false;
       }

       return callback && callback();
    })
  }

  canActivate():boolean{
    if(!this.authenticated){
      this.router.navigate(['login']);
      return false;
    }

    return true;
  }

}
