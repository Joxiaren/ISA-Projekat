import { inject, Injectable } from '@angular/core';
import { BaseControl } from 'app/controls/base-control';
import { ArtistService } from 'app/services/artist-service';
import { Artist } from 'model/artist';

@Injectable({
  providedIn: 'root',
})
export class ArtistControl extends BaseControl<Artist>{
  override service: ArtistService = inject(ArtistService);
  override controlName: string = "Artist";
}
