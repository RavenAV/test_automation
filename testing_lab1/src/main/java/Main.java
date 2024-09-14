import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите систему счисления: binary, octal, decimal, hex");
        String system = scanner.nextLine();

        ICalculator calculator = CalculatorFactory.getCalculator(system);

        System.out.println("Введите первое число:");
        String num1 = scanner.nextLine();

        System.out.println("Введите второе число:");
        String num2 = scanner.nextLine();

        System.out.println("Выберите операцию: +, -, *, /");
        String operation = scanner.nextLine();

        String result = "";
        switch (operation) {
            case "+":
                result = calculator.add(num1, num2);
                break;
            case "-":
                result = calculator.subtract(num1, num2);
                break;
            case "*":
                result = calculator.multiply(num1, num2);
                break;
            case "/":
                result = calculator.divide(num1, num2);
                break;
            default:
                System.out.println("Неизвестная операция");
                return;
        }

        System.out.println("Результат: " + result);
    }
}
