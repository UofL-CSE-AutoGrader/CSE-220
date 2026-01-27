package autogradertests;


import org.example.university.enums.TermEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TermEnumTest {

    @Test
    @DisplayName("fromString returns correct enum for valid terms")
    void fromStringReturnsCorrectEnumForValidTerms() {
        assertEquals(TermEnum.FALL, TermEnum.fromString("FALL"));
        assertEquals(TermEnum.SPRING, TermEnum.fromString("SPRING"));
        assertEquals(TermEnum.SUMMER, TermEnum.fromString("SUmmER"));
        assertEquals(TermEnum.WINTER, TermEnum.fromString("WINTER"));
        assertEquals(TermEnum.FALL, TermEnum.fromString("fall"));
        assertEquals(TermEnum.SPRING, TermEnum.fromString("spring"));
        assertEquals(TermEnum.SUMMER, TermEnum.fromString("sUmmer"));
        assertEquals(TermEnum.WINTER, TermEnum.fromString("winter"));
    }

    @Test
    @DisplayName("fromString throws exception for invalid terms")
    void fromStringThrowsExceptionForInvalidTerms() {
        assertThrows(IllegalArgumentException.class, () -> TermEnum.fromString("AUTUMN"));
        assertThrows(IllegalArgumentException.class, () -> TermEnum.fromString(""));
        assertThrows(IllegalArgumentException.class, () -> TermEnum.fromString("   "));
        assertThrows(IllegalArgumentException.class, () -> TermEnum.fromString("UNKNOWN"));
        assertThrows(NullPointerException.class, () -> TermEnum.fromString(null));
    }

    @Test
    @DisplayName("toString returns correct title case for each term")
    void toStringReturnsCorrectTitleCaseForEachTerm() {
        assertEquals("Fall", TermEnum.FALL.toString());
        assertEquals("Spring", TermEnum.SPRING.toString());
        assertEquals("Summer", TermEnum.SUMMER.toString());
        assertEquals("Winter", TermEnum.WINTER.toString());
    }
}
