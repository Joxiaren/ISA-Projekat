import { Component } from '@angular/core';
import { BaseTable } from 'app/components/base-components/base-table/base-table';
import { ClickStopPropagation } from 'app/directives/click-stop-propagation';
import { Song } from 'model/song';

@Component({
  selector: 'app-song-table',
  imports: [ClickStopPropagation],
  templateUrl: './song-table.html',
  styleUrl: './song-table.css',
})
export class SongTable extends BaseTable<Song>{

}
