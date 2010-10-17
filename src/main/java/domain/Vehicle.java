package domain;

public class Vehicle {

    private final FuelType fuelType;
    private FuelTank fuelTank;
    private final Double DEFAULT_MAXIMUM_FUEL_TANK_CAPACITY = 1000D;

    public Vehicle() {
        this.fuelType = FuelType.UNLEADED;
        fuelTank = new FuelTank(0D, DEFAULT_MAXIMUM_FUEL_TANK_CAPACITY);
    }
    
    public Vehicle(FuelType fuelType, Double maximumFuelTankCapacity, Double currentFuelTankCapacity) {
        this.fuelType = fuelType;
        fuelTank = new FuelTank(currentFuelTankCapacity, maximumFuelTankCapacity);
    }

    public void drive() {
        startEngine();
        checkLoadSecure();
        accelerate();
    }

    public void startEngine() {
    }

    public void checkLoadSecure() {
    }

    public void accelerate() {
    }

    public Double addFuel(Double fuelToAdd) {
        return fuelTank.increment(fuelToAdd);
    }

    public Double useFuel(Double fuelUsed) {
        return fuelTank.decrement(fuelUsed);
    }

    public FuelType getFuelType() {
        return fuelType;
    }

    public String toString() {
        return "Fuel:             " + fuelType.toString() + "\n" +
               "Current Capacity: " + this.fuelTank.getCurrentCapacity().toString() + "\n" +
               "Max Capacity:     " + this.fuelTank.getMaximumCapacity().toString();
    }
}
