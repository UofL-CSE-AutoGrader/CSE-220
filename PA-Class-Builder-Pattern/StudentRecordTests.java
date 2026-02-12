package autogradertests;

import edu.coolschool.students.StudentRecord;
import edu.coolschool.utilities.PersonInfo;
import edu.coolschool.utilities.CountriesEnum;
import edu.coolschool.utilities.dateutils.DateRecord;
import edu.coolschool.utilities.dateutils.MonthsEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class StudentRecordTests {

    @Test
    @DisplayName("Build StudentRecord with valid data including parents")
    public void buildStudentRecordWithValidDataIncludingParents() {
        PersonInfo student = new PersonInfo.Builder()
                .setFirstName("StudentFirst")
                .setLastName("StudentLast")
                .setDateOfBirth(new DateRecord.Builder().setDay(5).setMonth(MonthsEnum.MAY).setYear(2010).build())
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.US)
                .build();

        PersonInfo father = new PersonInfo.Builder()
                .setFirstName("Father")
                .setLastName("Last")
                .setDateOfBirth(new DateRecord.Builder().setDay(1).setMonth(MonthsEnum.JANUARY).setYear(1980).build())
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.US)
                .build();

        PersonInfo mother = new PersonInfo.Builder()
                .setFirstName("Mother")
                .setLastName("Last")
                .setDateOfBirth(new DateRecord.Builder().setDay(2).setMonth(MonthsEnum.FEBRUARY).setYear(1982).build())
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.US)
                .build();

        DateRecord enrollment = new DateRecord.Builder()
                .setDay(1)
                .setMonth(MonthsEnum.SEPTEMBER)
                .setYear(2020)
                .build();

        StudentRecord record = new StudentRecord.Builder()
                .setStudentInfo(student)
                .setStudentID("ABC123456")
                .setFatherInfo(father)
                .setMotherInfo(mother)
                .setEnrollmentDate(enrollment)
                .build();

        assertEquals(student, record.studentInfo());
        assertEquals("ABC123456", record.studentID());
        assertEquals(father, record.fatherInfo());
        assertEquals(mother, record.motherInfo());
        assertEquals(enrollment, record.enrollmentDate());

        String s = record.toString();
        assertTrue(s.contains("Student ID: ABC123456"));
        assertTrue(s.contains("Enrollment Date:"));
        assertTrue(s.contains("Student Information:"));
        assertTrue(s.contains("Father Information:"));
        assertTrue(s.contains("Mother Information:"));
    }

    @Test
    @DisplayName("Missing studentInfo causes IllegalArgumentException")
    public void missingStudentInfoCausesException() {
        DateRecord enrollment = new DateRecord.Builder()
                .setDay(1)
                .setMonth(MonthsEnum.SEPTEMBER)
                .setYear(2020)
                .build();

        assertThrows(IllegalArgumentException.class, () -> {
            new StudentRecord.Builder()
                    .setStudentID("ABC123456")
                    .setEnrollmentDate(enrollment)
                    .build();
        });
    }

    @Test
    @DisplayName("Invalid studentID length causes IllegalArgumentException")
    public void invalidStudentIDLengthCausesException() {
        PersonInfo student = new PersonInfo.Builder()
                .setFirstName("S")
                .setLastName("L")
                .setDateOfBirth(new DateRecord.Builder().setDay(1).setMonth(MonthsEnum.JANUARY).setYear(2010).build())
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.US)
                .build();

        DateRecord enrollment = new DateRecord.Builder()
                .setDay(1)
                .setMonth(MonthsEnum.SEPTEMBER)
                .setYear(2020)
                .build();

        assertThrows(IllegalArgumentException.class, () -> {
            new StudentRecord.Builder()
                    .setStudentInfo(student)
                    .setStudentID("SHORT") // length != 9
                    .setEnrollmentDate(enrollment)
                    .build();
        });
    }

    @Test
    @DisplayName("Null enrollmentDate causes IllegalArgumentException")
    public void nullEnrollmentDateCausesException() {
        PersonInfo student = new PersonInfo.Builder()
                .setFirstName("S")
                .setLastName("L")
                .setDateOfBirth(new DateRecord.Builder().setDay(1).setMonth(MonthsEnum.JANUARY).setYear(2010).build())
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.US)
                .build();

        assertThrows(IllegalArgumentException.class, () -> {
            new StudentRecord.Builder()
                    .setStudentInfo(student)
                    .setStudentID("ABCDEFGHI")
                    .setEnrollmentDate(null)
                    .build();
        });
    }

    @Test
    @DisplayName("Father and mother info can be omitted")
    public void fatherAndMotherInfoCanBeOmitted() {
        PersonInfo student = new PersonInfo.Builder()
                .setFirstName("Solo")
                .setLastName("Child")
                .setDateOfBirth(new DateRecord.Builder().setDay(3).setMonth(MonthsEnum.MARCH).setYear(2012).build())
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.US)
                .build();

        DateRecord enrollment = new DateRecord.Builder()
                .setDay(1)
                .setMonth(MonthsEnum.SEPTEMBER)
                .setYear(2021)
                .build();

        StudentRecord record = new StudentRecord.Builder()
                .setStudentInfo(student)
                .setStudentID("123456789")
                .setEnrollmentDate(enrollment)
                .build();

        assertNull(record.fatherInfo());
        assertNull(record.motherInfo());
        String s = record.toString();
        assertFalse(s.contains("Father Information:"));
        assertFalse(s.contains("Mother Information:"));
    }

    @Test
    @DisplayName("StudentRecord toString formatting with and without tab")
    public void studentRecordToStringFormatting() {
        PersonInfo student = new PersonInfo.Builder()
                .setFirstName("StudentFirst")
                .setLastName("StudentLast")
                .setDateOfBirth(new DateRecord.Builder().setDay(5).setMonth(MonthsEnum.MAY).setYear(2010).build())
                .setCountryOfResidence(CountriesEnum.US)
                .setCountryOfBirth(CountriesEnum.US)
                .build();

        DateRecord enrollment = new DateRecord.Builder()
                .setDay(1)
                .setMonth(MonthsEnum.SEPTEMBER)
                .setYear(2020)
                .build();

        StudentRecord record = new StudentRecord.Builder()
                .setStudentInfo(student)
                .setStudentID("ABC123456")
                .setEnrollmentDate(enrollment)
                .build();

        String expectedNoTab = ""
                + "Student ID: ABC123456\n"
                + "\tEnrollment Date: 09/01/2020\n"
                + "\tStudent Information:\n"
                + "\t\tFirst Name: StudentFirst\n"
                + "\t\tLast Name: StudentLast\n"
                + "\t\tDate of Birth: 05/05/2010\n"
                + "\t\tCountry of Residence: United States of America\n"
                + "\t\tCountry of Birth: United States of America\n"
                + "\n";

        assertEquals(expectedNoTab, record.toString());

        String expectedWithTab = ""
                + "\tStudent ID: ABC123456\n"
                + "\t\tEnrollment Date: 09/01/2020\n"
                + "\t\tStudent Information:\n"
                + "\t\t\tFirst Name: StudentFirst\n"
                + "\t\t\tLast Name: StudentLast\n"
                + "\t\t\tDate of Birth: 05/05/2010\n"
                + "\t\t\tCountry of Residence: United States of America\n"
                + "\t\t\tCountry of Birth: United States of America\n"
                + "\n";

        assertEquals(expectedWithTab, record.toString(1));
    }
}
