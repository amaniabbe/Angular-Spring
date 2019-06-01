import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { UserFormComponent} from './user-form/user-form.component';
import { UserListComponent} from './user-list/user-list.component';

const routes: Routes = [
  { path:'', redirectTo : '/users', pathMatch:'full' },
  { path:'users', component:UserListComponent},
  { path:'adduser', component:UserFormComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
