import { TestBed } from '@angular/core/testing';

import { ArtistControl } from './artist-control';

describe('ArtistControl', () => {
  let service: ArtistControl;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ArtistControl);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
