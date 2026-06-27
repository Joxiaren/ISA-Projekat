import { inject, Injectable } from '@angular/core';
import { BaseControl } from 'app/controls/base-control';
import { BaseService } from 'app/services/base-service';
import { TagService } from 'app/services/tag-service';
import { Tag } from 'model/tag';

@Injectable({
  providedIn: 'root',
})
export class TagControl extends BaseControl<Tag>{
  override service: TagService = inject(TagService);
  override controlName: string = "Tag";
}
