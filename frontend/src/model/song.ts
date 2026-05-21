import { Artist } from "model/artist";
import { BaseModel } from "model/base-model";

export interface Song extends BaseModel{
    "name": string,
    "url": string
    "artist": Artist
}