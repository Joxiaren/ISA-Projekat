import { Routes } from '@angular/router';
import { LoginPage } from 'app/pages/login-page/login-page';
import { MainPage } from 'app/pages/main-page/main-page';
import { SearchResultsPage } from 'app/pages/search-results-page/search-results-page';
import { SongPlayerPage } from 'app/pages/song-player-page/song-player-page';

export const routes: Routes = [
    {
        path: "",
        component: MainPage
    },
    {
        path: "login",
        component: LoginPage
    },
    {
        path: "search",
        component: SearchResultsPage
    },
    {
        path: "play/:songId",
        component: SongPlayerPage
    }
];
