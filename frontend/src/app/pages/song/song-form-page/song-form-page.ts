import { Location } from '@angular/common';
import { Component, inject } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { SongForm } from 'app/components/song/song-form/song-form';
import { SongControl } from 'app/controls/song-control';

@Component({
  selector: 'app-song-form-page',
  imports: [SongForm],
  templateUrl: './song-form-page.html',
  styleUrl: './song-form-page.css',
})
export class SongFormPage {
  router = inject(Router);
  activatedRoute = inject(ActivatedRoute);
  location = inject(Location);

  songControl = inject(SongControl);

  constructor(){
    this.songControl.dataRefresh();
    this.activatedRoute.params.subscribe((params) => {
      if(params['id'] == null){
        this.songControl.itemEdit.set(null);
        return;
      }

      this.songControl.getItem(params['id'], this.songControl.itemEdit);
    });
  }

  submitEvent(success: boolean){
    if(success) this.location.back();
  }
  cancel(){
    this.location.back();
  }
}
