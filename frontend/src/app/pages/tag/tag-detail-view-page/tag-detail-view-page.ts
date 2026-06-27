import { Component, inject, signal, WritableSignal } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { TagDetailView } from 'app/components/tag/tag-detail-view/tag-detail-view';
import { TagControl } from 'app/controls/tag-control';
import { Tag } from 'model/tag';

@Component({
  selector: 'app-tag-detail-view-page',
  imports: [TagDetailView],
  templateUrl: './tag-detail-view-page.html',
  styleUrl: './tag-detail-view-page.css',
})
export class TagDetailViewPage {
  activatedRoute = inject(ActivatedRoute);
  
  tagControl = inject(TagControl);

  itemShow : WritableSignal<Tag | null> = signal(null);

  constructor(){
    this.activatedRoute.params.subscribe((params) => {
      this.tagControl.getItem(params['id'], this.itemShow)
    })
  }
}
