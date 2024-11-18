import { Injectable } from '@angular/core';
import { AddCalculationRequest } from './models/AddCalculationRequest';

@Injectable({
  providedIn: 'root'
})
export class ClientService {
  readonly baseUrl = 'http://localhost:8080'

  async addCalculation(request: AddCalculationRequest) {
    const response = await fetch(`${this.baseUrl}/calculation/compute`, {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json'
      },
      body: JSON.stringify(request)
    })

    if (!response.ok) {
      throw response.status
    }

    return await response.text()
  }
}
