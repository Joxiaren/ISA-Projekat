import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TagDetailView } from './tag-detail-view';

describe('TagDetailView', () => {
  let component: TagDetailView;
  let fixture: ComponentFixture<TagDetailView>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TagDetailView]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TagDetailView);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
