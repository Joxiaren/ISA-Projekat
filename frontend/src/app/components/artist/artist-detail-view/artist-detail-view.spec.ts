import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtistDetailView } from './artist-detail-view';

describe('ArtistDetailView', () => {
  let component: ArtistDetailView;
  let fixture: ComponentFixture<ArtistDetailView>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ArtistDetailView]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ArtistDetailView);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
