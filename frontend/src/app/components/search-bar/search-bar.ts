import { Component, inject, signal, WritableSignal } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-search-bar',
  imports: [FormsModule],
  templateUrl: './search-bar.html',
  styleUrl: './search-bar.css',
})
export class SearchBar {
  router = inject(Router);

  searchString: WritableSignal<string> = signal("");

  inputEnter(event: KeyboardEvent){
    if(event.key === 'Enter') this.search();
  }
  search(){
    if(this.searchString() == null || this.searchString() == "") return;
    this.router.navigate(['search'], {queryParams: {s: this.searchString()}});
  }
}
