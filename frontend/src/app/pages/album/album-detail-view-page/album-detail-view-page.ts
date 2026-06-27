import { Component, inject, signal, WritableSignal } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AlbumDetailView } from 'app/components/album/album-detail-view/album-detail-view';
import { AlbumControl } from 'app/controls/album-control';
import { Album } from 'model/album';

@Component({
  selector: 'app-album-detail-view-page',
  imports: [AlbumDetailView],
  templateUrl: './album-detail-view-page.html',
  styleUrl: './album-detail-view-page.css',
})
export class AlbumDetailViewPage {
  activatedRoute = inject(ActivatedRoute);
  
  albumControl = inject(AlbumControl);

  itemShow : WritableSignal<Album | null> = signal(null);

  constructor(){
    this.activatedRoute.params.subscribe((params) => {
      this.albumControl.getItem(params['id'], this.itemShow)
    })
  }
}
