import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { PolicyComponent } from './policy/policy.component';
import { PolicyListComponent } from './policy-list/policy-list.component';
import { PolicyEditComponent } from './policy-edit/policy-edit.component';
import { ProfileListComponent } from './profile-list/profile-list.component';
import { PolicyRoutingModule } from './policy-routing.module';

import {
  MatButtonModule,
  MatInputModule,
  MatRippleModule,
  MatFormFieldModule,
  MatTooltipModule,
  MatSelectModule
} from '@angular/material';

@NgModule({
  declarations: [
    PolicyComponent, 
    PolicyListComponent, 
    PolicyEditComponent, 
    ProfileListComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    MatButtonModule,
    MatRippleModule,
    MatFormFieldModule,
    MatInputModule,
    MatSelectModule,
    MatTooltipModule,

    PolicyRoutingModule
  ]
})
export class PolicyModule { }
