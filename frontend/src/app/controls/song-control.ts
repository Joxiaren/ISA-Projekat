import { inject, Injectable, WritableSignal } from '@angular/core';
import { BaseControl } from 'app/controls/base-control';
import { SongService } from 'app/services/song-service';
import { Song } from 'model/song';

@Injectable({
  providedIn: 'root',
})
export class SongControl extends BaseControl<Song>{
  override service: SongService = inject(SongService);
  override controlName: string = "Song";

  override getAllItems(): void {
    this.service?.getAll().subscribe((data) => {
      data.forEach(d => d.url = this.service.path + d.url);
      this.items.set(data);
    });
  }
  override getItem(index: number, s: WritableSignal<Song | null>): void {
    this.service?.get(index).subscribe((data) => {
      data.url = this.service.path + data.url;
      s.set(data);
    }); 
  }

  search(searchString: string, s: WritableSignal<Song[]>): void{
    this.service?.search(searchString).subscribe((data) => {
      data.forEach(d => d.url = this.service.path + d.url);
      s.set(data);
    });
  }
}
