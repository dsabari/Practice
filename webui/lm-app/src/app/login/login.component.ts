import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from "@angular/router";
@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private router: Router, private activateroute:ActivatedRoute) { }
  empId:number;
  verifyDashboard(): void {
    this.router.navigate(['/dashboard'])
  }

  verifyHome(): void {
    this.router.navigate(['/home'])
  }

  ngOnInit() {
    this.empId = this.activateroute.snapshot.params['empId'];
  }

}
