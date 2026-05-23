import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SearchResultsPage } from './search-results-page';

describe('SearchResultsPage', () => {
  let component: SearchResultsPage;
  let fixture: ComponentFixture<SearchResultsPage>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SearchResultsPage]
    })
    .compileComponents();

    fixture = TestBed.createComponent(SearchResultsPage);
    component = fixture.componentInstance;
    await fixture.whenStable();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
