import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SongDetailViewPage } from './song-detail-view-page';

describe('SongDetailViewPage', () => {
  let component: SongDetailViewPage;
  let fixture: ComponentFixture<SongDetailViewPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SongDetailViewPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SongDetailViewPage);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
