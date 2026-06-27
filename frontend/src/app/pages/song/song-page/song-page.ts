import { Component, inject } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { SongTable } from 'app/components/song/song-table/song-table';
import { SongControl } from 'app/controls/song-control';

@Component({
  selector: 'app-song-page',
  imports: [SongTable],
  templateUrl: './song-page.html',
  styleUrl: './song-page.css',
})
export class SongPage {
  router = inject(Router);
  activatedRoute = inject(ActivatedRoute);

  songControl = inject(SongControl);

  constructor(){
    this.dataRefresh();
    this.songControl.itemEditEmit.subscribe(e => {
      this.router.navigate([`${e}/edit`], {relativeTo: this.activatedRoute});
    });
  }

  dataRefresh(){
    this.songControl.dataRefresh();
  }
  add(){
    this.router.navigate(['add'], {relativeTo: this.activatedRoute});
  }
}
