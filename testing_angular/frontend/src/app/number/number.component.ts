import { Component, Input } from '@angular/core';
import { NumeralSystem } from '../models/NumeralSystem';
import { CalcNumber } from '../models/CalcNumber';

function isInteger(input: HTMLInputElement, insertion: string, base: NumeralSystem, banZero: boolean) {
  function getRegExp() {
    let pattern = '^-?'

    if (banZero) {
      pattern += '(?!0+$)'
    }

    switch (base) {
      case NumeralSystem.BINARY:
        pattern += '[01]'
        break
      case NumeralSystem.OCTAL:
        pattern += '[0-7]'
        break
      case NumeralSystem.DECIMAL:
        pattern += '\\d'
        break
      case NumeralSystem.HEXADECIMAL:
        pattern += '[\\dA-F]'
        break
    }

    pattern += '*$'

    return new RegExp(pattern, 'i')
  }


  const s = input.value

  const sBeforeSelection = s.substring(0, input.selectionStart!)
  const sAfterSelection = s.substring(input.selectionEnd!, s.length)

  const newS = `${sBeforeSelection}${insertion}${sAfterSelection}`

  return getRegExp().test(newS)
}

@Component({
  selector: 'app-number',
  standalone: true,
  imports: [],
  templateUrl: './number.component.html',
  styleUrl: './number.component.css'
})
export class NumberComponent {
  readonly NumeralSystem = NumeralSystem

  @Input()
  legend = '';

  @Input({ required: true })
  calcNumber!: CalcNumber

  @Input()
  banZero = false

  handleChangeBase(e: Event) {
    this.calcNumber.base = (e.currentTarget as HTMLSelectElement).value as NumeralSystem
  }

  handleChangeValue(e: Event) {
    this.calcNumber.value = (e.currentTarget as HTMLInputElement).value
  }

  handleKeyDown(e: KeyboardEvent) {
    if (e.key.length !== 1
      || e.ctrlKey) {
      return
    }

    if (!isInteger(e.currentTarget as HTMLInputElement, e.key, this.calcNumber.base, this.banZero)
      || e.altKey
      || e.metaKey) {
      e.preventDefault()
    }
  }

  handlePasteOrDrop(e: ClipboardEvent | DragEvent, dataTransfer: DataTransfer) {
    const data = dataTransfer.getData('text/plain')

    if (!isInteger(e.currentTarget as HTMLInputElement, data, this.calcNumber.base, this.banZero)) {
      e.preventDefault()
    }
  }
}
