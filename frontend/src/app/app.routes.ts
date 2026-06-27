import { Routes } from '@angular/router';
import { authoritiesGuard } from 'app/guards/authorities-guard';
import { AdminPage } from 'app/pages/admin-page/admin-page';
import { LoginPage } from 'app/pages/login-page/login-page';
import { MainPage } from 'app/pages/main-page/main-page';
import { SearchResultsPage } from 'app/pages/search-results-page/search-results-page';
import { SongPlayerPage } from 'app/pages/song-player-page/song-player-page';
import { SongDetailViewPage } from 'app/pages/song/song-detail-view-page/song-detail-view-page';
import { SongFormPage } from 'app/pages/song/song-form-page/song-form-page';
import { SongPage } from 'app/pages/song/song-page/song-page';

export const routes: Routes = [
    //public routes
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
    },

    //protected routes

    {
        path: "admin",
        component: AdminPage,
        canActivate: [authoritiesGuard],
        data: {authorities: ['ADMIN']}
    },

    {
        path: "admin/songs",
        component: SongPage,
        canActivate: [authoritiesGuard],
        data: {authorities: ['ADMIN']}
    },
    {
        path: "admin/songs/add",
        component: SongFormPage,
        canActivate: [authoritiesGuard],
        data: {authorities: ['ADMIN']}
    },
    {
        path: "admin/songs/:id/edit",
        component: SongFormPage,
        canActivate: [authoritiesGuard],
        data: {authorities: ['ADMIN']}
    },
    {
        path: "admin/songs/:id",
        component: SongDetailViewPage,
        canActivate: [authoritiesGuard],
        data: {authorities: ['ADMIN']}
    }
];
