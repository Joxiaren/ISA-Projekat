import { Component } from '@angular/core';
import { BaseDetailView } from 'app/components/base-components/base-detail-view/base-detail-view';
import { Tag } from 'model/tag';

@Component({
  selector: 'app-tag-detail-view',
  imports: [],
  templateUrl: './tag-detail-view.html',
  styleUrl: './tag-detail-view.css',
})
export class TagDetailView extends BaseDetailView<Tag>{

}
