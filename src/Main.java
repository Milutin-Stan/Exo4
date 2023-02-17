import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Calculator calculator = new Calculator(args[0], args[1]);
        calculator.calculate();
    }
}