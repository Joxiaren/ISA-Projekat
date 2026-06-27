import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArtistForm } from './artist-form';

describe('ArtistForm', () => {
  let component: ArtistForm;
  let fixture: ComponentFixture<ArtistForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ArtistForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ArtistForm);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
