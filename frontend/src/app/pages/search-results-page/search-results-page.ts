import { Component, inject, signal, WritableSignal } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SongControl } from 'app/controls/song-control';
import { Song } from 'model/song';

@Component({
  selector: 'app-search-results-page',
  imports: [],
  templateUrl: './search-results-page.html',
  styleUrl: './search-results-page.css',
})
export class SearchResultsPage {
  router = inject(Router);
  activatedRoute = inject(ActivatedRoute);

  songControl = inject(SongControl);

  searchResults : WritableSignal<Song[]> = signal([]);

  constructor(){
    this.activatedRoute.queryParams.subscribe((params) => {
      this.songControl.search(params['s'], this.searchResults);
    })
  }

  playSong(id: number){
    this.router.navigate([`play/${id}`]);
  }
}
