package noncommercial;

import io.github.nathanjrussell.vehicles.Vehicle;
import io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.harleydavidson.Constants;
import io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.harleydavidson.Make;
import io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.harleydavidson.engines.CombustionEngine;
import io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.harleydavidson.engines.enums.CombustionEngines;
import io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.harleydavidson.engines.enums.ElectricEngines;
import io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.harleydavidson.enums.Frames;
import io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.harleydavidson.enums.Models;
import io.github.nathanjrussell.vehicles.engines.interfaces.IEngine;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class harleyTest {
    private enum combustionEngines {
        V_TWIN("V-TWIN", 74, 2, 883),
        MILWAUKEE_EIGHT_107("Milwaukee Eight 107", 92, 2, 1122),
        MILWAUKEE_EIGHT_114("Milwaukee Eight 114", 100, 2, 1868),
        MILWAUKEE_EIGHT_117("Milwaukee Eight 117", 125, 2, 1923),
        REVOLUTION_MAX_1250T("Revolution Max 1250T", 121, 2, 1250),
        REVOLUTION_MAX_1250S("Revolution Max 1250S", 145, 2, 1250),
        ;
        private final String engineModel;
        private final int maxPowerOutput;
        private final int numCylinders;
        private final int displacement;

        combustionEngines(String engineModel, int maxPowerOutput, int numCylinders, int displacementCC) {
            this.engineModel = engineModel;
            this.maxPowerOutput = maxPowerOutput;
            this.numCylinders = numCylinders;
            this.displacement = displacementCC;
        }
    }

    private enum electricEngines {
        LIVEWIRE("LiveWire", 105),
        REVOLUTION_MAX("Revolution Max", 150),
        ;
        private final String engineModel;
        private final int maxPowerOutput;

        electricEngines(String engineModel, int maxPowerOutput) {
            this.engineModel = engineModel;
            this.maxPowerOutput = maxPowerOutput;
        }
    }

    private enum frames {
        CRUISER("Cruiser", "A motorcycle designed for long-distance riding with a relaxed riding position."),
        ADVENTURE("Adventure", "A motorcycle built for both on-road and off-road travel, suitable for long journeys."),
        ;
        private final String frameType;
        private final String frameDesc;
        frames(String frameType, String frameDesc) {
            this.frameType = frameType;
            this.frameDesc = frameDesc;
        }
    }

    private enum models {
        TRIKE_A("Trike Model A", CombustionEngines.MILWAUKEE_EIGHT_107, Frames.CRUISER),
        TRIKE_B("Trike Model B", CombustionEngines.MILWAUKEE_EIGHT_114, Frames.CRUISER),
        SPORTSTER_S("Sportster Model S", CombustionEngines.MILWAUKEE_EIGHT_117, Frames.CRUISER),
        ADVENTURE_TOURER("Adventure Tourer", CombustionEngines.V_TWIN, Frames.ADVENTURE),
        EADVENTURE_TOURER("Electic Adventure Tourer", ElectricEngines.LIVEWIRE, Frames.ADVENTURE),
        ECITY_CRUISER("Electric City Cruiser", ElectricEngines.LIVEWIRE, Frames.CRUISER)
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
        assertEquals(4, io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.harleydavidson.Constants.ELECTRIC_MOTOR_WARRANTY_YEARS);
    }

    @Test
    void electricMotorWarrantyMilesIsCorrect() {
        assertEquals(30000, io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.harleydavidson.Constants.ELECTRIC_MOTOR_WARRANTY_MILES);
    }

    @Test
    void combustionEngineWarrantyYearsIsCorrect() {
        assertEquals(2, io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.harleydavidson.Constants.COMBUSTION_ENGINE_WARRANTY_YEARS);
    }

    @Test
    void combustionEngineWarrantyMilesIsCorrect() {
        assertEquals(24000, io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.harleydavidson.Constants.COMBUSTION_ENGINE_WARRANTY_MILES);
    }

    @Test
    void verifyCombustionEngineString() {
        Random random = new Random();
        int power = random.nextInt(50, 500);
        int cylinders = 2 * random.nextInt(1, 4);
        int displacement = 20;
        CombustionEngine engine = new CombustionEngine(power,cylinders,displacement);
        String actual = engine.toString();
        String expected = String.format(
                "Engine Type: Combustion\n" +
                        "Max Power Output: %d HP\n" +
                        "Fuel Type: Gasoline\n" +
                        "Number of Cylinders: %d\n" +
                        "Displacement: 20.0 CC\n" +
                        "Engine Warranty Information:\n" +
                        "\tWarranty Years: %d\n" +
                        "\tWarranty Miles: %d\n",
                power, cylinders, Constants.COMBUSTION_ENGINE_WARRANTY_YEARS, Constants.COMBUSTION_ENGINE_WARRANTY_MILES);
        assertEquals(expected, actual);
    }

    @Test
    void verifyElectricEngineString() {
        Random random = new Random();
        int power = random.nextInt(50, 500);
        io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.harleydavidson.engines.ElectricEngine engine =
                new io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.harleydavidson.engines.ElectricEngine(power);
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
    void verifyCombustionVehicleString() {
        List<String> vehicleInfos = List.of(
                """
                Vehicle Information:
                \tVIN: F7E9NJH264ZF54MWV
                \tVehicle Category: Non-Commercial
                \tNon-Commercial Category: Motorcycle
                \tMotorcycle Details:
                \t\tMake: Harley-Davidson
                \t\tManufacture ID: D88961
                \t\tModel: Trike Model A
                \t\t\tFrame Details:
                \t\t\t\tFrame Type: Cruiser
                \t\t\t\tDescription: A motorcycle designed for long-distance riding with a relaxed riding position.
                \t\t\tEngine Model: Milwaukee Eight 107
                \t\t\t\tEngine Type: Combustion
                \t\t\t\tMax Power Output: 92 HP
                \t\t\t\tFuel Type: Gasoline
                \t\t\t\tNumber of Cylinders: 2
                \t\t\t\tDisplacement: 1122.0 CC
                \t\t\t\tEngine Warranty Information:
                \t\t\t\t\tWarranty Years: 2
                \t\t\t\t\tWarranty Miles: 24000
                """,
                """
                Vehicle Information:
                \tVIN: 02BSAFCVTRA580KR1
                \tVehicle Category: Non-Commercial
                \tNon-Commercial Category: Motorcycle
                \tMotorcycle Details:
                \t\tMake: Harley-Davidson
                \t\tManufacture ID: D88961
                \t\tModel: Trike Model B
                \t\t\tFrame Details:
                \t\t\t\tFrame Type: Cruiser
                \t\t\t\tDescription: A motorcycle designed for long-distance riding with a relaxed riding position.
                \t\t\tEngine Model: Milwaukee Eight 114
                \t\t\t\tEngine Type: Combustion
                \t\t\t\tMax Power Output: 100 HP
                \t\t\t\tFuel Type: Gasoline
                \t\t\t\tNumber of Cylinders: 2
                \t\t\t\tDisplacement: 1868.0 CC
                \t\t\t\tEngine Warranty Information:
                \t\t\t\t\tWarranty Years: 2
                \t\t\t\t\tWarranty Miles: 24000
                """,
                """
                Vehicle Information:
                \tVIN: XPVVEE87G2YK0PCSS
                \tVehicle Category: Non-Commercial
                \tNon-Commercial Category: Motorcycle
                \tMotorcycle Details:
                \t\tMake: Harley-Davidson
                \t\tManufacture ID: D88961
                \t\tModel: Sportster Model S
                \t\t\tFrame Details:
                \t\t\t\tFrame Type: Cruiser
                \t\t\t\tDescription: A motorcycle designed for long-distance riding with a relaxed riding position.
                \t\t\tEngine Model: Milwaukee Eight 117
                \t\t\t\tEngine Type: Combustion
                \t\t\t\tMax Power Output: 125 HP
                \t\t\t\tFuel Type: Gasoline
                \t\t\t\tNumber of Cylinders: 2
                \t\t\t\tDisplacement: 1923.0 CC
                \t\t\t\tEngine Warranty Information:
                \t\t\t\t\tWarranty Years: 2
                \t\t\t\t\tWarranty Miles: 24000
                """,
                """
                Vehicle Information:
                \tVIN: 9DYFH3RYGGE8B7EV1
                \tVehicle Category: Non-Commercial
                \tNon-Commercial Category: Motorcycle
                \tMotorcycle Details:
                \t\tMake: Harley-Davidson
                \t\tManufacture ID: D88961
                \t\tModel: Adventure Tourer
                \t\t\tFrame Details:
                \t\t\t\tFrame Type: Adventure
                \t\t\t\tDescription: A motorcycle built for both on-road and off-road travel, suitable for long journeys.
                \t\t\tEngine Model: V-TWIN
                \t\t\t\tEngine Type: Combustion
                \t\t\t\tMax Power Output: 74 HP
                \t\t\t\tFuel Type: Gasoline
                \t\t\t\tNumber of Cylinders: 2
                \t\t\t\tDisplacement: 883.0 CC
                \t\t\t\tEngine Warranty Information:
                \t\t\t\t\tWarranty Years: 2
                \t\t\t\t\tWarranty Miles: 24000
                """,
                """
                Vehicle Information:
                \tVIN: LE56EAG6BG72KAF0S
                \tVehicle Category: Non-Commercial
                \tNon-Commercial Category: Motorcycle
                \tMotorcycle Details:
                \t\tMake: Harley-Davidson
                \t\tManufacture ID: D88961
                \t\tModel: Electic Adventure Tourer
                \t\t\tFrame Details:
                \t\t\t\tFrame Type: Adventure
                \t\t\t\tDescription: A motorcycle built for both on-road and off-road travel, suitable for long journeys.
                \t\t\tEngine Model: LiveWire
                \t\t\t\tEngine Type: Electric
                \t\t\t\tMax Power Output: 105 kW
                \t\t\t\tMotor Type: Direct Current
                \t\t\t\tEngine Warranty Information:
                \t\t\t\t\tWarranty Years: 4
                \t\t\t\t\tWarranty Miles: 30000
                """
        );

        List<Vehicle> vehicles = List.of(
                new Make("F7E9NJH264ZF54MWV", Models.TRIKE_A),
                new Make("02BSAFCVTRA580KR1", Models.TRIKE_B),
                new Make("XPVVEE87G2YK0PCSS", Models.SPORTSTER_S),
                new Make("9DYFH3RYGGE8B7EV1", Models.ADVENTURE_TOURER),
                new Make("LE56EAG6BG72KAF0S", Models.EADVENTURE_TOURER)
        );
        for (int i = 0; i < vehicles.size(); i++) {
            String actual = vehicles.get(i).toString();
            String expected = vehicleInfos.get(i);
            assertEquals(expected, actual);
        }

    }

    @Test
    void testElectricModelString() {
        Make vehicle = new Make("MCA28BPPBW6PANNEY", Models.ECITY_CRUISER);
        String actual = vehicle.toString();
        String expected = """
            Vehicle Information:
            \tVIN: MCA28BPPBW6PANNEY
            \tVehicle Category: Non-Commercial
            \tNon-Commercial Category: Motorcycle
            \tMotorcycle Details:
            \t\tMake: Harley-Davidson
            \t\tManufacture ID: D88961
            \t\tModel: Electric City Cruiser
            \t\t\tFrame Details:
            \t\t\t\tFrame Type: Cruiser
            \t\t\t\tDescription: A motorcycle designed for long-distance riding with a relaxed riding position.
            \t\t\tEngine Model: LiveWire
            \t\t\t\tEngine Type: Electric
            \t\t\t\tMax Power Output: 105 kW
            \t\t\t\tMotor Type: Direct Current
            \t\t\t\tEngine Warranty Information:
            \t\t\t\t\tWarranty Years: 4
            \t\t\t\t\tWarranty Miles: 30000
            """;
        assertEquals(actual, expected);
    }
}