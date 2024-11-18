import { ComponentFixture, TestBed } from '@angular/core/testing';

import { NumberComponent } from './number.component';
import { NumeralSystem } from '../models/NumeralSystem';

describe('NumberComponent', () => {
  let component: NumberComponent;
  let fixture: ComponentFixture<NumberComponent>;
  let compiled: HTMLElement;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [NumberComponent]
    })
      .compileComponents();

    fixture = TestBed.createComponent(NumberComponent);
    fixture.detectChanges();

    component = fixture.componentInstance
    compiled = fixture.debugElement.nativeElement
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('Система счисления "DECIMAL"', () => {
    const value = (compiled.querySelector('label select') as HTMLSelectElement).value
    expect(value).toBe(NumeralSystem.DECIMAL.toString())
  })
});
