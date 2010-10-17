package domain;

public class FuelStock {
    private Double value = 0D;

    public FuelStock(Double value) {
        this.value = value;
    }
    public void increment(Double value) {
        this.value += value;
    }

    public void decrement(Double value) {
        this.value -= value;
    }

    public Double getValue() {
        return value;
    }

    public String toString() {
        return value.toString();
    }

}
