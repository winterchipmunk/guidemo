import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { PolicyComponent } from './policy/policy.component';
import { PolicyListComponent } from './policy-list/policy-list.component';
import { PolicyEditComponent } from './policy-edit/policy-edit.component';
import { ProfileListComponent } from './profile-list/profile-list.component';

const routes: Routes = [
  {
    path: '',
    component: PolicyComponent,
    children: [
      {
        path: '', 
        component: ProfileListComponent
      },
      {
        path: 'list', 
        component: PolicyListComponent
      },
      {
        path: 'edit/:id',
        component: PolicyEditComponent
      }
    ]
  }
];

@NgModule({
  imports: [
    RouterModule.forChild(routes)
  ],
  exports: [
    RouterModule
  ]
})
export class PolicyRoutingModule { }
