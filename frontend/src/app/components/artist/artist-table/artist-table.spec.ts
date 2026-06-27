import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtistTable } from './artist-table';

describe('ArtistTable', () => {
  let component: ArtistTable;
  let fixture: ComponentFixture<ArtistTable>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ArtistTable]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ArtistTable);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
