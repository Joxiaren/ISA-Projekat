import { Component, inject, signal, WritableSignal } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SongDetailView } from 'app/components/song/song-detail-view/song-detail-view';
import { SongControl } from 'app/controls/song-control';
import { Song } from 'model/song';

@Component({
  selector: 'app-song-detail-view-page',
  imports: [SongDetailView],
  templateUrl: './song-detail-view-page.html',
  styleUrl: './song-detail-view-page.css',
})
export class SongDetailViewPage {
  activatedRoute = inject(ActivatedRoute);
  
  songControl = inject(SongControl);

  itemShow : WritableSignal<Song | null> = signal(null);

  constructor(){
    this.activatedRoute.params.subscribe((params) => {
      this.songControl.getItem(params['id'], this.itemShow)
    })
  }
}
