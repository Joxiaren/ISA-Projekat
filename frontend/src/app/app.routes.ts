import { Routes } from '@angular/router';
import { authoritiesGuard } from 'app/guards/authorities-guard';
import { AdminPage } from 'app/pages/admin-page/admin-page';
import { AlbumDetailViewPage } from 'app/pages/album/album-detail-view-page/album-detail-view-page';
import { AlbumFormPage } from 'app/pages/album/album-form-page/album-form-page';
import { AlbumPage } from 'app/pages/album/album-page/album-page';
import { ArtistDetailViewPage } from 'app/pages/artist/artist-detail-view-page/artist-detail-view-page';
import { ArtistFormPage } from 'app/pages/artist/artist-form-page/artist-form-page';
import { ArtistPage } from 'app/pages/artist/artist-page/artist-page';
import { LoginPage } from 'app/pages/login-page/login-page';
import { MainPage } from 'app/pages/main-page/main-page';
import { RegisterPage } from 'app/pages/register-page/register-page';
import { SearchResultsPage } from 'app/pages/search-results-page/search-results-page';
import { SongPlayerPage } from 'app/pages/song-player-page/song-player-page';
import { SongDetailViewPage } from 'app/pages/song/song-detail-view-page/song-detail-view-page';
import { SongFormPage } from 'app/pages/song/song-form-page/song-form-page';
import { SongPage } from 'app/pages/song/song-page/song-page';
import { TagDetailViewPage } from 'app/pages/tag/tag-detail-view-page/tag-detail-view-page';
import { TagFormPage } from 'app/pages/tag/tag-form-page/tag-form-page';
import { TagPage } from 'app/pages/tag/tag-page/tag-page';

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
        path: "register",
        component: RegisterPage
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
    },

    {
        path: "admin/artists",
        component: ArtistPage,
        canActivate: [authoritiesGuard],
        data: {authorities: ['ADMIN']}
    },
    {
        path: "admin/artists/add",
        component: ArtistFormPage,
        canActivate: [authoritiesGuard],
        data: {authorities: ['ADMIN']}
    },
    {
        path: "admin/artists/:id/edit",
        component: ArtistFormPage,
        canActivate: [authoritiesGuard],
        data: {authorities: ['ADMIN']}
    },
    {
        path: "admin/artists/:id",
        component: ArtistDetailViewPage,
        canActivate: [authoritiesGuard],
        data: {authorities: ['ADMIN']}
    },


    {
        path: "admin/albums",
        component: AlbumPage,
        canActivate: [authoritiesGuard],
        data: {authorities: ['ADMIN']}
    },
    {
        path: "admin/albums/add",
        component: AlbumFormPage,
        canActivate: [authoritiesGuard],
        data: {authorities: ['ADMIN']}
    },
    {
        path: "admin/albums/:id/edit",
        component: AlbumFormPage,
        canActivate: [authoritiesGuard],
        data: {authorities: ['ADMIN']}
    },
    {
        path: "admin/albums/:id",
        component: AlbumDetailViewPage,
        canActivate: [authoritiesGuard],
        data: {authorities: ['ADMIN']}
    },

        {
        path: "admin/tags",
        component: TagPage,
        canActivate: [authoritiesGuard],
        data: {authorities: ['ADMIN']}
    },
    {
        path: "admin/tags/add",
        component: TagFormPage,
        canActivate: [authoritiesGuard],
        data: {authorities: ['ADMIN']}
    },
    {
        path: "admin/tags/:id/edit",
        component: TagFormPage,
        canActivate: [authoritiesGuard],
        data: {authorities: ['ADMIN']}
    },
    {
        path: "admin/tags/:id",
        component: TagDetailViewPage,
        canActivate: [authoritiesGuard],
        data: {authorities: ['ADMIN']}
    }
];
