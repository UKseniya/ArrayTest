public class NumberHolder {

    private int number; // инкапсуляция
    private boolean even; // инкапсуляция

    public NumberHolder(int number) {
        this.number = number;
        even = (this.number%2 == 0);

    }

    public int getNumber() {
        return number;
    }

    public boolean isEven() {
        return even;
    }

    @Override
    public String toString() {
        return "NumberHolder{" +
                "number=" + number +
                ", even=" + even +
                '}';
    }
}
