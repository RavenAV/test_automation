import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'result',
  standalone: true
})
export class ResultPipe implements PipeTransform {

  transform(value: string, decimalPlaces: number) {
    return value === '' ? undefined : Number(Number(value).toFixed(decimalPlaces))
  }
}
