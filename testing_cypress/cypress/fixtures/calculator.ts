import { When, Then } from "@badeball/cypress-cucumber-preprocessor"
import { CalculatorPage } from "../e2e/CalculatorPage"

When("I visit calculator page", () => {
    CalculatorPage.visit()
})

Then("I should see {int} inputs", (count: number) => {
    CalculatorPage.hasInputs(count)
})

Then("I should see {int} selects", (count: number) => {
    CalculatorPage.hasSelects(count)
})

Then("I should see {int} buttons", (count: number) => {
    CalculatorPage.hasButtons(count)
})

When("I set number 1 base to {string} and value to {string}", (base: string, value: string) => {
    CalculatorPage.setNumber1(base, value)
})

When("I set {string} operation", (value: string) => {
    CalculatorPage.setOperation(value)
})

When("I set number 2 base to {string} and value to {string}", (base: string, value: string) => {
    CalculatorPage.setNumber2(base, value)
})

When("I calculate result", () => {
    CalculatorPage.calculate()
})

When("I should have result of {string}", (value: string) => {
    CalculatorPage.hasResult(value)
})

When("I should have number 1 of {string}", (value: string) => {
    CalculatorPage.hasNumber1(value)
})

When("I should have number 2 of {string}", (value: string) => {
    CalculatorPage.hasNumber2(value)
})

When("I should have result color of {string}", (value: string) => {
    CalculatorPage.hasResultColor(value)
})
