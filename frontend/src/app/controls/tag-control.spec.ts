import { TestBed } from '@angular/core/testing';

import { TagControl } from './tag-control';

describe('TagControl', () => {
  let service: TagControl;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TagControl);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
