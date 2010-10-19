package domain;

public class Vehicle {

    private final FuelType fuelType;
    private FuelTank fuelTank;
    private final Double DEFAULT_MAXIMUM_FUEL_TANK_CAPACITY = 1000D;

    public Vehicle() {
        this.fuelType = FuelType.UNLEADED;
        setFuelTank(new FuelTank(0D, DEFAULT_MAXIMUM_FUEL_TANK_CAPACITY));
    }
    
    public Vehicle(FuelType fuelType, Double maximumFuelTankCapacity, Double currentFuelTankCapacity) {
        this.fuelType = fuelType;
        setFuelTank(new FuelTank(currentFuelTankCapacity, maximumFuelTankCapacity));
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

    public FuelType getFuelType() {
        return fuelType;
    }

    public String toString() {
        return "Fuel:             " + fuelType.toString() + "\n" +
               "Current Capacity: " + this.getFuelTank().getCurrentCapacity().toString() + "\n" +
               "Max Capacity:     " + this.getFuelTank().getMaximumCapacity().toString();
    }

    public FuelTank getFuelTank() {
        return fuelTank;
    }

    public void setFuelTank(FuelTank fuelTank) {
        this.fuelTank = fuelTank;
    }
}
