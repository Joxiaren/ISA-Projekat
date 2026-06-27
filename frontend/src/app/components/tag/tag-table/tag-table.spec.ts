import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TagTable } from './tag-table';

describe('TagTable', () => {
  let component: TagTable;
  let fixture: ComponentFixture<TagTable>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TagTable]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TagTable);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
