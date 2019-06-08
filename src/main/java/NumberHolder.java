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

    public void setNumber(int number) {
        this.number = number;
    }

    public boolean isEven() {
        return even;
    }

    public void setEven(boolean even) {
        this.even = even;
    }

    @Override
    public String toString() {
        return "NumberHolder{" +
                "number=" + number +
                ", even=" + even +
                '}';
    }
}
