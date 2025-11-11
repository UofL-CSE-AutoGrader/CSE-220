package commercial;
import io.github.nathanjrussell.vehicles.categories.commercial.truck.makes.kenworth.engines.enums.CumminsEngines;
import io.github.nathanjrussell.vehicles.categories.commercial.truck.makes.kenworth.engines.enums.PaccarEngines;
import io.github.nathanjrussell.vehicles.categories.commercial.truck.makes.kenworth.enums.Frames;
import io.github.nathanjrussell.vehicles.categories.commercial.truck.makes.kenworth.enums.Models;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class kenworthTest {

    @Test
    void returnsCorrectModelName() {
        assertEquals("Kenworth T680 MX-13", Models.T680_MX13.getModelName());
        assertEquals("Kenworth W900 MX-13", Models.W900_MX13.getModelName());
    }

    @Test
    void returnsCorrectEngine() {
        assertTrue(Models.T680_MX13.getEngine() instanceof PaccarEngines);
        assertTrue(Models.T680_X15.getEngine() instanceof CumminsEngines);
    }

    @Test
    void returnsCorrectFrameType() {
        assertEquals(Frames.T680_FRAME, Models.T680_MX13.getFrameType());
        assertEquals(Frames.W900_FRAME, Models.W900_MX13.getFrameType());
    }

    @Test
    void handlesToStringOutput() {
        String expected = """
Model: Kenworth T680 MX-13
	Frame Details:
		Frame Type: T680 Frame
		Description: Aerodynamic Class 8 highway tractor frame engineered for fuel efficiency and comfort.
	Engine Model: PACCAR MX-13 12.9L I6
		Engine Type: Combustion
		Max Power Output: 510 HP
		Fuel Type: Diesel
		Number of Cylinders: 6
		Displacement: 12.9 L
		Engine Warranty Information:
			Warranty Years: 5
			Warranty Miles: 500000
            """;
        assertEquals(expected.trim(), Models.T680_MX13.toString(0).trim());
    }

    @Test
    void handlesNullSafety() {
        for (Models model : Models.values()) {
            assertNotNull(model.getModelName());
            assertNotNull(model.getEngine());
            assertNotNull(model.getFrameType());
        }
    }
}
