import { Injectable, Type } from '@angular/core';
import { BaseService } from 'app/services/base-service';
import { Song } from 'model/song';
import { SongRequest } from 'model/song-request';

@Injectable({
  providedIn: 'root',
})
export class SongService extends BaseService<Song>{
  override resource = "api/song";
  
  override async create(item: SongRequest){
    let formData = new FormData();

    let data = {"name": item.name, "artist": item.artist, "url": ""};

    if(item.songFile != null){
      let something = await item.songFile.bytes();
      formData.append("songFile", new Blob([something]));
    }
    formData.append("item", new Blob([JSON.stringify(data)], { type: 'application/json'}));

    return this.http.post<Song>(`${this.path}${this.resource}/add`, formData);
  }

  override async update(id: number, item: SongRequest){
    let formData = new FormData();
    let data = {"name": item.name, "artist": item.artist, "url": item.url};

    if(item.songFile != null){
      let fileBytes = await item.songFile.bytes();
      formData.append("songFile", new Blob([fileBytes]));
    }

    formData.append("item", new Blob([JSON.stringify(data)], { type: 'application/json'}));

    return this.http.put<Song>(`${this.path}${this.resource}/${id}/put`, formData);
  }

  search(searchString: string){
    return this.http.get<Song[]>(`${this.path}${this.resource}/search?s=${searchString}`);
  }
}
