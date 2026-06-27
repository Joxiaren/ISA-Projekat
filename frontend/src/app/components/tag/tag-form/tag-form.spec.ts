import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TagForm } from './tag-form';

describe('TagForm', () => {
  let component: TagForm;
  let fixture: ComponentFixture<TagForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TagForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TagForm);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
