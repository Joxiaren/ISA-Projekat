import { Component, inject, signal } from '@angular/core';
import { SongControl } from 'app/controls/song-control';
import { Song } from 'model/song';

@Component({
  selector: 'app-main-page',
  imports: [],
  templateUrl: './main-page.html',
  styleUrl: './main-page.css',
})
export class MainPage {
  songControl = inject(SongControl);

  song = signal<Song | null>(null);

  constructor(){
    this.songControl.getItem(2, this.song);
  }

}
