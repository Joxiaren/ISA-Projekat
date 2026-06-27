import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtistFormPage } from './artist-form-page';

describe('ArtistFormPage', () => {
  let component: ArtistFormPage;
  let fixture: ComponentFixture<ArtistFormPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ArtistFormPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ArtistFormPage);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
