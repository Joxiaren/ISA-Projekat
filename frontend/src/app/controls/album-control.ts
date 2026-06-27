import { computed, inject, Injectable } from '@angular/core';
import { ArtistControl } from 'app/controls/artist-control';
import { BaseControl } from 'app/controls/base-control';
import { AlbumService } from 'app/services/album-service';
import { Album } from 'model/album';

@Injectable({
  providedIn: 'root',
})
export class AlbumControl extends BaseControl<Album>{
  override service: AlbumService = inject(AlbumService);
  override controlName: string = "Album";

  artistControl = inject(ArtistControl);

  artistItems = computed(() => this.artistControl.items());

  override dataRefresh(){
    this.getAllItems();
    this.artistControl.dataRefresh();
  }
}
