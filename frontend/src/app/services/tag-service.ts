import { Injectable } from '@angular/core';
import { BaseService } from 'app/services/base-service';
import { Tag } from 'model/tag';

@Injectable({
  providedIn: 'root',
})
export class TagService extends BaseService<Tag>{
  override resource = "api/tag";
}
