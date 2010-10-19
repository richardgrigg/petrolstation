package domain;

public class FuelTank {
    private final Double maximumCapacity;
    private Double currentCapacity = 0D;


    public Double increment(Double value) {
        if((this.getCurrentCapacity() + value) >= this.getMaximumCapacity()) {
            Double fuelAdded = maximumCapacity - currentCapacity;
            currentCapacity = maximumCapacity;
            return fuelAdded;
        }
        currentCapacity += value;
        return value;
    }

    public Double decrement(Double value) {

        if(currentCapacity - value < 0) {
            Double fuelUsed = currentCapacity;
            currentCapacity = 0D;
            return fuelUsed ;
        }
        currentCapacity -= value;
        return value;
    }
    
    public FuelTank(Double currentCapacity, Double maximumCapacity) {
        this.currentCapacity = currentCapacity;
        this.maximumCapacity = maximumCapacity;
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
