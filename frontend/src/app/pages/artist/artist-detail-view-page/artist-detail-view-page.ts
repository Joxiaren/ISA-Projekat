import { Component, inject, signal, WritableSignal } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { ArtistDetailView } from 'app/components/artist/artist-detail-view/artist-detail-view';
import { ArtistControl } from 'app/controls/artist-control';
import { Artist } from 'model/artist';

@Component({
  selector: 'app-artist-detail-view-page',
  imports: [ArtistDetailView],
  templateUrl: './artist-detail-view-page.html',
  styleUrl: './artist-detail-view-page.css',
})
export class ArtistDetailViewPage {
  activatedRoute = inject(ActivatedRoute);
  
  artistControl = inject(ArtistControl);

  itemShow : WritableSignal<Artist | null> = signal(null);

  constructor(){
    this.activatedRoute.params.subscribe((params) => {
      this.artistControl.getItem(params['id'], this.itemShow)
    })
  }
}
