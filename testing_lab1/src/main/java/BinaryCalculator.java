public class BinaryCalculator implements ICalculator {
    @Override
    public String add(String num1, String num2) {
        int result = Integer.parseInt(num1, 2) + Integer.parseInt(num2, 2);
        return Integer.toBinaryString(result);
    }

    @Override
    public String subtract(String num1, String num2) {
        int result = Integer.parseInt(num1, 2) - Integer.parseInt(num2, 2);
        return Integer.toBinaryString(result);
    }

    @Override
    public String multiply(String num1, String num2) {
        int result = Integer.parseInt(num1, 2) * Integer.parseInt(num2, 2);
        return Integer.toBinaryString(result);
    }

    @Override
    public String divide(String num1, String num2) {
        int result = Integer.parseInt(num1, 2) / Integer.parseInt(num2, 2);
        return Integer.toBinaryString(result);
    }
}
