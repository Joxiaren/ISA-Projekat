import { Component } from '@angular/core';
import { FormGroup, FormControl, ReactiveFormsModule } from '@angular/forms';
import { BaseForm } from 'app/components/base-components/base-form/base-form';
import { Artist } from 'model/artist';

@Component({
  selector: 'app-artist-form',
  imports: [ReactiveFormsModule],
  templateUrl: './artist-form.html',
  styleUrl: './artist-form.css',
})
export class ArtistForm extends BaseForm<Artist>{
  override form = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    songs: new FormControl(),
    albums: new FormControl()
  })
}
