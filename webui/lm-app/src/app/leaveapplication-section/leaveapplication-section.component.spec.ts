import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LeaveapplicationSectionComponent } from './leaveapplication-section.component';

describe('LeaveapplicationSectionComponent', () => {
  let component: LeaveapplicationSectionComponent;
  let fixture: ComponentFixture<LeaveapplicationSectionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LeaveapplicationSectionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LeaveapplicationSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
