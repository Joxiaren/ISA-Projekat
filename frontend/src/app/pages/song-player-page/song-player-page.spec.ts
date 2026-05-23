import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SongPlayerPage } from './song-player-page';

describe('SongPlayerPage', () => {
  let component: SongPlayerPage;
  let fixture: ComponentFixture<SongPlayerPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SongPlayerPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SongPlayerPage);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
