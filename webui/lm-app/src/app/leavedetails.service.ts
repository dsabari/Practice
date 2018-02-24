import {LeaveDetails } from './leavedetails';

import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/toPromise';

import { Http } from '@angular/http';
import { Injectable } from '@angular/core';


@Injectable()
export class LeaveDetailsService {
    constructor(private http: Http) {
    }

    getLeaveDetails(): Promise<LeaveDetails[]> {
        console.log('getLeaveDetails called on leavedetails.service');
        return this.http.get('http://localhost:8080/ftp12-0.0.1-SNAPSHOT/api/leavedetails/listleavehistory/2000')
        .toPromise()
        .then(response => response.json() as LeaveDetails[])
        .catch(this.handleError);
    }

    private handleError(error: any): Promise<any> {
        console.error('An error occurred', error); // for demo purposes only
        return Promise.reject(error.message || error);
    }
}
