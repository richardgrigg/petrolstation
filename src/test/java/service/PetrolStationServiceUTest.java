package service;

import domain.FuelTank;
import domain.FuelType;
import domain.PetrolStation;
import domain.Vehicle;
import org.junit.Before;
import org.junit.Test;
import service.PetrolStationService;

import static junit.framework.Assert.assertEquals;

public class PetrolStationServiceUTest {

    private PetrolStationService petrolStationService;
    @Before
    public void setup() {
        petrolStationService = new PetrolStationService();
           
    }

    //Should probably throw a more specific exception here to ensure that one could distinguish between the two thrown by the service.. still
    @Test(expected=Exception.class)
    public void serveFuelFuelNotServed() throws Exception {
        PetrolStation station = new PetrolStation(10000D);
        station.getAvailableFuel().remove(FuelType.UNLEADED);

        Vehicle vehicle = new Vehicle();
        vehicle.setFuelTank( new FuelTank(0D, 1000D));

        petrolStationService.serveFuel(station, vehicle, 10D);

    }

    @Test(expected=Exception.class)
    public void serverFuelNotServedRunOut() throws Exception {
        PetrolStation station = new PetrolStation(10000D);
        Vehicle vehicle = new Vehicle();
        vehicle.setFuelTank( new FuelTank(0D, 1000D));
        petrolStationService.serveFuel(station, vehicle, 10D);
    }

    @Test
    public void serveFuelWithinCapacityRangesOfBothVehicleAndStation() throws Exception {
        final Double MAX_VEHICLE_TANK = 1000D;
        final Double HALF_VEHICLE_TANK = 500D;

        PetrolStation station = new PetrolStation(10000D);
        station.addFuel(FuelType.UNLEADED, 8000D);

        Vehicle vehicle = new Vehicle();
        vehicle.setFuelTank( new FuelTank(HALF_VEHICLE_TANK, MAX_VEHICLE_TANK));
        Double actual = petrolStationService.serveFuel(station, vehicle, HALF_VEHICLE_TANK);
        
        assertEquals("Only half a tank (500) should be served as vehicle is already half full", HALF_VEHICLE_TANK, actual);

    }

    @Test
    public void serveFuelWithinCapacityRangesOfStationOverfillVehicle() throws Exception {
        final Double MAX_VEHICLE_TANK = 1000D;
        final Double HALF_VEHICLE_TANK = 500D;

        PetrolStation station = new PetrolStation(10000D);
        station.addFuel(FuelType.UNLEADED, 8000D);

        Vehicle vehicle = new Vehicle();
        vehicle.setFuelTank( new FuelTank(MAX_VEHICLE_TANK, MAX_VEHICLE_TANK));
        Double actual = petrolStationService.serveFuel(station, vehicle, HALF_VEHICLE_TANK);
        
        assertEquals("Vehicle should not be served fuel when tank is full", 0D, actual);

    }

    @Test
    public void serveFuelWithinCapacityRangesOfVehicleWithStationOnlyAbletoServePortionOfRequest() throws Exception {
        final Double MAX_VEHICLE_TANK = 6000D;
        PetrolStation station = new PetrolStation(5000D);
        station.addFuel(FuelType.UNLEADED, 5000D);

        Vehicle vehicle = new Vehicle();
        vehicle.setFuelTank( new FuelTank(0D, MAX_VEHICLE_TANK));
        Double actual = petrolStationService.serveFuel(station, vehicle, MAX_VEHICLE_TANK);
        
        assertEquals("Vehicle can only be served what is in station and no more", 5000D, actual);

    }

    @Test
    public void serveFuelAtLimitOfCapacityRangesOfBothVehicleAndCar() throws Exception {
        final Double MAX_TANK = 6000D;
        PetrolStation station = new PetrolStation(MAX_TANK);
        station.addFuel(FuelType.UNLEADED, MAX_TANK);

        Vehicle vehicle = new Vehicle();
        vehicle.setFuelTank( new FuelTank(0D, MAX_TANK));
        Double actual = petrolStationService.serveFuel(station, vehicle, MAX_TANK);
        
        assertEquals("Vehicle can only be served what is in station and no more", MAX_TANK, actual);

    }


    

}
