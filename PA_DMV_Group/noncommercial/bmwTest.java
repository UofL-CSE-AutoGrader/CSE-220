package noncommercial;

import io.github.nathanjrussell.vehicles.Vehicle;
import io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.Constants;
import io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.Make;
import io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.engines.CombustionEngine;
import io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.engines.enums.CombustionEngines;
import io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.engines.enums.ElectricEngines;
import io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.enums.Frames;
import io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.enums.Models;
import io.github.nathanjrussell.vehicles.engines.interfaces.IEngine;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class bmwTest {
    private enum combustionEngines {
        TWIN_POWER_TURBO_125KW("TwinPower Turbo 125kW", 170, 2, 999),
        TWIN_POWER_TURBO_100KW("TwinPower Turbo 100kW", 136, 2, 853),
        BOXER_TWIN_81KW("Boxer Twin 81kW", 110, 2, 1170),
        BOXER_TWIN_70KW("Boxer Twin 70kW", 95, 2, 1170),
        SINGLE_CYLINDER_44KW("Single Cylinder 44kW", 60, 1, 313),
        KATANA_1000CC("Katana 1000cc", 150, 4, 999)
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
        ELECTRIC_31KW("Electric 31kW Motor", 31)
        ;
        private final String engineModel;
        private final int maxPowerOutput;

        electricEngines(String engineModel, int maxPowerOutput) {
            this.engineModel = engineModel;
            this.maxPowerOutput = maxPowerOutput;
        }
    }

    private enum frames {
        GSXS("GSX-S", "A sport-oriented frame designed for agility and performance on paved roads."),
        GSXR("GSX-R", "A high-performance frame built for racing and aggressive riding styles."),
        S1000RR("S1000RR", "A superbike frame engineered for maximum speed and precision handling."),
        R1250GS("R1250GS", "An adventure-touring frame suitable for both on-road and off-road riding."),
        F900XR("F900XR", "A versatile frame designed for sporty touring and everyday riding.")
        ;
        private final String frameType;
        private final String frameDesc;
        frames(String frameType, String frameDesc) {
            this.frameType = frameType;
            this.frameDesc = frameDesc;
        }
    }

    private enum models {
        R1250GS("R1250GS", io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.engines.enums.CombustionEngines.BOXER_TWIN_70KW, io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.enums.Frames.F900XR),
        S1000RR("S1000RR", io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.engines.enums.CombustionEngines.TWIN_POWER_TURBO_125KW, io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.enums.Frames.S1000RR),
        F900XR("F900XR", io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.engines.enums.CombustionEngines.TWIN_POWER_TURBO_100KW, io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.enums.Frames.F900XR),
        G310GS("G310GS", io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.engines.enums.CombustionEngines.SINGLE_CYLINDER_44KW, io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.enums.Frames.R1250GS),
        C400X("C400X", io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.engines.enums.ElectricEngines.ELECTRIC_31KW, io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.enums.Frames.F900XR),
        C400GT("C400GT", io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.engines.enums.ElectricEngines.ELECTRIC_31KW, io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.enums.Frames.F900XR)
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
        assertEquals(4, io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.Constants.ELECTRIC_MOTOR_WARRANTY_YEARS);
    }

    @Test
    void electricMotorWarrantyMilesIsCorrect() {
        assertEquals(30000, io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.Constants.ELECTRIC_MOTOR_WARRANTY_MILES);
    }

    @Test
    void combustionEngineWarrantyYearsIsCorrect() {
        assertEquals(2, io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.Constants.COMBUSTION_ENGINE_WARRANTY_YEARS);
    }

    @Test
    void combustionEngineWarrantyMilesIsCorrect() {
        assertEquals(24000, io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.Constants.COMBUSTION_ENGINE_WARRANTY_MILES);
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
        io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.engines.ElectricEngine engine =
                new io.github.nathanjrussell.vehicles.categories.noncommercial.motorcycle.makes.bmw.engines.ElectricEngine(power);
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

    String generateRandomVIN(Random random) {
        StringBuilder vin = new StringBuilder();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        for (int i = 0; i < 17; i++) {
            vin.append(chars.charAt(random.nextInt(chars.length())));
        }
        return vin.toString();
    }

    @Test
    void testCombustionModels() {
        Random random = new Random();
        List<Vehicle> vehicles = List.of(
                new Make("26KPSHVRRGC3D8ELL", Models.R1250GS),
                new Make("BHMVR4J6C1NVM27J3", Models.S1000RR),
                new Make("P6TNDSNHXJC492AP2", Models.F900XR),
                new Make("7VVHV1VB7RY6WZHCZ", Models.G310GS)
        );
        List<String> vehicleInfos = List.of(
                """
                Vehicle Information:
                \tVIN: 26KPSHVRRGC3D8ELL
                \tVehicle Category: Non-Commercial
                \tNon-Commercial Category: Motorcycle
                \tMotorcycle Details:
                \t\tMake: BMW
                \t\tManufacture ID: E99072
                \t\tModel: R1250GS
                \t\t\tFrame Details:
                \t\t\t\tFrame Type: F900XR
                \t\t\t\tDescription: A versatile frame designed for sporty touring and everyday riding.
                \t\t\tEngine Model: Boxer Twin 70kW
                \t\t\t\tEngine Type: Combustion
                \t\t\t\tMax Power Output: 95 HP
                \t\t\t\tFuel Type: Gasoline
                \t\t\t\tNumber of Cylinders: 2
                \t\t\t\tDisplacement: 1170.0 CC
                \t\t\t\tEngine Warranty Information:
                \t\t\t\t\tWarranty Years: 2
                \t\t\t\t\tWarranty Miles: 24000
                """,
                """
                Vehicle Information:
                \tVIN: BHMVR4J6C1NVM27J3
                \tVehicle Category: Non-Commercial
                \tNon-Commercial Category: Motorcycle
                \tMotorcycle Details:
                \t\tMake: BMW
                \t\tManufacture ID: E99072
                \t\tModel: S1000RR
                \t\t\tFrame Details:
                \t\t\t\tFrame Type: S1000RR
                \t\t\t\tDescription: A superbike frame engineered for maximum speed and precision handling.
                \t\t\tEngine Model: TwinPower Turbo 125kW
                \t\t\t\tEngine Type: Combustion
                \t\t\t\tMax Power Output: 170 HP
                \t\t\t\tFuel Type: Gasoline
                \t\t\t\tNumber of Cylinders: 2
                \t\t\t\tDisplacement: 999.0 CC
                \t\t\t\tEngine Warranty Information:
                \t\t\t\t\tWarranty Years: 2
                \t\t\t\t\tWarranty Miles: 24000
                """,
                """
                Vehicle Information:
                \tVIN: P6TNDSNHXJC492AP2
                \tVehicle Category: Non-Commercial
                \tNon-Commercial Category: Motorcycle
                \tMotorcycle Details:
                \t\tMake: BMW
                \t\tManufacture ID: E99072
                \t\tModel: F900XR
                \t\t\tFrame Details:
                \t\t\t\tFrame Type: F900XR
                \t\t\t\tDescription: A versatile frame designed for sporty touring and everyday riding.
                \t\t\tEngine Model: TwinPower Turbo 100kW
                \t\t\t\tEngine Type: Combustion
                \t\t\t\tMax Power Output: 136 HP
                \t\t\t\tFuel Type: Gasoline
                \t\t\t\tNumber of Cylinders: 2
                \t\t\t\tDisplacement: 853.0 CC
                \t\t\t\tEngine Warranty Information:
                \t\t\t\t\tWarranty Years: 2
                \t\t\t\t\tWarranty Miles: 24000
                """,
                """
                Vehicle Information:
                \tVIN: 7VVHV1VB7RY6WZHCZ
                \tVehicle Category: Non-Commercial
                \tNon-Commercial Category: Motorcycle
                \tMotorcycle Details:
                \t\tMake: BMW
                \t\tManufacture ID: E99072
                \t\tModel: G310GS
                \t\t\tFrame Details:
                \t\t\t\tFrame Type: R1250GS
                \t\t\t\tDescription: An adventure-touring frame suitable for both on-road and off-road riding.
                \t\t\tEngine Model: Single Cylinder 44kW
                \t\t\t\tEngine Type: Combustion
                \t\t\t\tMax Power Output: 60 HP
                \t\t\t\tFuel Type: Gasoline
                \t\t\t\tNumber of Cylinders: 1
                \t\t\t\tDisplacement: 313.0 CC
                \t\t\t\tEngine Warranty Information:
                \t\t\t\t\tWarranty Years: 2
                \t\t\t\t\tWarranty Miles: 24000
                """
        );

        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle vehicle = vehicles.get(i);
            String expectedInfo = vehicle.toString();
            assertEquals(vehicleInfos.get(i).trim(), expectedInfo.trim());

        }
    }

    @Test
    void testElectricModelString() {
        Vehicle vehicle = new Make("MCA28BPP123PANNEY", Models.C400GT);
        String actual = vehicle.toString();
        String expected = """
            Vehicle Information:
            \tVIN: MCA28BPP123PANNEY
            \tVehicle Category: Non-Commercial
            \tNon-Commercial Category: Motorcycle
            \tMotorcycle Details:
            \t\tMake: BMW
            \t\tManufacture ID: E99072
            \t\tModel: C400GT
            \t\t\tFrame Details:
            \t\t\t\tFrame Type: F900XR
            \t\t\t\tDescription: A versatile frame designed for sporty touring and everyday riding.
            \t\t\tEngine Model: Electric 31kW Motor
            \t\t\t\tEngine Type: Electric
            \t\t\t\tMax Power Output: 31 kW
            \t\t\t\tMotor Type: Direct Current
            \t\t\t\tEngine Warranty Information:
            \t\t\t\t\tWarranty Years: 4
            \t\t\t\t\tWarranty Miles: 30000
            """;

        assertEquals(actual, expected);
    }
}