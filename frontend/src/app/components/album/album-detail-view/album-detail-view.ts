import { Component } from '@angular/core';
import { BaseDetailView } from 'app/components/base-components/base-detail-view/base-detail-view';
import { Album } from 'model/album';

@Component({
  selector: 'app-album-detail-view',
  imports: [],
  templateUrl: './album-detail-view.html',
  styleUrl: './album-detail-view.css',
})
export class AlbumDetailView extends BaseDetailView<Album>{

}
