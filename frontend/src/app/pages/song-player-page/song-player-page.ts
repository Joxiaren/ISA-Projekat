import { Component, inject, signal, WritableSignal } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { SongControl } from 'app/controls/song-control';
import { Song } from 'model/song';

@Component({
  selector: 'app-song-player-page',
  imports: [],
  templateUrl: './song-player-page.html',
  styleUrl: './song-player-page.css',
})
export class SongPlayerPage {
  activatedRoute = inject(ActivatedRoute);
  songControl = inject(SongControl);

  song: WritableSignal<Song | null> = signal(null);

  constructor(){
    this.activatedRoute.params.subscribe((params) => {
      this.songControl.getItem(params['songId'], this.song);
    })
  }
}
