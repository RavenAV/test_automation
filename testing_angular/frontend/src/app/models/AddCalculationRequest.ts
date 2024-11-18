import { NumeralSystem } from "./NumeralSystem"
import { OperationType } from "./OperationType"

export interface AddCalculationRequest {
    firstNumber: string
    firstBase: NumeralSystem
    secondNumber: string
    secondBase: NumeralSystem
    operationType: OperationType
  }