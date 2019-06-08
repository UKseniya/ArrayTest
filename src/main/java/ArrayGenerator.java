import java.util.Random;

public class ArrayGenerator {

    Random random = new Random();

    public NumberHolder[] generateArray (int limit) {

        NumberHolder[] arr = new NumberHolder[limit];

        for (int i = 0; i < limit; i++) {
            int randomNumber = random.nextInt(100);
            NumberHolder number = new NumberHolder(randomNumber * randomNumber);
            arr[i] = number;
        }

        return arr;
    }
}
