import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { LeaveDetailsService } from '../leavedetails.service';
import { LeaveDetails } from '../leavedetails';
import {ActivatedRoute} from '@angular/router';
@Component({
  selector: 'app-leaveapplication-section',
  templateUrl: './leaveapplication-section.component.html',
  styleUrls: ['./leaveapplication-section.component.css'],
  providers: [ LeaveDetailsService ]
})
export class LeaveapplicationSectionComponent implements OnInit {

  constructor(private leavedetailsService:LeaveDetailsService,private router:Router , private activeroute:ActivatedRoute) { }
  leavedetails:LeaveDetails[];

  getLeaveDetails(): void {
    this.leavedetailsService.getLeaveDetails().then(leavedetails => {
      console.log('getLeaveDetails promise resolved : ' + leavedetails.length);
      this.leavedetails = leavedetails;
    }
    );
  }
 applyleave():void{
   this.router.navigate(['/applyleave'])
 }

  ngOnInit():void {
    this.getLeaveDetails();
  }

}


