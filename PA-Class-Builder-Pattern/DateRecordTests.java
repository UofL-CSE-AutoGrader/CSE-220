package autogradertests;

import edu.coolschool.utilities.dateutils.DateFormatOptionsEnum;
import edu.coolschool.utilities.dateutils.DateRecord;
import edu.coolschool.utilities.dateutils.MonthsEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DateRecordTests {

    @Test
    @DisplayName("constructs and formats default MM/DD/YYYY correctly")
    public void constructsAndFormatsDefaultMMDDYYYY() {
        DateRecord date = new DateRecord(3, 7, 2021); // day=3, month=7
        assertEquals("07/03/2021", date.toString());
    }

    @Test
    @DisplayName("formats all supported date formats consistently")
    public void formatsAllSupportedDateFormats() {
        DateRecord date = new DateRecord(5, MonthsEnum.MAY, 2010);
        assertEquals("05/005/2010", date.toString(DateFormatOptionsEnum.DD_MM_YYYY));
        assertEquals("05/05/2010", date.toString(DateFormatOptionsEnum.MM_DD_YYYY), "MM_DD and DD_MM coincide for symmetric day/month");
        assertEquals("2010/05/05", date.toString(DateFormatOptionsEnum.YYYY_MM_DD));
        assertEquals("May 05, 2010", date.toString(DateFormatOptionsEnum.MONTH_DD_YYYY));
    }

    @Test
    @DisplayName("rejects invalid calendar dates with IllegalArgumentException")
    public void rejectsInvalidDateThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> new DateRecord(31, 2, 2021));
        assertThrows(IllegalArgumentException.class, () -> new DateRecord(30, MonthsEnum.FEBRUARY, 2019));
        assertThrows(IllegalArgumentException.class, () -> new DateRecord(0, 1, 2020));
        assertThrows(IllegalArgumentException.class, () -> new DateRecord(1, 13, 2020));
    }

    @Test
    @DisplayName("accepts February 29 on leap years and formats with leading zeros")
    public void handlesLeapYearFeb29() {
        DateRecord leap = new DateRecord(29, MonthsEnum.FEBRUARY, 2020);
        assertEquals("02/29/2020", leap.toString());
    }

    @Test
    @DisplayName("builder produces equivalent DateRecord to constructor")
    public void builderProducesSameAsConstructor() {
        DateRecord built = new DateRecord.Builder()
                .setDay(15)
                .setMonth(MonthsEnum.MARCH)
                .setYear(2024)
                .build();

        DateRecord direct = new DateRecord(15, 3, 2024);
        assertEquals(direct.toString(), built.toString());
        assertEquals(direct.toString(DateFormatOptionsEnum.YYYY_MM_DD), built.toString(DateFormatOptionsEnum.YYYY_MM_DD));
    }
}
