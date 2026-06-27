import { Directive, inject, output, signal, WritableSignal } from "@angular/core";
import { BaseService } from "app/services/base-service";
import { BaseModel } from "model/base-model";

@Directive()
export abstract class BaseControl<Type extends BaseModel> {
  abstract service: BaseService<Type>;

  abstract controlName: string;

  items = signal<Type[]>([]);

  itemEdit = signal<Type | null>(null);

  itemEditEmit = output<number>();

  getAllItems() {
    this.service?.getAll().subscribe((data) => {
      this.items.set(data);
    });
  }
  getItem(index: number, s: WritableSignal<Type | null>){
    this.service?.get(index).subscribe((data) => {
      s.set(data);
    })  
  }
  addItem(item: Type) {
    this.service?.create(item).then(res => res.subscribe(() => {
      this.getAllItems();
    }));
  }
  setEditItem(id: number){
    let item = this.items().filter(i => i.id == id)[0];
    console.log("hello");
    this.itemEdit.set(item);
    this.itemEditEmit.emit(item.id);
  }
  editItem(item: Type) {
    this.service?.update(item.id, item).then(res => res.subscribe(() => {
      this.getAllItems();
    }));
    this.itemEdit.set(null);
  }
  patchItem(id: number, item: any){
    this.service?.updatePatch(id, item).subscribe(() => {
      this.getAllItems();
    });
  }
  deleteItem(id: number) {
    this.service?.delete(id).subscribe(() => {
      this.getAllItems();
    });
    this.itemEdit.set(null);
  }

  dataRefresh(){
    this.getAllItems();
  }
}
