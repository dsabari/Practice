export enum LeaveType{
  EL
}
export enum LeaveStatus{
  APPROVED,DENIED,PENDING
}

export class LeaveDetails {
    leaveId: number;
    noOfDays: number;
    startDate: Date;
    endDate: Date;
    leaveType:LeaveType;
    leaveStatus: LeaveStatus;
    leaveReason:String;
    leaveAppliedOn:Date;
    managerComments:string;
    constructor(leaveId: number,noOfDays: number, startDate: Date, endDate: Date, leaveType: LeaveType, leaveStatus: LeaveStatus, leaveReason: String, leaveAppliedOn: Date, managerComments: string) {
      this.leaveId = leaveId;
      this.noOfDays = noOfDays;
      this.startDate = startDate;
      this.endDate = endDate;
      this.leaveType = leaveType ;
      this.leaveStatus = leaveStatus;
      this.leaveReason = leaveReason;
      this.leaveAppliedOn = leaveAppliedOn;
      this.managerComments =managerComments;
    }
}
