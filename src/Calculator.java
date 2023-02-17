import MathHandlers.AdditionHandler;
import MathHandlers.MultiplicationHandler;
import MathHandlers.SubstractionHandler;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public class Calculator {
    String fileName;
    String operation;
    FileParser fileParser;
    AdditionHandler additionHandler;
    SubstractionHandler substractionHandler;
    MultiplicationHandler multiplicationHandler;
    OutputUI outputUI;

    public Calculator(String fileName, String operation) throws FileNotFoundException {
        this.fileName = fileName;
        this.operation = operation;
        this.fileParser = new FileParser(fileName);
        this.additionHandler = new AdditionHandler();
        this.substractionHandler = new SubstractionHandler();
        this.multiplicationHandler = new MultiplicationHandler();
        this.outputUI = new OutputUI();
    }

    public void calculate() throws IOException {
        int sum = 0;
        List<Integer> list = fileParser.readFile();
        outputUI.printStartingMessage(operation);
        //TODO On aurait pu faire des interfaces pour les operations et avoir juste une fonction(interface) au lieu des for dans chaque case
        switch (operation) {
            case "+":
                for(Integer integer : list) {
                    sum = additionHandler.doAddition(sum, integer);
                    outputUI.printStep(integer, operation, sum);
                }
                outputUI.printResult(sum, "addition");
                break;
            case "-":
                for(Integer integer : list) {
                    sum = substractionHandler.doSubstraction(sum, integer);
                    outputUI.printStep(integer, operation, sum);
                }
                outputUI.printResult(sum, "substraction");
                break;
            case "*":
                sum = 1;
                for(Integer integer : list) {
                    sum = multiplicationHandler.doMultiplication(sum, integer);
                    outputUI.printStep(integer, operation, sum);
                }
                outputUI.printResult(sum, "multiplication");
                break;
            default:
                System.out.println("Invalid operation");
        }
    }
}
