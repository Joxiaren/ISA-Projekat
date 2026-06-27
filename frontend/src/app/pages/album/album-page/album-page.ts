import { Component, inject } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { AlbumTable } from 'app/components/album/album-table/album-table';
import { AlbumControl } from 'app/controls/album-control';

@Component({
  selector: 'app-album-page',
  imports: [AlbumTable],
  templateUrl: './album-page.html',
  styleUrl: './album-page.css',
})
export class AlbumPage {
  router = inject(Router);
  activatedRoute = inject(ActivatedRoute);

  albumControl = inject(AlbumControl);

  constructor(){
    this.dataRefresh();
    this.albumControl.itemEditEmit.subscribe(e => {
      this.router.navigate([`${e}/edit`], {relativeTo: this.activatedRoute});
    });
  }

  dataRefresh(){
    this.albumControl.dataRefresh();
  }
  add(){
    this.router.navigate(['add'], {relativeTo: this.activatedRoute});
  }
}
