import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class OutputUI {

    private static final DateTimeFormatter PREFIX_FORMAT = DateTimeFormatter.ofPattern("HHmmss:SSSSSS");

    public void printStep(int a, String operator, int result) {
        System.out.println(operator + a + " (=" + result + ")");
    }
    public void printResult(int result, String operation) {
        System.out.println("total = "+ result +" (" + operation + ")");
    }

    public void printStartingMessage(String operation) {
        System.out.println(printLogPrefix() + "Starting");
        System.out.println(printLogPrefix() + "applying operation " + operation);
    }

    private String printLogPrefix() {
        LocalTime now = LocalTime.now();
        String formattedTime = now.format(PREFIX_FORMAT);
        return ("["+formattedTime+"]"+"[log] ");
    }


}
