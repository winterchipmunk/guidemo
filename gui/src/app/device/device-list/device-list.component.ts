import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { switchMap, catchError, map } from 'rxjs/operators';
import { Observable, of } from 'rxjs';

import { Device } from '../services/device'
import { DeviceService } from '../services/device.service'

@Component({
  selector: 'app-device-list',
  templateUrl: './device-list.component.html',
  styleUrls: ['./device-list.component.scss']
})
export class DeviceListComponent implements OnInit {

  deviceList$: Observable<Device[]>;
  selectedId: number;
  error: string;
  type : number;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private service : DeviceService
  ) {
  }

  ngOnInit() {
    this.listDeviceAsync();
  }

  listDeviceAsync() {

    this.deviceList$ = this.route.paramMap.pipe(
      switchMap((params: ParamMap) => {
        // (+) before `params.get()` turns the string into a number
        this.selectedId = +params.get('id');
        return this.route.queryParamMap
      }),
      switchMap((queryParams: ParamMap) => {
        // deal with ParamMap
        this.type = +queryParams.get('type');
        return this.service.listDevices();
      }),
      catchError(error => {
        this.error = error
        return [];
      })
    )

  }

  onSelect(device : Device) {
    let id = device ? device.id : null
    this.router.navigate(['/device/edit', id, {foo: 'foo'}]);
  }
}
