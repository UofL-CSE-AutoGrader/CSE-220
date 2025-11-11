package noncommercial;

import io.github.nathanjrussell.vehicles.Vehicle;
import io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.chevy.Constants;
import io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.chevy.Make;
import io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.chevy.engines.CombustionEngine;
import io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.chevy.engines.enums.CombustionEngines;
import io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.chevy.engines.enums.ElectricEngines;
import io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.chevy.enums.Frames;
import io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.chevy.enums.Models;
import io.github.nathanjrussell.vehicles.engines.interfaces.IEngine;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class chevyTest {
    private enum combustionEngines {
        //Chevy Internal Combustion Engines
        // 4-cylinder
        ECO_TEC_20("Ecotec 2.0L I4", 260, 4, 2.0),
        IRON_DUKE_25("Iron Duke 2.5L I4", 90, 4, 2.5),
        CHEVY_COMPACT_18("Compact 1.8L I4", 140, 4, 1.8),

        // 6-cylinder
        BLUE_FLAME_39("Blue Flame 3.9L I6", 150, 6, 3.9),
        VORTEC_43("Vortec 4.3L V6", 200, 6, 4.3),
        CHEVY_METRO_30("Metro Sport 3.0L V6", 175, 6, 3.0),

        // 8-cylinder
        SMALL_BLOCK_57("Small Block 5.7L V8", 290, 8, 5.7),
        LS1_57("LS1 5.7L V8", 345, 8, 5.7),
        BIG_BLOCK_74("Big Block 7.4L V8", 360, 8, 7.4),
        CHEVY_TITAN_62("Titan Concept 6.2L V8", 500, 8, 6.2)
        ;
        private final String engineModel;
        private final int maxPowerOutput;
        private final int numCylinders;
        private final double displacement;

        combustionEngines(String engineModel, int maxPowerOutput, int numCylinders, double displacementCC) {
            this.engineModel = engineModel;
            this.maxPowerOutput = maxPowerOutput;
            this.numCylinders = numCylinders;
            this.displacement = displacementCC;
        }
    }

    private enum electricEngines {
        ELECTRIC_75KW("Electric 75kW Motor", 75),
        ELECTRIC_150KW("Electric 150kW Motor", 150),
        ELECTRIC_200KW("Electric 200kW Motor", 200),
        ELECTRIC_250KW("Electric 250kW Motor", 250),
        ELECTRIC_350KW("Electric 350kW Motor", 350)

        ;
        private final String engineModel;
        private final int maxPowerOutput;

        electricEngines(String engineModel, int maxPowerOutput) {
            this.engineModel = engineModel;
            this.maxPowerOutput = maxPowerOutput;
        }
    }

    private enum frames {
        C_K_SERIES("C/K Series", "Classic full-size truck frame known for durability and versatility."),
        GMT800("GMT800", "Robust ladder frame used in Chevy trucks and SUVs during the early 2000s."),
        GMT900("GMT900", "Improved full-size SUV and truck frame designed for strength and towing capacity."),
        ZETA("Zeta Platform", "Performance-oriented unibody frame used in the Camaro and other sporty models."),
        ALPHA("Alpha Platform", "Lightweight, rigid frame engineered for modern performance sedans and coupes."),
        E2XX("E2XX", "Mid-size car platform providing a balance of comfort, efficiency, and handling."),
        T1XX("T1XX", "Current generation full-size SUV and truck frame offering enhanced safety and capability.")

        ;
        private final String frameType;
        private final String frameDesc;
        frames(String frameType, String frameDesc) {
            this.frameType = frameType;
            this.frameDesc = frameDesc;
        }
    }

    private enum models {
        // Chevrolet Combustion Models
        CAMARO_SS("Camaro SS", CombustionEngines.LS1_57, Frames.ZETA),
        CORVETTE_STINGRAY("Corvette Stingray", CombustionEngines.SMALL_BLOCK_57, Frames.ALPHA),
        SILVERADO_1500("Silverado 1500", CombustionEngines.VORTEC_43, Frames.T1XX),
        SUBURBAN("Suburban", CombustionEngines.BIG_BLOCK_74, Frames.GMT900),

        // Chevrolet Electric Models
        BOLT_EV("Bolt EV", ElectricEngines.ELECTRIC_150KW, Frames.E2XX),
        SILVERADO_EV("Silverado EV", ElectricEngines.ELECTRIC_350KW, Frames.T1XX),
        CAMARO_E("Camaro E", ElectricEngines.ELECTRIC_200KW, Frames.ALPHA)

        ;
        private final String modelName;
        private final IEngine engine;
        private final Frames frameType;
        models(String modelName, IEngine engine, Frames frameType) {
            this.engine = engine;
            this.frameType = frameType;
            this.modelName = modelName;
        }
    }
    @Test
    void verifyAllCombustionEngines() {
        for (CombustionEngines engine : CombustionEngines.values()) {
            assertTrue(engine instanceof IEngine);
            boolean found = false;
            for (combustionEngines ce : combustionEngines.values()) {
                if (engine.engineModel().equals(ce.engineModel)
                        && engine.powerOutput() == ce.maxPowerOutput
                        && engine.numCylinders() == ce.numCylinders
                        && engine.displacement() == ce.displacement) {
                    found = true;
                    break;
                }
            }
            assertTrue(found, "Engine not found: " + engine.engineModel());
        }
    }

    @Test
    void verifyAllElectricEngines() {
        for (ElectricEngines engine : ElectricEngines.values()) {
            boolean found = false;
            for (electricEngines ee : electricEngines.values()) {
                if (engine.engineModel().equals(ee.engineModel)
                        && engine.powerOutput() == ee.maxPowerOutput) {
                    found = true;
                    break;
                }
            }
            assertTrue(found, "Engine not found: " + engine.engineModel());
        }
    }

    @Test
    void verifyAllFrames() {
        for (Frames frame : Frames.values()) {
            boolean found = false;
            for (frames f : frames.values()) {
                if (frame.getFrameName().equals(f.frameType)
                        && frame.getFrameDesc().equals(f.frameDesc)) {
                    found = true;
                    break;
                }
            }
            assertTrue(found, "Frame not found: " + frame.getFrameName());
        }
    }

    @Test
    void verifyModels() {
        for (Models model : Models.values()) {
            boolean found = false;
            for (models m : models.values()) {
                if (model.getModelName().equals(m.modelName)
                        && model.getEngine().equals(m.engine)
                        && model.getFrameType() == m.frameType) {
                    found = true;
                    break;
                }
            }
            assertTrue(found, "Model not found: " + model.getModelName());
        }
    }

    @Test
    void electricMotorWarrantyYearsIsCorrect() {
        assertEquals(8, Constants.ELECTRIC_MOTOR_WARRANTY_YEARS);
    }

    @Test
    void electricMotorWarrantyMilesIsCorrect() {
        assertEquals(100000, Constants.ELECTRIC_MOTOR_WARRANTY_MILES);
    }

    @Test
    void combustionEngineWarrantyYearsIsCorrect() {
        assertEquals(5, Constants.COMBUSTION_ENGINE_WARRANTY_YEARS);
    }

    @Test
    void combustionEngineWarrantyMilesIsCorrect() {
        assertEquals(80000, Constants.COMBUSTION_ENGINE_WARRANTY_MILES);
    }

    @Test
    void verifyCombustionEngineString() {
        Random random = new Random();
        int power = random.nextInt(50, 500);
        int cylinders = 2 * random.nextInt(1, 4);
        double displacement = 2.0;
        CombustionEngine engine = new CombustionEngine(power,cylinders,displacement);
        String actual = engine.toString();
        String expected = String.format(
                "Engine Type: Combustion\n" +
                        "Max Power Output: %d HP\n" +
                        "Fuel Type: Gasoline\n" +
                        "Number of Cylinders: %d\n" +
                        "Displacement: %.1f L\n" +
                        "Engine Warranty Information:\n" +
                        "\tWarranty Years: %d\n" +
                        "\tWarranty Miles: %d\n",
                power, cylinders, displacement, Constants.COMBUSTION_ENGINE_WARRANTY_YEARS, Constants.COMBUSTION_ENGINE_WARRANTY_MILES);
        assertEquals(expected, actual);
    }

    @Test
    void verifyElectricEngineString() {
        Random random = new Random();
        int power = random.nextInt(50, 500);
        io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.chevy.engines.ElectricEngine engine =
                new io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.chevy.engines.ElectricEngine(power);
        String actual = engine.toString();
        String expected = String.format(
                "Engine Type: Electric\n" +
                        "Max Power Output: %d kW\n" +
                        "Motor Type: Direct Current\n" +
                        "Engine Warranty Information:\n" +
                        "\tWarranty Years: %d\n" +
                        "\tWarranty Miles: %d\n",
                power, Constants.ELECTRIC_MOTOR_WARRANTY_YEARS, Constants.ELECTRIC_MOTOR_WARRANTY_MILES);
        assertEquals(expected, actual);
    }

    @Test
    void verifyCombustionModelString() {
        Vehicle vehicle = new Make("EIN12345678901234",Models.CAMARO_SS);
        String actual = vehicle.toString();
        String expected = """
            Vehicle Information:
            \tVIN: EIN12345678901234
            \tVehicle Category: Non-Commercial
            \tNon-Commercial Category: Pickup Truck
            \tPickup Truck Details:
            \t\tMake: Chevrolet
            \t\tManufacture ID: C67890
            \t\tModel: Camaro SS
            \t\t\tFrame Details:
            \t\t\t\tFrame Type: Zeta Platform
            \t\t\t\tDescription: Performance-oriented unibody frame used in the Camaro and other sporty models.
            \t\t\tEngine Model: LS1 5.7L V8
            \t\t\t\tEngine Type: Combustion
            \t\t\t\tMax Power Output: 345 HP
            \t\t\t\tFuel Type: Gasoline
            \t\t\t\tNumber of Cylinders: 8
            \t\t\t\tDisplacement: 5.7 L
            \t\t\t\tEngine Warranty Information:
            \t\t\t\t\tWarranty Years: 5
            \t\t\t\t\tWarranty Miles: 80000
            """;

        assertEquals(actual, expected);
    }

    @Test
    void verifyElectricModelString() {
        Vehicle vehicle = new Make("EIN98765432109876", Models.BOLT_EV);
        String actual = vehicle.toString();
        String expected = """
            Vehicle Information:
            \tVIN: EIN98765432109876
            \tVehicle Category: Non-Commercial
            \tNon-Commercial Category: Pickup Truck
            \tPickup Truck Details:
            \t\tMake: Chevrolet
            \t\tManufacture ID: C67890
            \t\tModel: Bolt EV
            \t\t\tFrame Details:
            \t\t\t\tFrame Type: E2XX
            \t\t\t\tDescription: Mid-size car platform providing a balance of comfort, efficiency, and handling.
            \t\t\tEngine Model: Electric 150kW Motor
            \t\t\t\tEngine Type: Electric
            \t\t\t\tMax Power Output: 150 kW
            \t\t\t\tMotor Type: Direct Current
            \t\t\t\tEngine Warranty Information:
            \t\t\t\t\tWarranty Years: 8
            \t\t\t\t\tWarranty Miles: 100000
            """;

        assertEquals(actual, expected);
    }

}