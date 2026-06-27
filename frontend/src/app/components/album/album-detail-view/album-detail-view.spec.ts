import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlbumDetailView } from './album-detail-view';

describe('AlbumDetailView', () => {
  let component: AlbumDetailView;
  let fixture: ComponentFixture<AlbumDetailView>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AlbumDetailView]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AlbumDetailView);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
