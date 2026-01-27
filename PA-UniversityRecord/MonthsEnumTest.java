// java
package autogradertests;

import org.example.university.enums.MonthsEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MonthsEnumTest {

    @Test
    @DisplayName("fromInt returns correct month for valid input")
    void fromIntReturnsCorrectMonthForValidInput() {
        assertEquals(MonthsEnum.JANUARY, MonthsEnum.fromInt(1));
        assertEquals(MonthsEnum.FEBRUARY, MonthsEnum.fromInt(2));
        assertEquals(MonthsEnum.MARCH, MonthsEnum.fromInt(3));
        assertEquals(MonthsEnum.APRIL, MonthsEnum.fromInt(4));
        assertEquals(MonthsEnum.MAY, MonthsEnum.fromInt(5));
        assertEquals(MonthsEnum.JUNE, MonthsEnum.fromInt(6));
        assertEquals(MonthsEnum.JULY, MonthsEnum.fromInt(7));
        assertEquals(MonthsEnum.AUGUST, MonthsEnum.fromInt(8));
        assertEquals(MonthsEnum.SEPTEMBER, MonthsEnum.fromInt(9));
        assertEquals(MonthsEnum.OCTOBER, MonthsEnum.fromInt(10));
        assertEquals(MonthsEnum.NOVEMBER, MonthsEnum.fromInt(11));
        assertEquals(MonthsEnum.DECEMBER, MonthsEnum.fromInt(12));
    }

    @Test
    @DisplayName("fromInt throws exception for invalid input")
    void fromIntThrowsExceptionForInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> MonthsEnum.fromInt(0));
        assertThrows(IllegalArgumentException.class, () -> MonthsEnum.fromInt(13));
    }

    @Test
    @DisplayName("fromString returns correct month for valid input")
    void fromStringReturnsCorrectMonthForValidInput() {
        assertEquals(MonthsEnum.JANUARY, MonthsEnum.fromString("January"));
        assertEquals(MonthsEnum.FEBRUARY, MonthsEnum.fromString("February"));
        assertEquals(MonthsEnum.MARCH, MonthsEnum.fromString("March"));
        assertEquals(MonthsEnum.APRIL, MonthsEnum.fromString("April"));
        assertEquals(MonthsEnum.MAY, MonthsEnum.fromString("May"));
        assertEquals(MonthsEnum.JUNE, MonthsEnum.fromString("June"));
        assertEquals(MonthsEnum.JULY, MonthsEnum.fromString("July"));
        assertEquals(MonthsEnum.AUGUST, MonthsEnum.fromString("August"));
        assertEquals(MonthsEnum.SEPTEMBER, MonthsEnum.fromString("September"));
        assertEquals(MonthsEnum.OCTOBER, MonthsEnum.fromString("October"));
        assertEquals(MonthsEnum.NOVEMBER, MonthsEnum.fromString("November"));
        assertEquals(MonthsEnum.DECEMBER, MonthsEnum.fromString("December"));
    }

    @Test
    @DisplayName("fromString throws exception for invalid input")
    void fromStringThrowsExceptionForInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> MonthsEnum.fromString("InvalidMonth"));
        assertThrows(IllegalArgumentException.class, () -> MonthsEnum.fromString(""));
    }

    @Test
    @DisplayName("toString returns correct string representation")
    void toStringReturnsCorrectStringRepresentation() {
        assertEquals("January", MonthsEnum.JANUARY.toString());
        assertEquals("February", MonthsEnum.FEBRUARY.toString());
        assertEquals("March", MonthsEnum.MARCH.toString());
        assertEquals("April", MonthsEnum.APRIL.toString());
        assertEquals("May", MonthsEnum.MAY.toString());
        assertEquals("June", MonthsEnum.JUNE.toString());
        assertEquals("July", MonthsEnum.JULY.toString());
        assertEquals("August", MonthsEnum.AUGUST.toString());
        assertEquals("September", MonthsEnum.SEPTEMBER.toString());
        assertEquals("October", MonthsEnum.OCTOBER.toString());
        assertEquals("November", MonthsEnum.NOVEMBER.toString());
        assertEquals("December", MonthsEnum.DECEMBER.toString());
    }
}
