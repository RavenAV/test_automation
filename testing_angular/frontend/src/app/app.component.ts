import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { RouterOutlet } from '@angular/router';
import { NumberComponent } from './number/number.component';
import { ResultDirective } from './result.directive';
import { ResultPipe } from './result.pipe';
import { OperationType } from './models/OperationType';
import { CalcNumber } from './models/CalcNumber';
import { ClientService } from './client.service';
import { AddCalculationRequest } from './models/AddCalculationRequest';
import { NumeralSystem } from './models/NumeralSystem';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [CommonModule, RouterOutlet, NumberComponent, ResultDirective, ResultPipe],
  templateUrl: './app.component.html',
  styleUrl: './app.component.css'
})
export class AppComponent {
  readonly OperationType = OperationType

  a = new CalcNumber()
  b = new CalcNumber()
  operation?: OperationType
  result = ''

  constructor(private clientService: ClientService) { }

  handleChangeOperation(e: Event) {
    this.operation = Number((e.currentTarget as HTMLSelectElement).value)
  }

  async calculate() {
    if (this.operation === undefined) {
      alert('Выберите операцию.')
      return
    }
    if (/^-?$/.test(this.a.value)) this.a.value = '0'
    if (/^-?$/.test(this.b.value)) this.b.value = '0'
    if (this.operation === OperationType.DIVISION
      && /^-?0+$/.test(this.b.value)) {
      alert('Деление на ноль недопустимо.')
      return
    }

    let operationType: OperationType = OperationType.ADDITION;

    switch (this.operation) {
      case 0:
        operationType = OperationType.ADDITION
        break
      case 1:
        operationType = OperationType.SUBTRACTION
        break
      case 2:
        operationType = OperationType.MULTIPLICATION
        break
      case 3:
        operationType = OperationType.DIVISION
        break
    }

    const request: AddCalculationRequest = {
      firstNumber: this.a.value,
      firstBase: this.a.base,
      secondNumber: this.b.value,
      secondBase: this.b.base,
      operationType: operationType
    }

    try {
      console.log(request)
      this.result = await this.clientService.addCalculation(request)
    }
    catch (e) {
      alert(e)
    }
  }
}
