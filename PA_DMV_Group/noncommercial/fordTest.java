package noncommercial;

import io.github.nathanjrussell.vehicles.Vehicle;
import io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.Make;
import io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.engines.CombustionEngine;
import io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.Constants;
import io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.engines.enums.CombustionEngines;
import io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.engines.enums.ElectricEngines;
import io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.enums.Frames;
import io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.enums.Models;
import io.github.nathanjrussell.vehicles.engines.interfaces.IEngine;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class fordTest {
    private enum combustionEngines {
        // Ford 4-cylinder
        ECOBOOST_15("EcoBoost 1.5L I4", 181, 4, 1.5),
        ECOBOOST_20("EcoBoost 2.0L I4", 245, 4, 2.0),
        DURATEC_23("Duratec 2.3L I4", 160, 4, 2.3),

        // Ford 6-cylinder
        ECOBOOST_27("EcoBoost 2.7L V6", 325, 6, 2.7),
        ECOBOOST_35("EcoBoost 3.5L V6", 400, 6, 3.5),
        COYOTE_35("Cyclone 3.5L V6", 265, 6, 3.5),

        // Ford 8-cylinder
        COYOTE_50("Coyote 5.0L V8", 460, 8, 5.0),
        GODZILLA_73("Godzilla 7.3L V8", 430, 8, 7.3),
        PREDATOR_52("Predator 5.2L V8", 760, 8, 5.2),
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
        ELECTRIC_210KW("Ford Electric 210kW", 281),
        ELECTRIC_358KW("Ford Electric 358kW", 480),
        ELECTRIC_150KW("Ford Electric 150kW", 201)


        ;
        private final String engineModel;
        private final int maxPowerOutput;

        electricEngines(String engineModel, int maxPowerOutput) {
            this.engineModel = engineModel;
            this.maxPowerOutput = maxPowerOutput;
        }
    }

    private enum frames {
        D_SERIES("D-Series", "Classic body-on-frame design used in early Ford trucks."),
        T_SERIES("T-Series", "Modern ladder frame engineered for Ford trucks and heavy-duty SUVs."),
        CD4("CD4 Platform", "Versatile front-wheel drive and all-wheel drive unibody frame for sedans and crossovers."),
        D4("D4 Platform", "SUV unibody platform supporting models like the Explorer and Flex."),
        FOX("Fox Platform", "Lightweight and adaptable unibody platform used in performance cars like the Mustang."),
        S550("S550 Platform", "Modern Mustang frame emphasizing rigidity and handling."),
        U775("U775 Platform", "Strong body-on-frame platform used in the F-Series trucks."),
        GE1("GE1 Platform", "Ford's dedicated electric vehicle frame, underpinning the Mustang Mach-E."),
        TE1("TE1 Platform", "Heavy-duty electric truck frame used for the F-150 Lightning.")

        ;
        private final String frameType;
        private final String frameDesc;
        frames(String frameType, String frameDesc) {
            this.frameType = frameType;
            this.frameDesc = frameDesc;
        }
    }

    private enum models {
        MUSTANG_GT("Mustang GT", io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.engines.enums.CombustionEngines.COYOTE_50, io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.enums.Frames.S550),
        SHELBY_GT500("Shelby GT500", io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.engines.enums.CombustionEngines.PREDATOR_52, io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.enums.Frames.S550),
        F150_XLT("F-150 XLT", io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.engines.enums.CombustionEngines.ECOBOOST_35, io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.enums.Frames.U775),
        F150_SUPERDUTY("F-150 Super Duty", io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.engines.enums.CombustionEngines.GODZILLA_73, io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.enums.Frames.T_SERIES),
        FUSION_SE("Fusion SE", io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.engines.enums.CombustionEngines.ECOBOOST_20, io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.enums.Frames.CD4),
        ESCAPE("Escape", io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.engines.enums.CombustionEngines.DURATEC_23, io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.enums.Frames.CD4),

        // Ford Electric Models
        MUSTANG_MACH_E("Mustang Mach-E", io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.engines.enums.ElectricEngines.ELECTRIC_210KW, io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.enums.Frames.GE1),
        F150_LIGHTNING("F-150 Lightning", io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.engines.enums.ElectricEngines.ELECTRIC_358KW, io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.enums.Frames.TE1),
        FORD_FOCUS_ELECTRIC("Focus Electric", io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.engines.enums.ElectricEngines.ELECTRIC_150KW, io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.enums.Frames.CD4)

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
        io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.engines.ElectricEngine engine =
                new io.github.nathanjrussell.vehicles.categories.noncommercial.truck.makes.ford.engines.ElectricEngine(power);
        String actual = engine.toString();
        String expected = String.format(
                "Engine Type: Electric\n" +
                        "Max Power Output: %d kW\n" +
                        "Motor Type: Direct Current\n" +
                        "Engine Warranty Information:\n" +
                        "\tWarranty Years: %d\n" +
                        "\tWarranty Miles: %d\n",
                power,
                Constants.ELECTRIC_MOTOR_WARRANTY_YEARS,
                Constants.ELECTRIC_MOTOR_WARRANTY_MILES);
        assertEquals(expected, actual);
    }

    @Test
    void verifyCombustionModelString() {
        Vehicle vehicle = new Make("T339KFSASEGKJH45", Models.F150_XLT);
        String actual = vehicle.toString();
        String expected = """
            Vehicle Information:
            \tVIN: T339KFSASEGKJH45
            \tVehicle Category: Non-Commercial
            \tNon-Commercial Category: Pickup Truck
            \tPickup Truck Details:
            \t\tMake: Ford Motor Company
            \t\tManufacture ID: F12345
            \t\tModel: F-150 XLT
            \t\t\tFrame Details:
            \t\t\t\tFrame Type: U775 Platform
            \t\t\t\tDescription: Strong body-on-frame platform used in the F-Series trucks.
            \t\t\tEngine Model: EcoBoost 3.5L V6
            \t\t\t\tEngine Type: Combustion
            \t\t\t\tMax Power Output: 400 HP
            \t\t\t\tFuel Type: Gasoline
            \t\t\t\tNumber of Cylinders: 6
            \t\t\t\tDisplacement: 3.5 L
            \t\t\t\tEngine Warranty Information:
            \t\t\t\t\tWarranty Years: 5
            \t\t\t\t\tWarranty Miles: 80000
            """;

        assertEquals(actual, expected);

    }

    @Test
    void verifyElectricModelString() {
        Vehicle vehicle = new Make("ELECTRICVIN1234567", Models.MUSTANG_MACH_E);
        String actual = vehicle.toString();
        String expected = """
            Vehicle Information:
            \tVIN: ELECTRICVIN1234567
            \tVehicle Category: Non-Commercial
            \tNon-Commercial Category: Pickup Truck
            \tPickup Truck Details:
            \t\tMake: Ford Motor Company
            \t\tManufacture ID: F12345
            \t\tModel: Mustang Mach-E
            \t\t\tFrame Details:
            \t\t\t\tFrame Type: GE1 Platform
            \t\t\t\tDescription: Ford's dedicated electric vehicle frame, underpinning the Mustang Mach-E.
            \t\t\tEngine Model: Ford Electric 210kW
            \t\t\t\tEngine Type: Electric
            \t\t\t\tMax Power Output: 281 kW
            \t\t\t\tMotor Type: Direct Current
            \t\t\t\tEngine Warranty Information:
            \t\t\t\t\tWarranty Years: 8
            \t\t\t\t\tWarranty Miles: 100000
            """;

        assertEquals(actual, expected);

    }
}