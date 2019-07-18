import { Injectable } from '@angular/core';
import { Observable, of, throwError } from 'rxjs';
import { HttpClient, HttpHeaders, HttpErrorResponse } from '@angular/common/http';
import { catchError, map, tap, retry } from 'rxjs/operators';

import { Device } from './device'

const DEVICE_URL = "http://localhost:8080/api/device";

@Injectable({
  providedIn: 'root'
})
export class DeviceService {

  constructor(
    private http: HttpClient    
  ) {
  }

  listDevices(): Observable<Device[]> {
    return this.http.get<Device[]>(DEVICE_URL + '/list').pipe(
      retry(3), // retry a failed request up to 3 times
      catchError(this.handleError)
    );
  }

  getDevice(id : number) : Observable<Device> {
    return this.http.get<Device>(DEVICE_URL + '/detail/' + id).pipe(
      retry(3),
      catchError(this.handleError)
    );
  }

  updateDevice(device : Device) : Observable<boolean> {
    return this.http.post<boolean>(DEVICE_URL + '/update', device).pipe(
      retry(3),
      catchError(this.handleError)
    )
  }

  handleError(error: HttpErrorResponse) {
    if (error.error instanceof ErrorEvent) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error.message);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong,
      console.error(
        `Backend returned code ${error.status}, ` +
        `body was: ${error.error}`);
    }
    // return an observable with a user-facing error message
    return throwError(
      'Something bad happened; please try again later.');
  }
}
