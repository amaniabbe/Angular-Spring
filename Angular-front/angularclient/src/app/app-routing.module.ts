import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserFormComponent} from './user-form/user-form.component';
import { UserListComponent} from './user-list/user-list.component';
import {UserService} from './service/user-service.service';
import {LoginComponent} from './login/login.component';

const routes: Routes = [
  { path:'', redirectTo : '/users', pathMatch:'full' },
  { path:'users', component:UserListComponent , canActivate : [UserService]},
  { path:'adduser', component:UserFormComponent, canActivate : [UserService]},
  { path:'login', component:LoginComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
