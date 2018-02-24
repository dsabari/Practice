import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { EmployeeService } from '../employee.service';
import { Employee } from '../employee';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css'],
  providers: [EmployeeService]
})
export class HomeComponent implements OnInit {
  constructor(private employeeService: EmployeeService,private router: Router) { }
  employees: Employee[];

  getEmployees(): void {
    this.employeeService.getEmployees().then(employees => {
      console.log('getEmployees promise resolved : ' + employees.length);
      this.employees = employees;
    }
    );
  }
  verifyLogin(empId):void{
    this.router.navigate(['/login/'+empId])
  }

  
  ngOnInit() {
    this.getEmployees();
  }

}
