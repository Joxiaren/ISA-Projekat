import { Component, Directive, EventEmitter, Input, OnChanges, Output, signal, SimpleChanges } from "@angular/core";
import { FormGroup } from "@angular/forms";
import { BaseModel } from "model/base-model";

@Component({
  selector: 'app-base-form',
  imports: [],
  template: ""
})
export abstract class BaseForm<Type extends BaseModel> implements OnChanges {
  @Input()
  editItem: Type | null = null;

  @Output()
  editEmit = new EventEmitter<Type>();
  @Output()
  addEmit = new EventEmitter<Type>();
  @Output()
  submitEmit = new EventEmitter<boolean>();

  abstract form: FormGroup;
  itemFormValue: Type | null = null;

  mode = signal<string>("add");

  formToItem() {
    this.itemFormValue = this.form.value;
  }

  addEvent() {
    this.formToItem();

    if (this.itemFormValue == undefined) {
      this.submitEmit.emit(false);
      return;
    }
    if (this.mode() === "add") this.addEmit.emit(this.itemFormValue);
    else this.editEmit.emit(this.itemFormValue);

    this.submitEmit.emit(true);
  }

  compare(a: BaseModel, b: BaseModel): boolean {
    if (a == undefined || b == undefined) return false;
    return a.id === b.id;
  }
  
  ngOnChanges(changes: SimpleChanges): void {
    if (changes["editItem"] == undefined) return;
    if (changes["editItem"].currentValue != changes["editItem"].previousValue) {
      if (this.editItem == undefined) {
        this.form.reset();
        this.mode.set("add");
      } else {
        this.form.setValue(this.editItem);
        this.mode.set("edit");
      }
    }
  }
}
