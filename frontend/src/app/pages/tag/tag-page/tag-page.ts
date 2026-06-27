import { Component, inject } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { TagTable } from 'app/components/tag/tag-table/tag-table';
import { TagControl } from 'app/controls/tag-control';

@Component({
  selector: 'app-tag-page',
  imports: [TagTable],
  templateUrl: './tag-page.html',
  styleUrl: './tag-page.css',
})
export class TagPage {
  router = inject(Router);
  activatedRoute = inject(ActivatedRoute);

  tagControl = inject(TagControl);

  constructor(){
    this.dataRefresh();
    this.tagControl.itemEditEmit.subscribe(e => {
      this.router.navigate([`${e}/edit`], {relativeTo: this.activatedRoute});
    });
  }

  dataRefresh(){
    this.tagControl.dataRefresh();
  }
  add(){
    this.router.navigate(['add'], {relativeTo: this.activatedRoute});
  }
}
