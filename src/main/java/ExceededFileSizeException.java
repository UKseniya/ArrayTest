public class ExceededFileSizeException extends Exception { // наследование

    public ExceededFileSizeException() {
    }

    public ExceededFileSizeException(String message) {
        super(message);
    }
}
