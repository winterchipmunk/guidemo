import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { DeviceComponent } from './device/device.component'
import { DeviceListComponent } from './device-list/device-list.component'
import { DeviceEditComponent } from './device-edit/device-edit.component'

const routes: Routes = [
  {
    path: '',
    component: DeviceComponent,
    children: [
      {
        path: '', 
        component: DeviceListComponent
      },
      {
        path: 'list', 
        component: DeviceListComponent
      },
      {
        path: 'edit/:id',
        component: DeviceEditComponent
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
export class DeviceRoutingModule { }
