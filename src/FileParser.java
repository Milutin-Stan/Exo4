import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileParser {

    BufferedReader bufferedReader;
    String fileName;
    public FileParser(String fileName) throws FileNotFoundException {
        this.fileName = fileName;
        this.bufferedReader = new BufferedReader(new FileReader(fileName));
    }

    public List<Integer> readFile() throws IOException {
        String number;
        List<Integer> numbers = new ArrayList<Integer>();
        while ((number = bufferedReader.readLine()) != null){
            numbers.add(Integer.parseInt(number));
        }
        return numbers;
    }
}
