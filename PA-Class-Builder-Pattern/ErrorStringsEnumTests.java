package autogradertests;

import edu.coolschool.utilities.ErrorStrings;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ErrorStringsEnumTests {

    @Test
    @DisplayName("All enum constants present with expected messages")
    public void allEnumConstantsPresentWithExpectedMessages() {
        assertEquals(10, ErrorStrings.values().length);

        assertEquals("First name cannot be null or blank. Please provide a valid first name.",
                ErrorStrings.FIRST_NAME_BLANK.getMessage());

        assertEquals("Last name cannot be null or blank. Please provide a valid last name.",
                ErrorStrings.LAST_NAME_BLANK.getMessage());

        assertEquals("Date cannot be null. Please provide a valid date.",
                ErrorStrings.NULL_DATE.getMessage());

        assertEquals("Country cannot be null. Please provide a valid country.",
                ErrorStrings.NULL_COUNTRY.getMessage());

        assertEquals("Country of birth cannot be null. Please provide a valid country of birth.",
                ErrorStrings.NULL_COUNTRY_OF_BIRTH.getMessage());

        assertEquals("The date provided is not valid. Please enter a valid date.",
                ErrorStrings.INVALID_DATE.getMessage());

        assertEquals("Student information cannot be null. Please provide valid student information.",
                ErrorStrings.NULL_STUDENT_INFO.getMessage());

        assertEquals("Student ID must be exactly 9 characters long and cannot be null or blank. Please provide a valid student ID.",
                ErrorStrings.INVALID_STUDENT_ID.getMessage());

        assertEquals("Enrollment date cannot be null. Please provide a valid enrollment date.",
                ErrorStrings.NULL_ENROLLMENT_DATE.getMessage());

        assertEquals("The country provided is not recognized. Please contact support for assistance.",
                ErrorStrings.UNKNOWN_COUNTRY.getMessage());
    }

    @Test
    @DisplayName("toString returns same value as getMessage and messages are non-empty")
    public void toStringReturnsSameValueAsGetMessageAndMessagesAreNonEmpty() {
        for (ErrorStrings e : ErrorStrings.values()) {
            assertNotNull(e.getMessage());
            assertFalse(e.getMessage().isBlank());
            assertEquals(e.getMessage(), e.toString());
        }
    }
}
