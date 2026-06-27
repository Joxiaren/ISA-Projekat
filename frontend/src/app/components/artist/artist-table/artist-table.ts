import { Component } from '@angular/core';
import { BaseTable } from 'app/components/base-components/base-table/base-table';
import { ClickStopPropagation } from 'app/directives/click-stop-propagation';
import { Artist } from 'model/artist';

@Component({
  selector: 'app-artist-table',
  imports: [ClickStopPropagation],
  templateUrl: './artist-table.html',
  styleUrl: './artist-table.css',
})
export class ArtistTable extends BaseTable<Artist> {

}
