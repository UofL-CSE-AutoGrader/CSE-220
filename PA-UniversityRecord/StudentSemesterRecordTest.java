package autogradertests;


import org.example.university.enums.DepartmentCodeEnum;
import org.example.university.enums.TermEnum;
import org.example.university.records.CourseRecord;
import org.example.university.records.StudentSemesterRecord;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudentSemesterRecordTest {

    private CourseRecord createSampleCourse() {
        return new CourseRecord("Intro to CS", DepartmentCodeEnum.CSE, 101, 3, "John", "Doe");
    }

    @Test
    void constructorInitializesEmptyCoursesListWhenNullProvided() {
        StudentSemesterRecord record = new StudentSemesterRecord(TermEnum.FALL, 2023, null);
        assertNotNull(record.courses());
        assertTrue(record.courses().isEmpty());
    }

    @Test
    void addCourseAddsCourseToCoursesList() {
        StudentSemesterRecord record = new StudentSemesterRecord(TermEnum.FALL, 2023, null);
        CourseRecord course = createSampleCourse();
        assertEquals(101, course.courseNumber());
        record.addCourse(course);
        assertEquals(1, record.courses().size());
        assertTrue(record.courses().contains(course));
    }

    @Test
    void toStringReturnsFormattedStringWithoutIndentation() {
        CourseRecord course = createSampleCourse();
        assertEquals(101, course.courseNumber());
        StudentSemesterRecord record = new StudentSemesterRecord(TermEnum.FALL, 2023, List.of(course));
        String expected = "Semester:\n" +
                "\tTerm: Fall\n" +
                "\tYear: 2023\n" +
                "\tCourses:\n" +
                course.toString(2);
        assertEquals(expected, record.toString());
    }

    @Test
    void toStringReturnsFormattedStringWithIndentation() {
        CourseRecord course = createSampleCourse();
        assertEquals(101, course.courseNumber());
        StudentSemesterRecord record = new StudentSemesterRecord(TermEnum.FALL, 2023, List.of(course));
        String expected = "\tSemester:\n" +
                "\t\tTerm: Fall\n" +
                "\t\tYear: 2023\n" +
                "\t\tCourses:\n" +
                course.toString(3);
        assertEquals(expected, record.toString(1));
    }

    @Test
    void toJSONReturnsFormattedJSONStringWithoutIndentation() {
        CourseRecord course = createSampleCourse();
        assertEquals(101, course.courseNumber());
        StudentSemesterRecord record = new StudentSemesterRecord(TermEnum.FALL, 2023, List.of(course));
        String expected = "{\n" +
                "\t\"term\": \"Fall\",\n" +
                "\t\"year\": 2023,\n" +
                "\t\"courses\": [\n" +
                course.toJSON(2) + "\n" +
                "\t]\n" +
                "}";
        assertEquals(expected, record.toJSON(0));
    }

    @Test
    void toJSONReturnsFormattedJSONStringWithIndentation() {
        CourseRecord course = createSampleCourse();
        assertEquals(101, course.courseNumber());
        StudentSemesterRecord record = new StudentSemesterRecord(TermEnum.FALL, 2023, List.of(course));
        String expected = "\t{\n" +
                "\t\t\"term\": \"Fall\",\n" +
                "\t\t\"year\": 2023,\n" +
                "\t\t\"courses\": [\n" +
                course.toJSON(3) + "\n" +
                "\t\t]\n" +
                "\t}";
        assertEquals(expected, record.toJSON(1));
    }
}
