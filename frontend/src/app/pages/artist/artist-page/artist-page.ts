import { Component, inject } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { ArtistTable } from 'app/components/artist/artist-table/artist-table';
import { ArtistControl } from 'app/controls/artist-control';

@Component({
  selector: 'app-artist-page',
  imports: [ArtistTable],
  templateUrl: './artist-page.html',
  styleUrl: './artist-page.css',
})
export class ArtistPage {
  router = inject(Router);
  activatedRoute = inject(ActivatedRoute);

  artistControl = inject(ArtistControl);

  constructor(){
    this.dataRefresh();
    this.artistControl.itemEditEmit.subscribe(e => {
      this.router.navigate([`${e}/edit`], {relativeTo: this.activatedRoute});
    });
  }

  dataRefresh(){
    this.artistControl.dataRefresh();
  }
  add(){
    this.router.navigate(['add'], {relativeTo: this.activatedRoute});
  }
}
