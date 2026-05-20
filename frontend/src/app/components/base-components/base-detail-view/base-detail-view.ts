import { Component, Input } from "@angular/core";
import { BaseModel } from "model/base-model";

@Component({
    selector: 'app-base-detail-view',
    imports: [],
    template: ""
})
export abstract class BaseDetailView<Type extends BaseModel>{
    @Input()
    itemShow: Type | null = null;
}