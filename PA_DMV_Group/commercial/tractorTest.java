package commercial;
import io.github.nathanjrussell.vehicles.categories.commercial.truck.makes.enums.TruckMakes;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class tractorTest {

    @Test
    void returnsCorrectManufacturer() {
        assertEquals("Kenworth", TruckMakes.KENWORTH.manufacturer());
        assertEquals("Freightliner", TruckMakes.FREIGHTLINER.manufacturer());
    }

    @Test
    void returnsCorrectCountry() {
        assertEquals("USA", TruckMakes.KENWORTH.country());
        assertEquals("USA", TruckMakes.FREIGHTLINER.country());
    }

    @Test
    void returnsCorrectContact() {
        assertEquals("service@kenworth.com", TruckMakes.KENWORTH.contact());
        assertEquals("service@freightliner.com", TruckMakes.FREIGHTLINER.contact());
    }

    @Test
    void returnsCorrectManufacturerId() {
        assertEquals("K11223", TruckMakes.KENWORTH.manufacturerId());
        assertEquals("F44556", TruckMakes.FREIGHTLINER.manufacturerId());
    }

    @Test
    void handlesNullSafety() {
        assertNotNull(TruckMakes.KENWORTH.manufacturer());
        assertNotNull(TruckMakes.FREIGHTLINER.manufacturer());
        assertNotNull(TruckMakes.KENWORTH.country());
        assertNotNull(TruckMakes.FREIGHTLINER.country());
        assertNotNull(TruckMakes.KENWORTH.contact());
        assertNotNull(TruckMakes.FREIGHTLINER.contact());
        assertNotNull(TruckMakes.KENWORTH.manufacturerId());
        assertNotNull(TruckMakes.FREIGHTLINER.manufacturerId());
    }
}
