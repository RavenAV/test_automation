import { AppComponent } from './app.component';
import { ClientService } from './client.service';
import { CalcNumber } from './models/CalcNumber';

describe('AppComponent', () => {
  let app: AppComponent

  beforeEach(() => {
    const client = new ClientService()
    app = new AppComponent(client)
  })

  it(`a toBeInstanceOf CalcNumber`, () => {
    expect(app.a).toBeInstanceOf(CalcNumber)
  })

  it(`b toBeInstanceOf CalcNumber`, () => {
    expect(app.b).toBeInstanceOf(CalcNumber)
  })
});
