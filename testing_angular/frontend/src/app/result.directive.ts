import { Directive, ElementRef, Input, OnChanges, Renderer2, SimpleChanges } from '@angular/core';

@Directive({
  selector: '[appResult]',
  standalone: true
})
export class ResultDirective implements OnChanges {
  @Input({ required: true })
  result = ''

  constructor(private elementRef: ElementRef, private renderer: Renderer2) { }

  ngOnChanges(changes: SimpleChanges) {
    if (changes['result']) {
      const n = Number(this.result)

      const color = n > 0
        ? 'green'
        : n < 0
          ? 'red'
          : 'black'

      this.renderer.setStyle(this.elementRef.nativeElement, 'color', color)
    }
  }
}
