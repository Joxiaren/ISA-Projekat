import { BaseModel } from "model/base-model";

export interface Comment extends BaseModel{
    "content": string,
    "posted": Date,
    "commenter": number
}