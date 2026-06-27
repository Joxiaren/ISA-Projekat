import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlbumTable } from './album-table';

describe('AlbumTable', () => {
  let component: AlbumTable;
  let fixture: ComponentFixture<AlbumTable>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AlbumTable]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AlbumTable);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
