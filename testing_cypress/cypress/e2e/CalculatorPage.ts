export class CalculatorPage {
    static readonly url = 'http://localhost:4200/'

    static visit() {
        cy.visit(this.url)
    }

    static hasInputs(count: number) {
        cy.get(`input`).should('have.length', count)
    }

    static hasSelects(count: number) {
        cy.get(`select`).should('have.length', count)
    }

    static hasButtons(count: number) {
        cy.get(`button`).should('have.length', count)
    }

    static setNumber1(base: string, value: string) {
        if (base !== '') {
            cy.get(`select`).first().select(base)
        }
        cy.get(`input`).first().type(value)
    }

    static setOperation(value: string) {
        cy.get(`main > label > select`).select(value)
    }

    static setNumber2(base: string, value: string) {
        if (base !== '') {
            cy.get(`select`).last().select(base)
        }
        cy.get(`input`).last().type(value)
    }

    static calculate() {
        cy.get(`button`).click()
    }

    static hasResult(value: string) {
        cy.get('output').should('have.value', value)
    }

    static hasNumber1(value: string) {
        cy.get(`input`).first().should('have.value', value)
    }

    static hasNumber2(value: string) {
        cy.get(`input`).last().should('have.value', value)
    }

    static hasResultColor(value: string) {
        cy.get('output').should('have.css', 'color', value)
    }
}

