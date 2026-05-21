import { Injectable } from '@angular/core';
import { BaseService } from 'app/services/base-service';
import { Song } from 'model/song';

@Injectable({
  providedIn: 'root',
})
export class SongService extends BaseService<Song>{
  override resource = "api/song";
  
}
