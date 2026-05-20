import { Directive, inject, input, OnChanges, SimpleChanges, TemplateRef, ViewContainerRef } from '@angular/core';

@Directive({
  selector: '[appSortableHeader]',
})
export class SortableHeader implements OnChanges{  
  appSortableHeaderFrom = input.required<boolean | null>();
  
  private templateRef = inject(TemplateRef);
  private viewContainerRef = inject(ViewContainerRef);
  
  ngOnChanges(changes: SimpleChanges): void {
    let arrow = "⇅";

    if(this.appSortableHeaderFrom() === true) arrow = "↑"
    else if(this.appSortableHeaderFrom() === false) arrow = "↓";
    
    this.viewContainerRef.clear();
    this.viewContainerRef.createEmbeddedView(this.templateRef, {
        $implicit : arrow
    });
  }
}
