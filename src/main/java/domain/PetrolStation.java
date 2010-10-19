package domain;

import java.util.*;

public class PetrolStation {

    private Map<FuelType, FuelTank> availableFuel = new HashMap<FuelType, FuelTank>();


    public PetrolStation(Double maxFuelTankCapacity) {
        initialiseAvailableFuelWithAllFuelTypes(maxFuelTankCapacity);
    }

    public void addFuel(FuelType fuelType, Double fuel) {
        if( isFuelTypeServed(fuelType)) {
            getAvailableFuel().get(fuelType).increment(fuel);
        }
    }

    public boolean isFuelTypeServed(FuelType fuelType) {
        return getAvailableFuel().containsKey(fuelType);
    }

    public Double getFuelTypeInventory(FuelType fuelType) {
        Double fuelAvailable = 0D;

        if( isFuelTypeServed(fuelType)) {
            fuelAvailable = getAvailableFuel().get(fuelType).getCurrentCapacity();
        }
        return fuelAvailable;
    }

    public Double removeFuelFromStock(FuelType fuelType, Double fuel) {
        Double fuelRemovedFromStock = 0D;

        if( isFuelTypeServed(fuelType)) {
            fuelRemovedFromStock = getAvailableFuel().get(fuelType).decrement(fuel);
        }
        return fuelRemovedFromStock;
    }

    public boolean hasFuelInTankOfThisType(FuelType fuelType) {
        return (getFuelTypeInventory(fuelType) > 0D);
    }

    public String toString() {
        return this.getAvailableFuel().toString();
    }

    public Map<FuelType, FuelTank> getAvailableFuel() {
        return availableFuel;
    }

    private void initialiseAvailableFuelWithAllFuelTypes(Double maximumCapacity) {
        List<FuelType> fuelTypes = Arrays.asList(FuelType.values());
        for (Iterator iterator = fuelTypes.iterator(); iterator.hasNext();) {
            availableFuel.put( (FuelType) iterator.next(), new FuelTank(0D, maximumCapacity) );
        }
    }

}

