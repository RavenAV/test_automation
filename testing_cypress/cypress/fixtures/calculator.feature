Feature: calculator

    Scenario: Проверить, что у нас на странице существуют инпуты, дропдаун и кнопка для получения результата.
        When I visit calculator page
        Then I should see 2 inputs
        And I should see 3 selects
        And I should see 1 buttons

    Scenario: Проверить, что корректно работают все арифметические действия (сложение).
        When I visit calculator page
        And I set number 1 base to 'DECIMAL' and value to '5'
        And I set 'ADDITION' operation 
        And I set number 2 base to 'DECIMAL' and value to '3'
        And I calculate result
        Then I should have result of '8'

    Scenario: Проверить, что корректно работают все арифметические действия (вычитание).
        When I visit calculator page
        And I set number 1 base to 'DECIMAL' and value to '0'
        And I set 'SUBTRACTION' operation
        And I set number 2 base to 'DECIMAL' and value to '3'
        And I calculate result
        Then I should have result of '-3'

    Scenario: Проверить, что корректно работают все арифметические действия (умножение).
        When I visit calculator page
        And I set number 1 base to 'DECIMAL' and value to '5'
        And I set 'MULTIPLICATION' operation
        And I set number 2 base to 'DECIMAL' and value to '3'
        And I calculate result
        Then I should have result of '15'

    Scenario: Проверить, что корректно работают все арифметические действия (деление).
        When I visit calculator page
        And I set number 1 base to 'DECIMAL' and value to '15'
        And I set 'DIVISION' operation
        And I set number 2 base to 'DECIMAL' and value to '3'
        And I calculate result
        Then I should have result of '5'

    Scenario: Проверить, что в поля ввода можно ввести только цифры.
        When I visit calculator page
        And I set number 1 base to 'DECIMAL' and value to 'e2e-.,'
        And I set number 2 base to 'OCTAL' and value to '.,e3e-'
        Then I should have number 1 of '2'
        And I should have number 2 of '3'

    Scenario: Проверить, что при выборе деления во второй инпут нельзя ввести 0.
        When I visit calculator page
        And I set 'DIVISION' operation
        And I set number 2 base to 'DECIMAL' and value to '0'
        Then I should have number 2 of ''

    Scenario: Проверить, что при выборе шестнадцатеричной системы счисления в инпуты можно вводить соответствующие буквы.
        When I visit calculator page
        And I set number 1 base to 'HEXADECIMAL' and value to '09abcdefg'
        And I set number 2 base to 'HEXADECIMAL' and value to 'abcdefg09'
        Then I should have number 1 of '09abcdef'
        And I should have number 2 of 'abcdef09'

    Scenario: Проверить, цвета результата в зависимости от знака (меньше 0).
        When I visit calculator page
        And I set 'SUBTRACTION' operation
        And I set number 2 base to 'DECIMAL' and value to '3'
        And I calculate result
        Then I should have result color of 'rgb(255, 0, 0)'

    Scenario: Проверить, цвета результата в зависимости от знака (0).
        When I visit calculator page
        And I set number 1 base to 'DECIMAL' and value to '0'
        And I set 'ADDITION' operation
        And I set number 2 base to 'DECIMAL' and value to '0'
        And I calculate result
        Then I should have result color of 'rgb(0, 0, 0)'

    Scenario: Проверить, цвета результата в зависимости от знака (больше 0).
        When I visit calculator page
        And I set number 1 base to 'DECIMAL' and value to '1'
        And I set 'ADDITION' operation
        And I set number 2 base to 'DECIMAL' and value to '3'
        And I calculate result
        Then I should have result color of 'rgb(0, 128, 0)'
