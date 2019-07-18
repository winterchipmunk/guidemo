import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute, ParamMap } from '@angular/router';
import { Observable } from 'rxjs';
import { FormGroup, FormControl, FormBuilder, Validators, FormArray } from '@angular/forms';
import { switchMap, catchError, map } from 'rxjs/operators';

import { DeviceService } from '../services/device.service'
import { Device } from '../services/device'
import { FormGroupMaker } from '../device.desc'

@Component({
  selector: 'app-device-edit',
  templateUrl: './device-edit.component.html',
  styleUrls: ['./device-edit.component.scss']
})
export class DeviceEditComponent implements OnInit {

  id : number;
  device$ : Observable<Device>;
  device : Device;
  form : FormGroup;
  error : string;

  constructor(
    private route: ActivatedRoute,
    private router: Router,
    private service: DeviceService,
    private fb: FormBuilder
  ) {
  }

  ngOnInit() {
    this.form = FormGroupMaker.makeFormGroup(this.fb);

    this.fetchData();
  }

  fetchData() {
    this.route.paramMap.pipe(
      switchMap(
        (params: ParamMap) => {
          this.id = +params.get('id');
          return this.service.getDevice(this.id);
        }
      ),
      catchError(error => {
        window.alert(error);
        return null;
      })
    ).subscribe((device : Device) => {
      try {
        this.form.patchValue(device); 
      } catch( error ) {
        console.log("error occurred when patching value");
      }
    },
    error => {
      this.error = error;
    });
  }

  onSubmit() {
    this.service.updateDevice(this.form.value).subscribe(ret => {
      this.gotoList(this.form.value);
    },
    error => {
      this.error = error;
    });
  }

  onCancel() {
    this.gotoList(this.form.value);
  }

  gotoList(device : Device) {
    let id = device ? device.id : null
    this.router.navigate(['/device/list', {id: id, foo: 'foo'}]);
  }
}
