import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PendingleaveSectionComponent } from './pendingleave-section.component';

describe('PendingleaveSectionComponent', () => {
  let component: PendingleaveSectionComponent;
  let fixture: ComponentFixture<PendingleaveSectionComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PendingleaveSectionComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PendingleaveSectionComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should be created', () => {
    expect(component).toBeTruthy();
  });
});
