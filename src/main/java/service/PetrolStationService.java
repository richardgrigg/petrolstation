package service;

import domain.FuelType;
import domain.PetrolStation;
import domain.Vehicle;

import static java.lang.String.format;

public class PetrolStationService {

    public Double serveFuel(PetrolStation station, Vehicle vehicle, Double fuel) throws Exception {

        if(! station.isFuelTypeServed(vehicle.getFuelType() )) {
            throw new Exception( format("Sorry, we don't serve %s", vehicle.getFuelType().toString() ));
        }

        if(! station.hasFuelInTankOfThisType(vehicle.getFuelType())) {
            throw new Exception( format("Sorry, we normally serve %s but have run out", vehicle.getFuelType().toString() ));
        }

        Double fuelAvailable = station.getFuelTypeInventory(vehicle.getFuelType());
        Double fuelUsedByCar = vehicle.getFuelTank().increment(fuelAvailable );
        station.removeFuelFromStock(vehicle.getFuelType(), fuelUsedByCar);

        return fuelUsedByCar;
    }


    public static void main(String[] args) throws Exception {
        final Double MAX_LOAD = 1000D;

        PetrolStationService petrolStationService = new PetrolStationService();
        PetrolStation petrolStation = new PetrolStation(MAX_LOAD);
        petrolStation.addFuel(FuelType.DIESEL, MAX_LOAD);
        petrolStation.addFuel(FuelType.UNLEADED, MAX_LOAD);
        petrolStation.addFuel(FuelType.PREMIUM, MAX_LOAD);


        Vehicle car = new Vehicle(FuelType.UNLEADED, 100D, 0D);
        Vehicle lorry = new Vehicle(FuelType.UNLEADED, 100D, 0D);

        System.out.println("Station: " + petrolStation.toString() );
        
        
        System.out.println("fuel car");
        System.out.println("Before");
        System.out.println(car.toString());
        System.out.println("put 100 petrol in");
        petrolStationService.serveFuel(petrolStation, car, 100D);
        System.out.println("After");
        System.out.println(car.toString());
        System.out.println("Station: " + petrolStation.toString() );
        
        System.out.println("fuel lorry");
        System.out.println("Before");
        System.out.println(lorry.toString());
        petrolStationService.serveFuel(petrolStation, lorry, 200D);
        System.out.println("After");
        System.out.println(lorry.toString());
                
        System.out.println("Station: " + petrolStation.toString() );
        
    }

}
