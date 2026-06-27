import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TagFormPage } from './tag-form-page';

describe('TagFormPage', () => {
  let component: TagFormPage;
  let fixture: ComponentFixture<TagFormPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TagFormPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TagFormPage);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
