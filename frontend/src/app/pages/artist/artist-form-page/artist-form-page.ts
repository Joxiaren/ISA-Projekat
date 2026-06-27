import { Location } from '@angular/common';
import { Component, inject } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { ArtistForm } from 'app/components/artist/artist-form/artist-form';
import { ArtistControl } from 'app/controls/artist-control';

@Component({
  selector: 'app-artist-form-page',
  imports: [ArtistForm],
  templateUrl: './artist-form-page.html',
  styleUrl: './artist-form-page.css',
})
export class ArtistFormPage {
  router = inject(Router);
  activatedRouter = inject(ActivatedRoute);
  location = inject(Location);

  artistControl = inject(ArtistControl);

  constructor(){
    this.artistControl.dataRefresh();
    this.activatedRouter.params.subscribe((params) => {
      if(params['id'] == null){
        this.artistControl.itemEdit.set(null);
        return;
      }

      this.artistControl.getItem(params['id'], this.artistControl.itemEdit);
    })
  }

  submitEvent(success: boolean){
    if(success) this.location.back();
  }
  cancel(){
    this.location.back();
  }
}
