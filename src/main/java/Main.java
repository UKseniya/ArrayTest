import java.io.IOException;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws IOException {

        Random random = new Random();
        ArrayGenerator generator = new ArrayGenerator();
        int limit = 0;

        while (limit == 0) {
            limit = random.nextInt(20);
        }

        NumberHolder[] array = generator.generateArray(limit);

        System.out.println("The array consists of " + array.length + " number(s):");

        for (int i = 0; i < array.length; i++) {
            System.out.println(i+1 + ". " + array[i]);
        }

        PrintToFile printToFile = PrintToFile.getInstance();
        try {
            printToFile.print(array);
        } catch (ExceededFileSizeException e) {
            e.printStackTrace();
        }

        SaveToXML saveToXML = SaveToXML.getInstance();
        try {
            saveToXML.print(array);
        } catch (ExceededFileSizeException e) {
            e.printStackTrace();
        }
    }
}
