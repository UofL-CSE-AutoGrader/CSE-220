package autogradertests;


import org.example.university.enums.DepartmentCodeEnum;
import org.example.university.enums.MonthsEnum;
import org.example.university.enums.TermEnum;
import org.example.university.records.CourseRecord;
import org.example.university.records.StudentRecord;
import org.example.university.records.StudentSemesterRecord;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentRecordTest {

    @Test
    void constructorThrowsExceptionForNullOrBlankFirstName() {
        assertThrows(IllegalArgumentException.class, () -> new StudentRecord(null, "Doe", "12345", 2020, 2000, MonthsEnum.JANUARY, 15, false, null));
        assertThrows(IllegalArgumentException.class, () -> new StudentRecord("", "Doe", "12345", 2020, 2000, MonthsEnum.JANUARY, 15, false, null));
        assertThrows(IllegalArgumentException.class, () -> new StudentRecord("   ", "Doe", "12345", 2020, 2000, MonthsEnum.JANUARY, 15, false, null));
    }

    @Test
    void constructorThrowsExceptionForNullOrBlankLastName() {
        assertThrows(IllegalArgumentException.class, () -> new StudentRecord("John", null, "12345", 2020, 2000, MonthsEnum.JANUARY, 15, false, null));
        assertThrows(IllegalArgumentException.class, () -> new StudentRecord("John", "", "12345", 2020, 2000, MonthsEnum.JANUARY, 15, false, null));
        assertThrows(IllegalArgumentException.class, () -> new StudentRecord("John", "   ", "12345", 2020, 2000, MonthsEnum.JANUARY, 15, false, null));
    }

    @Test
    void constructorThrowsExceptionForInvalidEnrollmentYear() {
        assertThrows(IllegalArgumentException.class, () -> new StudentRecord("John", "Doe", "12345", 1800, 2000, MonthsEnum.JANUARY, 15, false, null));
        assertThrows(IllegalArgumentException.class, () -> new StudentRecord("John", "Doe", "12345", 2200, 2000, MonthsEnum.JANUARY, 15, false, null));
    }

    @Test
    void constructorThrowsExceptionForInvalidBirthYear() {
        assertThrows(IllegalArgumentException.class, () -> new StudentRecord("John", "Doe", "12345", 2020, 1800, MonthsEnum.JANUARY, 15, false, null));
        assertThrows(IllegalArgumentException.class, () -> new StudentRecord("John", "Doe", "12345", 2020, 2200, MonthsEnum.JANUARY, 15, false, null));
    }

    @Test
    void constructorThrowsExceptionForInvalidBirthDay() {
        assertThrows(IllegalArgumentException.class, () -> new StudentRecord("John", "Doe", "12345", 2020, 2000, MonthsEnum.JANUARY, 0, false, null));
        assertThrows(IllegalArgumentException.class, () -> new StudentRecord("John", "Doe", "12345", 2020, 2000, MonthsEnum.JANUARY, 32, false, null));
    }

    @Test
    void constructorThrowsExceptionForInvalidFebruaryDayInNonLeapYear() {
        assertThrows(IllegalArgumentException.class, () -> new StudentRecord("John", "Doe", "12345", 2020, 2001, MonthsEnum.FEBRUARY, 29, false, null));
    }

    @Test
    void constructorThrowsExceptionForInvalidFebruaryDayInLeapYear() {
        assertThrows(IllegalArgumentException.class, () -> new StudentRecord("John", "Doe", "12345", 2020, 2000, MonthsEnum.FEBRUARY, 30, false, null));
    }

    @Test
    void constructorThrowsExceptionForInvalidThirtyDayMonth() {
        assertThrows(IllegalArgumentException.class, () -> new StudentRecord("John", "Doe", "12345", 2020, 2000, MonthsEnum.APRIL, 31, false, null));
    }

    @Test
    void addSemesterAddsSemesterToSemestersList() {
        StudentRecord record = new StudentRecord("John", "Doe", "12345", 2020, 2000, MonthsEnum.JANUARY, 15, false, null);
        StudentSemesterRecord semester = new StudentSemesterRecord(TermEnum.FALL, 2023, null);
        record.addSemester(semester);
        assertEquals(1, record.semesters().size());
        assertTrue(record.semesters().contains(semester));
    }

    @Test
    void toStringReturnsFormattedStringWithoutIndentation() {
        StudentRecord record = new StudentRecord("John", "Doe", "12345", 2020, 2000, MonthsEnum.JANUARY, 15, false, null);
        String expected = "Student:\n" +
                "\tFirst Name: John\n" +
                "\tLast Name: Doe\n" +
                "\tStudent ID: 12345\n" +
                "\tEnrollment Year: 2020\n" +
                "\tBirth Date: January 15, 2000\n" +
                "\tHas Graduated: No\n" +
                "\tTranscript Courses:\n";
        assertEquals(expected, record.toString());
    }

    @Test
    void toJSONReturnsFormattedJSONStringWithoutIndentation() {
        StudentRecord record = new StudentRecord("John", "Doe", "12345", 2020, 2000, MonthsEnum.JANUARY, 15, false, null);
        String expected = "{\n" +
                "\t\"firstName\": \"John\",\n" +
                "\t\"lastName\": \"Doe\",\n" +
                "\t\"studentID\": \"12345\",\n" +
                "\t\"enrollmentYear\": 2020,\n" +
                "\t\"birthYear\": 2000,\n" +
                "\t\"birthMonth\": \"January\",\n" +
                "\t\"birthDay\": 15,\n" +
                "\t\"hasGraduated\": false,\n" +
                "\t\"semesters\": []\n" +
                "}";
        assertEquals(expected, record.toJSON(0));
    }

    @Test
    void createSampleStudentWithSemestersProducesStudentWithExpectedPropertiesAndSemesters() {
        StudentRecord student = createSampleStudentWithSemesters();
        assertEquals("Alice", student.firstName());
        assertEquals("Smith", student.lastName());
        assertEquals("S123456", student.studentID());
        assertEquals(2020, student.enrollmentYear());
        assertEquals(2002, student.birthYear());
        assertEquals(MonthsEnum.MARCH, student.birthMonth());
        assertEquals(15, student.birthDay());
        assertEquals(TermEnum.FALL, student.semesters().get(0).term());
        assertEquals(2020, student.semesters().get(0).year());
        assertFalse(student.hasGraduated());
        assertNotNull(student.semesters());
        assertEquals(2, student.semesters().size());
    }

    @Test
    void createSampleStudentSemestersContainExpectedCoursesWithCorrectProperties() {
        StudentRecord student = createSampleStudentWithSemesters();
        assertFalse(student.semesters().isEmpty());

        StudentSemesterRecord firstSemester = student.semesters().get(0);
        boolean foundCse101 = firstSemester.courses().stream()
                .anyMatch(c -> c.departmentCode() == DepartmentCodeEnum.CSE && c.courseNumber() == 101);
        assertTrue(foundCse101);

        StudentSemesterRecord secondSemester = student.semesters().get(1);
        boolean foundCse201 = secondSemester.courses().stream()
                .anyMatch(c -> c.departmentCode() == DepartmentCodeEnum.CSE && c.courseNumber() == 201);
        boolean foundEce150 = secondSemester.courses().stream()
                .anyMatch(c -> c.departmentCode() == DepartmentCodeEnum.ECE && c.courseNumber() == 150);
        assertTrue(foundCse201);
        assertTrue(foundEce150);
    }

    @Test
    void studentSemesterRecordConstructorInitializesEmptyCoursesListWhenNullProvided() {
        StudentSemesterRecord record = new StudentSemesterRecord(TermEnum.FALL, 2023, null);
        assertNotNull(record.courses());
        assertTrue(record.courses().isEmpty());
    }

    @Test
    void studentSemesterAddCourseAddsCourseToCoursesList() {
        StudentSemesterRecord record = new StudentSemesterRecord(TermEnum.FALL, 2023, null);
        CourseRecord course = new CourseRecord("Intro to CS", DepartmentCodeEnum.CSE, 101, 3, "John", "Doe");
        record.addCourse(course);
        assertEquals(1, record.courses().size());
        assertTrue(record.courses().contains(course));
    }

    private static StudentRecord createSampleStudentWithSemesters() {
        StudentRecord student = new StudentRecord(
                "Alice",
                "Smith",
                "S123456",
                2020,
                2002,
                MonthsEnum.MARCH,
                15,
                false,
                null
        );

        CourseRecord cs101 = new CourseRecord("Intro to CS", DepartmentCodeEnum.CSE, 101, 3, "John", "Doe");
        CourseRecord ds201 = new CourseRecord("Data Structures", DepartmentCodeEnum.CSE, 201, 4, "Jane", "Roe");
        CourseRecord ece150 = new CourseRecord("Circuits I", DepartmentCodeEnum.ECE, 150, 3, "Eve", "Adams");
        CourseRecord math210 = new CourseRecord("Calculus II", DepartmentCodeEnum.MATH, 210, 4, "Bob", "Brown");

        StudentSemesterRecord fall2020 = new StudentSemesterRecord(TermEnum.FALL, 2020, List.of(cs101, math210));
        StudentSemesterRecord spring2021 = new StudentSemesterRecord(TermEnum.SPRING, 2021, List.of(ds201, ece150));

        student.addSemester(fall2020);
        student.addSemester(spring2021);

        return student;
    }
}
