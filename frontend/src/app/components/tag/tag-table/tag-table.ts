import { Component } from '@angular/core';
import { BaseTable } from 'app/components/base-components/base-table/base-table';
import { ClickStopPropagation } from 'app/directives/click-stop-propagation';
import { Tag } from 'model/tag';

@Component({
  selector: 'app-tag-table',
  imports: [ClickStopPropagation],
  templateUrl: './tag-table.html',
  styleUrl: './tag-table.css',
})
export class TagTable extends BaseTable<Tag> {

}
