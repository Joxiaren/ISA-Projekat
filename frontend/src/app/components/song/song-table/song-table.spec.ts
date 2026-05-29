import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SongTable } from './song-table';

describe('SongTable', () => {
  let component: SongTable;
  let fixture: ComponentFixture<SongTable>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SongTable]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SongTable);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
