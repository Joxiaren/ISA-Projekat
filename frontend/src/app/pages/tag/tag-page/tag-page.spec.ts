import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TagPage } from './tag-page';

describe('TagPage', () => {
  let component: TagPage;
  let fixture: ComponentFixture<TagPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TagPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TagPage);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
