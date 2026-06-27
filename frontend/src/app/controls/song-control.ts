import { computed, inject, Injectable, signal, WritableSignal } from '@angular/core';
import { ArtistControl } from 'app/controls/artist-control';
import { BaseControl } from 'app/controls/base-control';
import { SongService } from 'app/services/song-service';
import { Song } from 'model/song';
import { SongRequest } from 'model/song-request';

@Injectable({
  providedIn: 'root',
})
export class SongControl extends BaseControl<Song>{
  override service: SongService = inject(SongService);
  override controlName: string = "Song";

  override itemEdit = signal<SongRequest | null>(null);

  artistControl = inject(ArtistControl);

  artistItems = computed(() => this.artistControl.items());

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
  getRequestItem(index: number, s: WritableSignal<SongRequest | null>): void{
    this.service?.get(index).subscribe((data) => {
      data.url = this.service.path + data.url;

      s.set({...data, "songFile": null});
    })
  }

  override setEditItem(id: number): void {
    let item = this.items().filter(i => i.id == id)[0];
    let songRequest : SongRequest = {...item, "songFile": null};
    
    this.itemEdit.set(songRequest);
    this.itemEditEmit.emit(item.id);
  }

  search(searchString: string, s: WritableSignal<Song[]>): void{
    this.service?.search(searchString).subscribe((data) => {
      data.forEach(d => d.url = this.service.path + d.url);
      s.set(data);
    });
  }

  override dataRefresh(){
    this.getAllItems();
    this.artistControl.getAllItems();
  }
}
