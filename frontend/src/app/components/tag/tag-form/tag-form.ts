import { Component } from '@angular/core';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';
import { BaseForm } from 'app/components/base-components/base-form/base-form';
import { Tag } from 'model/tag';

@Component({
  selector: 'app-tag-form',
  imports: [ReactiveFormsModule],
  templateUrl: './tag-form.html',
  styleUrl: './tag-form.css',
})
export class TagForm extends BaseForm<Tag>{
  override form = new FormGroup({
    id: new FormControl(),
    name: new FormControl()
  })

}
