package commercial;

import io.github.nathanjrussell.vehicles.categories.commercial.truck.makes.freightliner.engines.enums.CumminsEngines;
import io.github.nathanjrussell.vehicles.categories.commercial.truck.makes.freightliner.engines.enums.DetroitEngines;
import io.github.nathanjrussell.vehicles.categories.commercial.truck.makes.freightliner.enums.Frames;
import io.github.nathanjrussell.vehicles.categories.commercial.truck.makes.freightliner.enums.Models;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class flTest {

    @Test
    void returnsCorrectModelName() {
        assertEquals("Cascadia DD13", Models.CASCADIA_DD13.getModelName());
        assertEquals("Columbia Series 60", Models.COLUMBIA_SERIES60.getModelName());
    }

    @Test
    void returnsCorrectEngine() {
        assertTrue(Models.CASCADIA_DD13.getEngine() instanceof DetroitEngines);
        assertTrue(Models.COLUMBIA_ISX15.getEngine() instanceof CumminsEngines);
    }

    @Test
    void returnsCorrectFrameType() {
        assertEquals(Frames.CASCADIA_FRAME, Models.CASCADIA_DD13.getFrameType());
        assertEquals(Frames.COLUMBIA_FRAME, Models.COLUMBIA_SERIES60.getFrameType());
    }

    @Test
    void handlesToStringOutput() {
        String expected = """
Model: Cascadia DD13
	Frame Details:
		Frame Type: Cascadia Frame
		Description: Aerodynamic long-haul highway tractor frame optimized for efficiency and driver comfort.
	Detroit Diesel Engine Model: Detroit Diesel DD13 12.8L I6
		Engine Type: Combustion
		Max Power Output: 450 HP
		Fuel Type: Diesel
		Number of Cylinders: 6
		Displacement: 12.8 L
		Engine Warranty Information:
			Warranty Years: 5
			Warranty Miles: 300000
            """;
        assertEquals(expected.trim(), Models.CASCADIA_DD13.toString().trim());
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
