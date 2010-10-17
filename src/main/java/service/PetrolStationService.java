package service;

import domain.FuelType;
import domain.PetrolStation;
import domain.Vehicle;

public class PetrolStationService {

    public void servePetrol(PetrolStation petrolStation, Vehicle vehicle, Double fuel) throws Exception {
        Double fuelServed = 0D;
        if(checkFuelAvailability(petrolStation, vehicle, fuel)) {
            fuelServed = addFuelToVehicle(petrolStation, vehicle, fuel);
            petrolStation.removeFuelFromStock(vehicle.getFuelType(), fuelServed);
        } else {
            throw new Exception("No fuel today");
        }
    }

    private Double addFuelToVehicle(PetrolStation station, Vehicle vehicle, Double fuel) {
        Double fuelUsed = 0D;
        if( (vehicle.getCurrentFuelTankCapacity() + fuel) <= vehicle.getMaximumFuelTankCapacity() ) {
            vehicle.setCurrentFuelTankCapacity( vehicle.getCurrentFuelTankCapacity() + fuel );
            fuelUsed = fuel;
        } else {
            fuelUsed = (vehicle.getMaximumFuelTankCapacity() - vehicle.getCurrentFuelTankCapacity());
            vehicle.setCurrentFuelTankCapacity( vehicle.getMaximumFuelTankCapacity() );
        }
        return fuelUsed;
    }

    private boolean checkFuelAvailability(PetrolStation petrolStation, Vehicle vehicle, Double fuel) {
        Double fuelStock = petrolStation.getFuelTypeInventory(vehicle.getFuelType());
        return  fuel.doubleValue() <= fuelStock.doubleValue();
    }

    public static void main(String[] args) throws Exception {
        final Double MAX_LOAD = 1000D;
        PetrolStationService petrolStationService = new PetrolStationService();
        PetrolStation petrolStation = new PetrolStation(MAX_LOAD, MAX_LOAD, MAX_LOAD);

        Vehicle car = new Vehicle(FuelType.UNLEADED, 100D, 0D);
        Vehicle lorry = new Vehicle(FuelType.UNLEADED, 100D, 0D);

        System.out.println("Station: " + petrolStation.toString() );
        
        System.out.println("fuel car");
        System.out.println("Before");
        System.out.println(car.toString());
        System.out.println("put 100 petrol in");
        petrolStationService.servePetrol(petrolStation, car, 100D);
        System.out.println("After");
        System.out.println(car.toString());
        System.out.println("Station: " + petrolStation.toString() );
        
        System.out.println("fuel lorry");
        System.out.println("Before");
        System.out.println(lorry.toString());
        petrolStationService.servePetrol(petrolStation, lorry, 200D);
        System.out.println("After");
        System.out.println(lorry.toString());
                
        System.out.println("Station: " + petrolStation.toString() );
        
    }

}
