import { Component } from '@angular/core';
import { BaseDetailView } from 'app/components/base-components/base-detail-view/base-detail-view';
import { Song } from 'model/song';

@Component({
  selector: 'app-song-detail-view',
  imports: [],
  templateUrl: './song-detail-view.html',
  styleUrl: './song-detail-view.css',
})
export class SongDetailView extends BaseDetailView<Song>{

}
