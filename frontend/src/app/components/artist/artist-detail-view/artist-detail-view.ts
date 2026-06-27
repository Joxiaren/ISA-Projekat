import { Component } from '@angular/core';
import { BaseDetailView } from 'app/components/base-components/base-detail-view/base-detail-view';
import { Artist } from 'model/artist';

@Component({
  selector: 'app-artist-detail-view',
  imports: [],
  templateUrl: './artist-detail-view.html',
  styleUrl: './artist-detail-view.css',
})
export class ArtistDetailView extends BaseDetailView<Artist>{

}
