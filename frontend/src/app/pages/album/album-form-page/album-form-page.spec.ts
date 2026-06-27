import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlbumFormPage } from './album-form-page';

describe('AlbumFormPage', () => {
  let component: AlbumFormPage;
  let fixture: ComponentFixture<AlbumFormPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AlbumFormPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AlbumFormPage);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
