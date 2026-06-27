import { Artist } from "model/artist";
import { BaseModel } from "model/base-model";
import { Comment } from "model/comment";
import { Like } from "model/like";
import { Song } from "model/song";
import { Tag } from "model/tag";

export interface Album extends BaseModel{
    "name": string,
    "artist": Artist,
    "songs": Song[],
    "tags": Tag[],
    "likes": Like[],
    "comments": Comment[]
}