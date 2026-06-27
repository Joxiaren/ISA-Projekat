import { Component, Input, Signal, signal } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { BaseForm } from 'app/components/base-components/base-form/base-form';
import { Album } from 'model/album';
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
    album: new FormControl(),
    likes: new FormControl(),
    songFile: new FormControl()
  })

  @Input()
  artists: Signal<Artist[]> = signal([]);
  @Input()
  albums: Signal<Album[]> = signal([]);

  override formToItem(): void {
    super.formToItem();

    let fileInput = document.querySelector('input[name="songFile"]');
    if(fileInput === null || fileInput == undefined) return;
    if((fileInput as HTMLInputElement).files === null) return;
    
    this.itemFormValue!.songFile = (fileInput as HTMLInputElement).files![0];
  }
}
