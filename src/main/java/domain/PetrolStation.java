package domain;

import java.util.*;

public class PetrolStation {

    private Map<FuelType, FuelStock> availableFuel = new HashMap<FuelType, FuelStock>();

    public PetrolStation(Double unleaded, Double diesel, Double premium) {
        addFuelFromDeliveryLorry(FuelType.UNLEADED, unleaded);
        addFuelFromDeliveryLorry(FuelType.DIESEL, unleaded);
        addFuelFromDeliveryLorry(FuelType.PREMIUM, unleaded);
    }

    public void addFuelFromDeliveryLorry(FuelType fuelType, Double fuel) {
        if( isFuelTypeAvailable(fuelType)) {
            availableFuel.get(fuelType).increment(fuel);
        } else {
            availableFuel.put(fuelType, new FuelStock(fuel));
        }
    }

    public Double getFuelTypeInventory(FuelType fuelType) {
        if(isFuelTypeAvailable(fuelType)) {
            return availableFuel.get(fuelType).getValue();
        }
        return 0D;
    }

    public void removeFuelFromStock(FuelType fuelType, Double fuel) {
        if(isFuelTypeAvailable(fuelType)) {
            availableFuel.get(fuelType).decrement(fuel);
        }
    }

    private boolean isFuelTypeAvailable(FuelType fuelType) {
        return availableFuel.containsKey(fuelType);
    }

    public boolean hasFuel(FuelType fuelType) {
        return (getFuelTypeInventory(fuelType) > 0D);
    }


    public String toString() {
        String output = "";
        Map<FuelType, FuelStock> fuelAvailable = this.availableFuel;
        return fuelAvailable.toString();
        
    }

}

