package autogradertests;

import edu.coolschool.utilities.CountriesEnum;
import edu.coolschool.utilities.PersonInfo;
import edu.coolschool.utilities.dateutils.DateRecord;
import edu.coolschool.utilities.dateutils.MonthsEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PersonInfoTests {

    @Test
    @DisplayName("Build PersonInfo with valid data")
    public void buildPersonInfoWithValidData() {
        DateRecord dob = new DateRecord.Builder()
                .setDay(15)
                .setMonth(MonthsEnum.MARCH)
                .setYear(1990)
                .build();

        PersonInfo person = new PersonInfo.Builder()
                .setFirstName("Alice")
                .setLastName("Smith")
                .setDateOfBirth(dob)
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.GB)
                .build();

        assertEquals("Alice", person.firstName());
        assertEquals("Smith", person.lastName());
        assertEquals(dob, person.dateOfBirth());
        assertEquals(CountriesEnum.US, person.countryOfResidence());
        assertEquals(CountriesEnum.GB, person.countryOfBirth());
    }

    @Test
    @DisplayName("Build PersonInfo with missing required fields")
    public void buildPersonInfoWithMissingFields() {
        DateRecord dob = new DateRecord.Builder()
                .setDay(15)
                .setMonth(MonthsEnum.MARCH)
                .setYear(1990)
                .build();

        assertThrows(IllegalArgumentException.class, () -> {
            new PersonInfo.Builder()
                    .setFirstName("Alice")
                    .setDateOfBirth(dob)
                    .setCountryOfResidence(CountriesEnum.US)
                    .build(); // Missing lastName
        });
    }

    @Test
    @DisplayName("Build PersonInfo with invalid date")
    public void buildPersonInfoWithInvalidDate() {
        assertThrows(IllegalArgumentException.class, () -> {
            new DateRecord.Builder()
                    .setDay(31)
                    .setMonth(MonthsEnum.APRIL)
                    .setYear(2021)
                    .build(); // Invalid date
        });
    }

    @Test
    @DisplayName("Build PersonInfo with invalid country code")
    public void buildPersonInfoWithInvalidCountryCode() {
        DateRecord dob = new DateRecord.Builder()
                .setDay(15)
                .setMonth(MonthsEnum.MARCH)
                .setYear(1990)
                .build();

        assertThrows(IllegalArgumentException.class, () -> {
            new PersonInfo.Builder()
                    .setFirstName("Alice")
                    .setLastName("Smith")
                    .setDateOfBirth(dob)
                    .setCountryOfResidence(CountriesEnum.fromCode("XX")) // Invalid code
                    .setCountryOfBirth(CountriesEnum.GB)
                    .build();
        });
    }


    @Test
    public void testToStringWithoutTab() {
        DateRecord dob = new DateRecord(15, 3, 2024);
        PersonInfo person = new PersonInfo.Builder()
                .setFirstName("John")
                .setMiddleName("Q")
                .setLastName("Public")
                .setDateOfBirth(dob)
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.US)
                .build();

        String expected = "First Name: John\n" +
                "Middle Name: Q\n" +
                "Last Name: Public\n" +
                "Date of Birth: 03/15/2024\n" +
                "Country of Residence: United States of America\n" +
                "Country of Birth: United States of America\n";

        assertEquals(expected, person.toString());
    }

    @Test
    public void testToStringWithOneTab() {
        DateRecord dob = new DateRecord(15, 3, 2024);
        PersonInfo person = new PersonInfo.Builder()
                .setFirstName("John")
                .setMiddleName("Q")
                .setLastName("Public")
                .setDateOfBirth(dob)
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.US)
                .build();

        String indent = "\t";
        String expected = indent + "First Name: John\n" +
                indent + "Middle Name: Q\n" +
                indent + "Last Name: Public\n" +
                indent + "Date of Birth: 03/15/2024\n" +
                indent + "Country of Residence: United States of America\n" +
                indent + "Country of Birth: United States of America\n";

        assertEquals(expected, person.toString(1));
    }
}
