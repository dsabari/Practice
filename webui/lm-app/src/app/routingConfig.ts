import { RouterModule, Routes} from '@angular/router';
import { NgModule } from '@angular/core';
import { LoginComponent } from './login/login.component';
import { LeaveapplicationSectionComponent } from './leaveapplication-section/leaveapplication-section.component';
import { EmployeeDashboardComponent } from './employee-dashboard/employee-dashboard.component';

import { HomeComponent } from './home/home.component';

const routesInfo:Routes = [
    {path: 'login/:empId', component:LoginComponent},
    {path: 'dashboard', component:EmployeeDashboardComponent},
    {path: 'home', component: HomeComponent},
    {path:'leaveapp',component:LeaveapplicationSectionComponent},
    {path:'',redirectTo:'home', pathMatch:'full'}
    
]

@NgModule({
    imports: [RouterModule.forRoot(routesInfo)],
    exports:[RouterModule]
})

export class RoutingConfig {

}