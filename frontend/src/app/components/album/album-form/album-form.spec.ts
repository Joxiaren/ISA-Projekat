import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlbumForm } from './album-form';

describe('AlbumForm', () => {
  let component: AlbumForm;
  let fixture: ComponentFixture<AlbumForm>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AlbumForm]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AlbumForm);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
