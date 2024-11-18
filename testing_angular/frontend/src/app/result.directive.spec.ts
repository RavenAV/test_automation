import { ComponentFixture, TestBed } from '@angular/core/testing';
import { AppComponent } from './app.component';
import { ResultDirective } from './result.directive';
import { By } from '@angular/platform-browser';

describe('ResultDirective', () => {
  let fixture: ComponentFixture<AppComponent>
  let app: AppComponent
  let resultElement: HTMLOutputElement

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ResultDirective, AppComponent]
    }).compileComponents()

    fixture = TestBed.createComponent(AppComponent)
    app = fixture.componentInstance
    resultElement = fixture.debugElement.queryAll(By.directive(ResultDirective))[0].nativeElement
  })

  it('result < 0', () => {
    app.result = '-1'
    fixture.detectChanges()

    expect(resultElement.style.color).toBe('red')
  })

  it('result === 0', () => {
    app.result = '0'
    fixture.detectChanges()

    expect(resultElement.style.color).toBe('black')
  })

  it('result > 0', () => {
    app.result = '1'
    fixture.detectChanges()

    expect(resultElement.style.color).toBe('green')
  })
});
