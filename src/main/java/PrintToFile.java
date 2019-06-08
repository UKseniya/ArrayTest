import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class PrintToFile extends Output { // наследование

    private static final int MAX_FILE_SIZE = 1024 * 1024 * 40; // 40mb

    private static PrintToFile instance;

    private PrintToFile() { // инкапсуляция
    }

    public static PrintToFile getInstance() {
        if (instance == null) {
            instance = new PrintToFile();
        }
        return instance;
    }

    @Override
    public void print(NumberHolder[] num) throws ExceededFileSizeException {

        File file = new File("C:\\Users\\Kseniya\\temp.doc");

        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            String s = "The array consists of " + num.length + " number(s):";

            printWriter.println(s);

            for (int i = 0; i < num.length; i++) {
                printWriter.println(i + 1 + ". " + num[i]);
            }
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        if (file.length() > MAX_FILE_SIZE) {
            throw new ExceededFileSizeException("The file size exceeds the limit");
        }
    }
}
