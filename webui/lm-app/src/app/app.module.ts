import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpModule } from '@angular/http';
import { FormsModule } from "@angular/forms";

import { AppComponent } from './app.component';
import { RoutingConfig } from './routingConfig';

import { EmployeeDashboardComponent } from './employee-dashboard/employee-dashboard.component';
import { LoginComponent } from './login/login.component';
import { MydetailsSectionComponent } from './mydetails-section/mydetails-section.component';
import { ManagerSectionComponent } from './manager-section/manager-section.component';
import { LeaveapplicationSectionComponent } from './leaveapplication-section/leaveapplication-section.component';
import { PendingleaveSectionComponent } from './pendingleave-section/pendingleave-section.component';
import { HomeComponent } from './home/home.component';


@NgModule({
  declarations: [
    AppComponent,
    EmployeeDashboardComponent,
    LoginComponent,
    MydetailsSectionComponent,
    ManagerSectionComponent,
    LeaveapplicationSectionComponent,
    PendingleaveSectionComponent,
    HomeComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    RoutingConfig
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
