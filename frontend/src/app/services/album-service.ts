import { Injectable } from '@angular/core';
import { BaseService } from 'app/services/base-service';
import { Album } from 'model/album';

@Injectable({
  providedIn: 'root',
})
export class AlbumService extends BaseService<Album> {
  override resource = "api/album";
}
