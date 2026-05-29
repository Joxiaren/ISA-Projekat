import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SongDetailView } from './song-detail-view';

describe('SongDetailView', () => {
  let component: SongDetailView;
  let fixture: ComponentFixture<SongDetailView>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SongDetailView]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SongDetailView);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
