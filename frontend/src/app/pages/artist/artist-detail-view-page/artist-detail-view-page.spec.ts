import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtistDetailViewPage } from './artist-detail-view-page';

describe('ArtistDetailViewPage', () => {
  let component: ArtistDetailViewPage;
  let fixture: ComponentFixture<ArtistDetailViewPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ArtistDetailViewPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ArtistDetailViewPage);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
