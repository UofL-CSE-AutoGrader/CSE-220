package autogradertests;


import org.example.university.enums.DepartmentCodeEnum;
import org.example.university.enums.MonthsEnum;
import org.example.university.enums.StateEnum;
import org.example.university.enums.TermEnum;
import org.example.university.records.CourseRecord;
import org.example.university.records.StudentRecord;
import org.example.university.records.StudentSemesterRecord;
import org.example.university.records.UniversityRecord;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UniversityRecordTest {

    @Test
    void constructorThrowsExceptionForNullOrBlankUniversityName() {
        assertThrows(IllegalArgumentException.class, () -> new UniversityRecord(null, "U001", "City", StateEnum.CA, null));
        assertThrows(IllegalArgumentException.class, () -> new UniversityRecord("", "U001", "City", StateEnum.CA, null));
        assertThrows(IllegalArgumentException.class, () -> new UniversityRecord("   ", "U001", "City", StateEnum.CA, null));
    }

    @Test
    void constructorThrowsExceptionForNullOrBlankUniversityCode() {
        assertThrows(IllegalArgumentException.class, () -> new UniversityRecord("University", null, "City", StateEnum.CA, null));
        assertThrows(IllegalArgumentException.class, () -> new UniversityRecord("University", "", "City", StateEnum.CA, null));
        assertThrows(IllegalArgumentException.class, () -> new UniversityRecord("University", "   ", "City", StateEnum.CA, null));
    }

    @Test
    void constructorThrowsExceptionForNullOrBlankCity() {
        assertThrows(IllegalArgumentException.class, () -> new UniversityRecord("University", "U001", null, StateEnum.CA, null));
        assertThrows(IllegalArgumentException.class, () -> new UniversityRecord("University", "U001", "", StateEnum.CA, null));
        assertThrows(IllegalArgumentException.class, () -> new UniversityRecord("University", "U001", "   ", StateEnum.CA, null));
    }

    @Test
    void constructorThrowsExceptionForNullState() {
        assertThrows(IllegalArgumentException.class, () -> new UniversityRecord("University", "U001", "City", null, null));
    }

    @Test
    void constructorInitializesEmptyStudentListWhenNullProvided() {
        UniversityRecord university = new UniversityRecord("University", "U001", "City", StateEnum.CA, null);
        assertNotNull(university.students());
        assertTrue(university.students().isEmpty());
    }

    @Test
    void addStudentAddsStudentToStudentList() {
        UniversityRecord university = new UniversityRecord("University", "U001", "City", StateEnum.CA, null);
        StudentRecord student = createStudent("John", "Doe", "S123", 2020, 2000, MonthsEnum.JANUARY, 15, false);
        university.addStudent(student);
        assertEquals(1, university.students().size());
        assertTrue(university.students().contains(student));
    }

    @Test
    void toStringReturnsFormattedStringWithoutIndentation() {
        UniversityRecord university = new UniversityRecord("University", "U001", "City", StateEnum.CA, null);
        String expected = "University Information:\n" +
                "\tUniversity Name: University\n" +
                "\tUniversity Code: U001\n" +
                "\tCity: City\n" +
                "\tState: California\n" +
                "\tStudents:\n";
        assertEquals(expected, university.toString());
    }

    @Test
    void toJSONReturnsFormattedJSONStringWithoutIndentation() {
        UniversityRecord university = new UniversityRecord("University", "U001", "City", StateEnum.CA, null);
        String expected = "{\n" +
                "\t\"universityName\": \"University\",\n" +
                "\t\"universityCode\": \"U001\",\n" +
                "\t\"city\": \"City\",\n" +
                "\t\"state\": \"California\",\n" +
                "\t\"students\": []\n" +
                "}";
        assertEquals(expected, university.toJSON(0));
    }

    @Test
    void toJSONHandlesMultipleUniversityRecords() {
        UniversityRecord university1 = new UniversityRecord("University A", "U001", "City A", StateEnum.CA, null);
        UniversityRecord university2 = new UniversityRecord("University B", "U002", "City B", StateEnum.NY, null);
        String expected = "[\n" +
                "\t{\n" +
                "\t\t\"universityName\": \"University A\",\n" +
                "\t\t\"universityCode\": \"U001\",\n" +
                "\t\t\"city\": \"City A\",\n" +
                "\t\t\"state\": \"California\",\n" +
                "\t\t\"students\": []\n" +
                "\t},\n" +
                "\t{\n" +
                "\t\t\"universityName\": \"University B\",\n" +
                "\t\t\"universityCode\": \"U002\",\n" +
                "\t\t\"city\": \"City B\",\n" +
                "\t\t\"state\": \"New York\",\n" +
                "\t\t\"students\": []\n" +
                "\t}\n" +
                "]";
        assertEquals(expected, UniversityRecord.toJSON(Arrays.asList(university1, university2)));
    }

    @Test
    void createSampleUniversitiesProducesExpectedStructureAndContents() {
        List<UniversityRecord> list = createSampleUniversities();
        assertNotNull(list);
        assertEquals(3, list.size());

        UniversityRecord uniA = list.get(0);
        assertEquals("University A", uniA.universityName());
        assertEquals(2, uniA.students().size());

        UniversityRecord uniB = list.get(1);
        assertEquals("University B", uniB.universityName());
        assertNotNull(uniB.students());
        assertTrue(uniB.students().isEmpty());

        UniversityRecord uniC = list.get(2);
        assertEquals("University C", uniC.universityName());
        assertEquals(1, uniC.students().size());
        StudentRecord carol = uniC.students().get(0);
        assertEquals("Carol", carol.firstName());
        assertTrue(carol.hasGraduated());
        assertTrue(carol.semesters().size() >= 1);
    }

    // --- Private helpers to create test data in this same file ---

    private static CourseRecord createCourse(String name, DepartmentCodeEnum dept, int number, int credits, String instrFirst, String instrLast) {
        return new CourseRecord(name, dept, number, credits, instrFirst, instrLast);
    }

    private static StudentSemesterRecord createSemester(TermEnum term, int year, CourseRecord... courses) {
        List<CourseRecord> list = courses == null ? null : Arrays.asList(courses);
        return new StudentSemesterRecord(term, year, list);
    }

    private static StudentRecord createStudent(String firstName,
                                               String lastName,
                                               String studentID,
                                               int enrollmentYear,
                                               int birthYear,
                                               MonthsEnum birthMonth,
                                               int birthDay,
                                               boolean hasGraduated,
                                               StudentSemesterRecord... semesters) {
        List<StudentSemesterRecord> list = semesters == null ? null : Arrays.asList(semesters);
        // pass null to StudentRecord to allow it to initialize an empty list when appropriate
        if (list != null && list.isEmpty()) {
            list = null;
        }
        return new StudentRecord(firstName, lastName, studentID, enrollmentYear, birthYear, birthMonth, birthDay, hasGraduated, list);
    }

    private static UniversityRecord createUniversity(String name,
                                                     String code,
                                                     String city,
                                                     StateEnum state,
                                                     StudentRecord... students) {
        List<StudentRecord> list = students == null ? null : Arrays.asList(students);
        if (list != null && list.isEmpty()) {
            list = null;
        }
        return new UniversityRecord(name, code, city, state, list);
    }

    private static List<UniversityRecord> createSampleUniversities() {
        // University A with two students
        CourseRecord cs101 = createCourse("Intro to CS", DepartmentCodeEnum.CSE, 101, 3, "John", "Doe");
        CourseRecord math201 = createCourse("Calculus I", DepartmentCodeEnum.MATH, 201, 4, "Mary", "Major");
        StudentSemesterRecord fall2020 = createSemester(TermEnum.FALL, 2020, cs101, math201);

        StudentRecord alice = createStudent("Alice", "Smith", "S123456", 2020, 2002, MonthsEnum.MARCH, 15, false, fall2020);

        // University A second student
        CourseRecord ece150 = createCourse("Circuits I", DepartmentCodeEnum.ECE, 150, 3, "Eve", "Adams");
        StudentSemesterRecord spring2021 = createSemester(TermEnum.SPRING, 2021, ece150);
        StudentRecord bob = createStudent("Bob", "Johnson", "S234567", 2019, 2001, MonthsEnum.JULY, 22, false, spring2021);

        UniversityRecord uniA = createUniversity("University A", "UNI-A", "CityA", StateEnum.CA, alice, bob);

        // University B with no students
        UniversityRecord uniB = createUniversity("University B", "UNI-B", "CityB", StateEnum.NY, (StudentRecord[]) null);

        // University C with a student that has multiple semesters
        CourseRecord ds201 = createCourse("Data Structures", DepartmentCodeEnum.CSE, 201, 4, "Jane", "Roe");
        CourseRecord algo300 = createCourse("Algorithms", DepartmentCodeEnum.CSE, 300, 4, "Alan", "Turing");
        StudentSemesterRecord fall2019 = createSemester(TermEnum.FALL, 2019, ds201);
        StudentSemesterRecord spring2020 = createSemester(TermEnum.SPRING, 2020, algo300);
        StudentRecord carol = createStudent("Carol", "White", "S345678", 2018, 2000, MonthsEnum.NOVEMBER, 3, true, fall2019, spring2020);
        UniversityRecord uniC = createUniversity("University C", "UNI-C", "CityC", StateEnum.TX, carol);

        return Arrays.asList(uniA, uniB, uniC);
    }
}

