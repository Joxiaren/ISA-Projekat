import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TagDetailViewPage } from './tag-detail-view-page';

describe('TagDetailViewPage', () => {
  let component: TagDetailViewPage;
  let fixture: ComponentFixture<TagDetailViewPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TagDetailViewPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TagDetailViewPage);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
