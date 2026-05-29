import { Injectable } from '@angular/core';
import { BaseService } from 'app/services/base-service';
import { Artist } from 'model/artist';

@Injectable({
  providedIn: 'root',
})
export class ArtistService extends BaseService<Artist>{
  override resource = "api/artist";  
}
