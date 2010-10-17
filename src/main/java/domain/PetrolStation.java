package domain;

import java.util.*;

public class PetrolStation {

    private Map<FuelType, FuelTank> availableFuel = new HashMap<FuelType, FuelTank>();
    private static final Double DEFAULT_DEPOT_TANK_CAPACITY = 10000000D;

    public PetrolStation(Double unleaded, Double diesel, Double premium) {
        addFuelFromDeliveryLorry(FuelType.UNLEADED, unleaded);
        addFuelFromDeliveryLorry(FuelType.DIESEL, unleaded);
        addFuelFromDeliveryLorry(FuelType.PREMIUM, unleaded);
    }

    public void addFuelFromDeliveryLorry(FuelType fuelType, Double fuel) {
        if( isFuelTypeServed(fuelType)) {
            availableFuel.get(fuelType).increment(fuel);
        } else {
            availableFuel.put(fuelType, new FuelTank(fuel, DEFAULT_DEPOT_TANK_CAPACITY));
        }
    }

    public Double getFuelTypeInventory(FuelType fuelType) {
        if(isFuelTypeServed(fuelType)) {
            return availableFuel.get(fuelType).getCurrentCapacity();
        }
        return 0D;
    }

    public Double removeFuelFromStock(FuelType fuelType, Double fuel) {
        return availableFuel.get(fuelType).decrement(fuel);
    }

    public boolean isFuelTypeServed(FuelType fuelType) {
        return availableFuel.containsKey(fuelType);
    }

    public boolean hasFuelInTankOfThisType(FuelType fuelType) {
        return (getFuelTypeInventory(fuelType) > 0D);
    }


    public String toString() {
        String output = "";
        Map<FuelType, FuelTank> fuelAvailable = this.availableFuel;
        return fuelAvailable.toString();
        
    }

}

