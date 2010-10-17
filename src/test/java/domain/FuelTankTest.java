package domain;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertEquals;


public class FuelTankTest {

    @Before
    public void setup() {

    }

    @Test
    public void testIncrementToMaxWhenEmpty() throws Exception {
        FuelTank fuelTank = new FuelTank(0D, 1000D);
        Double actual = fuelTank.increment(1000D);
        assertEquals(1000D, actual);
    }

    @Test
    public void testOverfillWhenEmpty() throws Exception {
        FuelTank fuelTank = new FuelTank(0D, 1000D);
        Double actual = fuelTank.increment(1500D);
        assertEquals(1000D, actual);
    }

    @Test
    public void testOverfillWhenHalfFull() throws Exception {
        Double initialCapacity = 500D;
        Double maximumCapacity = 1000D;
        FuelTank fuelTank = new FuelTank(initialCapacity, maximumCapacity);
        Double actual = fuelTank.increment(1000D);
        assertEquals(500D, actual);        
    }

    @Test
    public void testDecrementUseAll() throws Exception {
        Double initialCapacity = 500D;
        Double maximumCapacity = 1000D;
        FuelTank fuelTank = new FuelTank(initialCapacity, maximumCapacity);
        Double actual = fuelTank.decrement(1000D);
        assertEquals(500D, actual);                
    }

    @Test
    public void testDecrementUseSome() throws Exception {
        Double initialCapacity = 500D;
        Double maximumCapacity = 1000D;
        FuelTank fuelTank = new FuelTank(initialCapacity, maximumCapacity);
        Double actual = fuelTank.decrement(400D);
        assertEquals(400D, actual);                
    }

    @Test
    public void testDecrementUseSomeCheckResidual() throws Exception {
        Double initialCapacity = 500D;
        Double maximumCapacity = 1000D;
        FuelTank fuelTank = new FuelTank(initialCapacity, maximumCapacity);
        fuelTank.decrement(400D);
        Double actual = fuelTank.getCurrentCapacity();
        assertEquals(100D, actual);
    }

}
