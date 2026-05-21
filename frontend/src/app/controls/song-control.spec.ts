import { TestBed } from '@angular/core/testing';

import { SongControl } from './song-control';

describe('SongControl', () => {
  let service: SongControl;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SongControl);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
