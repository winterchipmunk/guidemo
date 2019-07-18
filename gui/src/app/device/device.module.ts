import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DeviceListComponent } from '../device/device-list/device-list.component';
import { DeviceEditComponent } from './device-edit/device-edit.component';
import { DeviceRoutingModule } from './device-routing.module';
import { DeviceComponent } from './device/device.component';

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
    DeviceListComponent, 
    DeviceEditComponent, 
    DeviceComponent
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

    DeviceRoutingModule
  ],
  exports: [
    DeviceRoutingModule
  ]
})
export class DeviceModule { }
