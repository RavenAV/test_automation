public class CalculatorFactory {
    public static ICalculator getCalculator(String system) {
        switch (system.toLowerCase()) {
            case "binary":
                return new BinaryCalculator();
            case "octal":
                return new OctalCalculator();
            case "decimal":
                return new DecimalCalculator();
            case "hex":
                return new HexCalculator();
            default:
                throw new IllegalArgumentException("Unknown number system: " + system);
        }
    }
}
