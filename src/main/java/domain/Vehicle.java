package domain;

public class Vehicle {

    private final FuelType fuelType;
    private final double maximumFuelTankCapacity;
    private double currentFuelTankCapacity;


    public Vehicle() {
        this.fuelType = FuelType.UNLEADED;
        this.maximumFuelTankCapacity = 1000D;
        this.currentFuelTankCapacity = 1000D;
    }
    
    public Vehicle(FuelType fuelType, Double maximumFuelTankCapacity, Double currentFuelTankCapacity) {
        this.fuelType = fuelType;
        this.maximumFuelTankCapacity = maximumFuelTankCapacity;
        this.currentFuelTankCapacity = currentFuelTankCapacity;
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

    public double getMaximumFuelTankCapacity() {
        return maximumFuelTankCapacity;
    }

    public double getCurrentFuelTankCapacity() {
        return currentFuelTankCapacity;
    }

    public void setCurrentFuelTankCapacity(double currentFuelTankCapacity) {
        this.currentFuelTankCapacity = currentFuelTankCapacity;
    }

    public String toString() {
        return "Fuel:             " + fuelType.toString() + "\n" +
               "Current Capacity: " + this.currentFuelTankCapacity + "\n" +
               "Max Capacity:     " + this.maximumFuelTankCapacity;
    }
}
