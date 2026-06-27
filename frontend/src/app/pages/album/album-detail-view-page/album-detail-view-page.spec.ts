import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AlbumDetailViewPage } from './album-detail-view-page';

describe('AlbumDetailViewPage', () => {
  let component: AlbumDetailViewPage;
  let fixture: ComponentFixture<AlbumDetailViewPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AlbumDetailViewPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AlbumDetailViewPage);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
