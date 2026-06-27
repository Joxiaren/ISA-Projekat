import { Component, Input, Signal, signal } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { BaseForm } from 'app/components/base-components/base-form/base-form';
import { Album } from 'model/album';
import { Artist } from 'model/artist';

@Component({
  selector: 'app-album-form',
  imports: [ReactiveFormsModule],
  templateUrl: './album-form.html',
  styleUrl: './album-form.css',
})
export class AlbumForm extends BaseForm<Album>{
  override form = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    artist: new FormControl(),
    songs: new FormControl(),
    tags: new FormControl(),
    likes: new FormControl(),
    comments: new FormControl()
  })

  @Input()
  artists: Signal<Artist[]> = signal([]);
}
