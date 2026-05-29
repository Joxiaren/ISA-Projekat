import { Component, Input, Signal, signal } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { BaseForm } from 'app/components/base-components/base-form/base-form';
import { Artist } from 'model/artist';
import { SongRequest } from 'model/song-request';

@Component({
  selector: 'app-song-form',
  imports: [ReactiveFormsModule],
  templateUrl: './song-form.html',
  styleUrl: './song-form.css',
})
export class SongForm extends BaseForm<SongRequest>{
  override form = new FormGroup({
    id: new FormControl(),
    name: new FormControl(),
    url: new FormControl(),
    artist: new FormControl(),
    songFile: new FormControl(null, {nonNullable: false})
  })

  @Input()
  artists: Signal<Artist[]> = signal([]);
}
