package autogradertests;


import org.example.university.enums.DepartmentCodeEnum;
import org.example.university.records.CourseRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseRecordTest {

    @Test
    @DisplayName("Constructor throws exception for null or blank course name")
    void constructorThrowsExceptionForNullOrBlankCourseName() {
        assertThrows(IllegalArgumentException.class, () -> new CourseRecord(null, DepartmentCodeEnum.CSE, 101, 3, "John", "Doe"));
        assertThrows(IllegalArgumentException.class, () -> new CourseRecord("", DepartmentCodeEnum.CSE, 101, 3, "John", "Doe"));
        assertThrows(IllegalArgumentException.class, () -> new CourseRecord("   ", DepartmentCodeEnum.CSE, 101, 3, "John", "Doe"));
    }

    @Test
    @DisplayName("Constructor throws exception for invalid course number")
    void constructorThrowsExceptionForInvalidCourseNumber() {
        assertThrows(IllegalArgumentException.class, () -> new CourseRecord("Intro to CS", DepartmentCodeEnum.CSE, 0, 3, "John", "Doe"));
        assertThrows(IllegalArgumentException.class, () -> new CourseRecord("Intro to CS", DepartmentCodeEnum.CSE, -1, 3, "John", "Doe"));
        assertThrows(IllegalArgumentException.class, () -> new CourseRecord("Intro to CS", DepartmentCodeEnum.CSE, 10000, 3, "John", "Doe"));
    }

    @Test
    @DisplayName("Constructor throws exception for invalid credits hours")
    void constructorThrowsExceptionForInvalidCreditsHours() {
        assertThrows(IllegalArgumentException.class, () -> new CourseRecord("Intro to CS", DepartmentCodeEnum.CSE, 101, 0, "John", "Doe"));
        assertThrows(IllegalArgumentException.class, () -> new CourseRecord("Intro to CS", DepartmentCodeEnum.CSE, 101, -1, "John", "Doe"));
        assertThrows(IllegalArgumentException.class, () -> new CourseRecord("Intro to CS", DepartmentCodeEnum.CSE, 101, 7, "John", "Doe"));
    }

    @Test
    @DisplayName("Constructor throws exception for null or blank instructor first name")
    void constructorThrowsExceptionForNullOrBlankInstructorFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new CourseRecord("Intro to CS", DepartmentCodeEnum.CSE, 101, 3, null, "Doe"));
        assertThrows(IllegalArgumentException.class, () -> new CourseRecord("Intro to CS", DepartmentCodeEnum.CSE, 101, 3, "", "Doe"));
        assertThrows(IllegalArgumentException.class, () -> new CourseRecord("Intro to CS", DepartmentCodeEnum.CSE, 101, 3, "   ", "Doe"));
    }

    @Test
    @DisplayName("Constructor throws exception for null or blank instructor last name")
    void constructorThrowsExceptionForNullOrBlankInstructorLastName() {
        assertThrows(IllegalArgumentException.class, () -> new CourseRecord("Intro to CS", DepartmentCodeEnum.CSE, 101, 3, "John", null));
        assertThrows(IllegalArgumentException.class, () -> new CourseRecord("Intro to CS", DepartmentCodeEnum.CSE, 101, 3, "John", ""));
        assertThrows(IllegalArgumentException.class, () -> new CourseRecord("Intro to CS", DepartmentCodeEnum.CSE, 101, 3, "John", "   "));
    }

    @Test
    @DisplayName("toString returns formatted string without indentation")
    void toStringReturnsFormattedStringWithoutIndentation() {
        CourseRecord course = new CourseRecord("Intro to CS", DepartmentCodeEnum.CSE, 101, 3, "John", "Doe");
        String expected = "Course Information:\n" +
                "\tCourse Name: Intro to CS\n" +
                "\tDepartment sCode: CSE\n" +
                "\tCourse Number: 101\n" +
                "\tCredits Hours: 3\n" +
                "\tInstructor: John Doe\n";
        assertEquals(expected, course.toString());
    }

    @Test
    @DisplayName("toString returns formatted string with indentation")
    void toStringReturnsFormattedStringWithIndentation() {
        CourseRecord course = new CourseRecord("Intro to CS", DepartmentCodeEnum.CSE, 101, 3, "John", "Doe");
        String expected = "\tCourse Information:\n" +
                "\t\tCourse Name: Intro to CS\n" +
                "\t\tDepartment Code: CSE\n" +
                "\t\tCourse Number: 101\n" +
                "\t\tCredits Hours: 3\n" +
                "\t\tInstructor: John Doe\n";
        assertEquals(expected, course.toString(1));
    }

    @Test
    @DisplayName("toJSON returns formatted JSON string with indentation")
    void toJSONReturnsFormattedJSONStringWithIndentation() {
        CourseRecord course = new CourseRecord("Intro to CS", DepartmentCodeEnum.CSE, 101, 3, "John", "Doe");
        String expected = "\t{\n" +
                "\t\t\"courseName\": \"Intro to CS\",\n" +
                "\t\t\"departmentCode\": \"CSE\",\n" +
                "\t\t\"courseNumber\": 101,\n" +
                "\t\t\"creditsHours\": 3,\n" +
                "\t\t\"instructorFirstName\": \"John\",\n" +
                "\t\t\"instructorLastName\": \"Doe\"\n" +
                "\t}";
        assertEquals(expected, course.toJSON(1));
    }

    @Test
    @DisplayName("toJSON returns formatted JSON string without indentation")
    void toJSONReturnsFormattedJSONStringWithoutIndentation() {
        CourseRecord course = new CourseRecord("Intro to CS", DepartmentCodeEnum.CSE, 101, 3, "John", "Doe");
        String expected = "{\n" +
                "\t\"courseName\": \"Intro to CS\",\n" +
                "\t\"departmentCode\": \"CSE\",\n" +
                "\t\"courseNumber\": 101,\n" +
                "\t\"creditsHours\": 3,\n" +
                "\t\"instructorFirstName\": \"John\",\n" +
                "\t\"instructorLastName\": \"Doe\"\n" +
                "}";
        assertEquals(expected, course.toJSON(0));
    }

    @Test
    @DisplayName("Verify getter names and values")
    void verifyGetterNamesAndValues() {
        CourseRecord course = new CourseRecord("Intro to CS", DepartmentCodeEnum.CSE, 101, 3, "John", "Doe");
        assertEquals("Intro to CS", course.courseName());
        assertEquals(DepartmentCodeEnum.CSE, course.departmentCode());
        assertEquals(101, course.courseNumber());
        assertEquals(3, course.creditsHours());
        assertEquals("John", course.instructorFirstName());
        assertEquals("Doe", course.instructorLastName());
    }
}
