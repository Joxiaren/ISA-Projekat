import { Song } from "model/song";

export interface SongRequest extends Song{
    "songFile": File | null
}