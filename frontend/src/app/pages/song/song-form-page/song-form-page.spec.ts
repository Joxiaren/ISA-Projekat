import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SongFormPage } from './song-form-page';

describe('SongFormPage', () => {
  let component: SongFormPage;
  let fixture: ComponentFixture<SongFormPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SongFormPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SongFormPage);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
