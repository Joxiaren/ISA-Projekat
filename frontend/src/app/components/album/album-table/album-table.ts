import { Component } from '@angular/core';
import { BaseTable } from 'app/components/base-components/base-table/base-table';
import { ClickStopPropagation } from 'app/directives/click-stop-propagation';
import { Album } from 'model/album';

@Component({
  selector: 'app-album-table',
  imports: [ClickStopPropagation],
  templateUrl: './album-table.html',
  styleUrl: './album-table.css',
})
export class AlbumTable extends BaseTable<Album> {

}
