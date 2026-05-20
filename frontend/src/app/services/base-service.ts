import { HttpClient } from "@angular/common/http";
import { inject } from "@angular/core";
import { BaseModel } from "model/base-model";

export abstract class BaseService<Type extends BaseModel> {
  http = inject(HttpClient);
  path = "http://localhost:8080/";
  abstract resource: string;

  getAll() {
    return this.http.get<Type[]>(`${this.path}${this.resource}`);
  }
  get(id: number) {
    return this.http.get<Type>(`${this.path}${this.resource}/${id}`)
  }
  create(item: Type) {
    return this.http.post<Type>(`${this.path}${this.resource}`, item);
  }
  update(id: number, item: Type) {
    return this.http.put<Type>(`${this.path}${this.resource}/${id}`, item);
  }
  updatePatch(id: number, item: any){
    return this.http.patch<Type>(`${this.path}${this.resource}/${id}`, item);
  }
  delete(id: number) {
    return this.http.delete<Type>(`${this.path}${this.resource}/${id}`);
  }
}
