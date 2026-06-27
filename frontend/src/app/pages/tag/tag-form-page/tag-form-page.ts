import { Location } from '@angular/common';
import { Component, inject } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { TagForm } from 'app/components/tag/tag-form/tag-form';
import { TagControl } from 'app/controls/tag-control';

@Component({
  selector: 'app-tag-form-page',
  imports: [TagForm],
  templateUrl: './tag-form-page.html',
  styleUrl: './tag-form-page.css',
})
export class TagFormPage {
  router = inject(Router);
  activatedRouter = inject(ActivatedRoute);
  location = inject(Location);

  tagControl = inject(TagControl);

  constructor(){
    this.tagControl.dataRefresh();
    this.activatedRouter.params.subscribe((params) => {
      if(params['id'] == null){
        this.tagControl.itemEdit.set(null);
        return;
      }

      this.tagControl.getItem(params['id'], this.tagControl.itemEdit);
    })
  }

  submitEvent(success: boolean){
    if(success) this.location.back();
  }
  cancel(){
    this.location.back();
  }
}
