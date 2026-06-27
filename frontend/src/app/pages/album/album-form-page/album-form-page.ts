import { Location } from '@angular/common';
import { Component, inject } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { AlbumForm } from 'app/components/album/album-form/album-form';
import { AlbumControl } from 'app/controls/album-control';

@Component({
  selector: 'app-album-form-page',
  imports: [AlbumForm],
  templateUrl: './album-form-page.html',
  styleUrl: './album-form-page.css',
})
export class AlbumFormPage {
  router = inject(Router);
  activatedRoute = inject(ActivatedRoute);
  location = inject(Location);

  albumControl = inject(AlbumControl);

  constructor(){
    this.albumControl.dataRefresh();
    this.activatedRoute.params.subscribe((params) => {
      if(params['id'] == null){
        this.albumControl.itemEdit.set(null);
        return;
      }

      this.albumControl.getItem(params['id'], this.albumControl.itemEdit);
    });
  }

  submitEvent(success: boolean){
    if(success) this.location.back();
  }
  cancel(){
    this.location.back();
  }
}
