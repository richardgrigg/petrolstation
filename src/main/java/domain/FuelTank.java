package domain;

public class FuelTank {
    private final Double maximumCapacity;
    private Double currentCapacity = 0D;

    public FuelTank(Double currentCapacity, Double maximumCapacity) {
        this.currentCapacity = currentCapacity;
        this.maximumCapacity = maximumCapacity;
    }

    public Double increment(Double value) {
        if((this.currentCapacity + value) >= getMaximumCapacity()) {
            Double fuelAdded = getMaximumCapacity() - this.currentCapacity;
            this.currentCapacity = getMaximumCapacity();
            return fuelAdded;
        }
        this.currentCapacity += value;
        return value;
    }

    public Double decrement(Double value) {
        if(this.currentCapacity - value < 0) {
            Double fuelUsed = this.currentCapacity;
            this.currentCapacity = 0D;
            return fuelUsed ;
        }
        this.currentCapacity -= value;
        return value;
    }

    public Double getCurrentCapacity() {
        return currentCapacity;
    }

    public Double getMaximumCapacity() {
        return maximumCapacity;
    }

    public String toString() {
        return "Current Capacity: " + this.currentCapacity.toString();
    }
}
