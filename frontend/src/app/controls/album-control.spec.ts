import { TestBed } from '@angular/core/testing';

import { AlbumControl } from './album-control';

describe('AlbumControl', () => {
  let service: AlbumControl;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AlbumControl);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
