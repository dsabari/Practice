export class Employee {
    empId: number;
    empName: String;
    empPhone: number;
    empEmail: String;
    empDept:String;
    empManagerId: number;
    empLeaveBalance:number;
    empDoj:Date;
    constructor(id: number,empName: string, empPhoneNumber: number, empEmail:string, empDept:String, empMgrId: number, empLeaveBalance:number, empDoj:Date) {
      this.empId = id;
      this.empName = empName;
      this.empPhone = empPhoneNumber;
      this.empEmail = empEmail;
      this.empDept = empDept;
      this.empManagerId = empMgrId;
      this.empLeaveBalance = empLeaveBalance;
      this.empDoj = empDoj;
    }
}
