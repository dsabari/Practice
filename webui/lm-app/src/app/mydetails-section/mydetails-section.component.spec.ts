import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { MydetailsSectionComponent } from './mydetails-section.component';

describe('MydetailsSectionComponent', () => {
  let component: MydetailsSectionComponent;
  let fixture: ComponentFixture<MydetailsSectionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ MydetailsSectionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(MydetailsSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
