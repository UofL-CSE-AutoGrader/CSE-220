package autogradertests;


import org.example.university.enums.DepartmentCodeEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentCodeEnumTest {

    @Test
    @DisplayName("Test getFullName method for each department")
    void getFullNameReturnsCorrectFullNameForEachDepartment() {
        assertEquals("Computer Science and Engineering", DepartmentCodeEnum.CSE.getFullName());
        assertEquals("Electronics and Communication Engineering", DepartmentCodeEnum.ECE.getFullName());
        assertEquals("Mechanical Engineering", DepartmentCodeEnum.ME.getFullName());
        assertEquals("Civil Engineering", DepartmentCodeEnum.CE.getFullName());
        assertEquals("Mathematics", DepartmentCodeEnum.MATH.getFullName());
        assertEquals("Physics", DepartmentCodeEnum.PHY.getFullName());
        assertEquals("Chemistry", DepartmentCodeEnum.CHEM.getFullName());
        assertEquals("Biology", DepartmentCodeEnum.BIO.getFullName());
        assertEquals("English", DepartmentCodeEnum.ENG.getFullName());
        assertEquals("Business Administration", DepartmentCodeEnum.BUS.getFullName());
        assertEquals("Arts", DepartmentCodeEnum.ART.getFullName());
        assertEquals("Law", DepartmentCodeEnum.LAW.getFullName());
        assertEquals("Psychology", DepartmentCodeEnum.PYS.getFullName());
        assertEquals("Sociology", DepartmentCodeEnum.SOC.getFullName());
        assertEquals("History", DepartmentCodeEnum.HIS.getFullName());
        assertEquals("Geography", DepartmentCodeEnum.GEO.getFullName());
        assertEquals("Philosophy", DepartmentCodeEnum.PHI.getFullName());
        assertEquals("Economics", DepartmentCodeEnum.ECON.getFullName());
        assertEquals("Statistics", DepartmentCodeEnum.STA.getFullName());
        assertEquals("Environmental Science", DepartmentCodeEnum.ENV.getFullName());
        assertEquals("Finance", DepartmentCodeEnum.FIN.getFullName());
        assertEquals("Human Resource Management", DepartmentCodeEnum.HRM.getFullName());
        assertEquals("Marketing", DepartmentCodeEnum.MKT.getFullName());
        assertEquals("Information Technology", DepartmentCodeEnum.IT.getFullName());
        assertEquals("Administration", DepartmentCodeEnum.ADM.getFullName());
        assertEquals("Others", DepartmentCodeEnum.OTHERS.getFullName());
    }

    @Test
    @DisplayName("Test toString method for each department")
    void toStringReturnsEnumNameForEachDepartment() {
        assertEquals("CSE", DepartmentCodeEnum.CSE.toString());
        assertEquals("ECE", DepartmentCodeEnum.ECE.toString());
        assertEquals("ME", DepartmentCodeEnum.ME.toString());
        assertEquals("CE", DepartmentCodeEnum.CE.toString());
        assertEquals("MATH", DepartmentCodeEnum.MATH.toString());
        assertEquals("PHY", DepartmentCodeEnum.PHY.toString());
        assertEquals("CHEM", DepartmentCodeEnum.CHEM.toString());
        assertEquals("BIO", DepartmentCodeEnum.BIO.toString());
        assertEquals("ENG", DepartmentCodeEnum.ENG.toString());
        assertEquals("BUS", DepartmentCodeEnum.BUS.toString());
        assertEquals("ART", DepartmentCodeEnum.ART.toString());
        assertEquals("LAW", DepartmentCodeEnum.LAW.toString());
        assertEquals("PYS", DepartmentCodeEnum.PYS.toString());
        assertEquals("SOC", DepartmentCodeEnum.SOC.toString());
        assertEquals("HIS", DepartmentCodeEnum.HIS.toString());
        assertEquals("GEO", DepartmentCodeEnum.GEO.toString());
        assertEquals("PHI", DepartmentCodeEnum.PHI.toString());
        assertEquals("ECON", DepartmentCodeEnum.ECON.toString());
        assertEquals("STA", DepartmentCodeEnum.STA.toString());
        assertEquals("ENV", DepartmentCodeEnum.ENV.toString());
        assertEquals("FIN", DepartmentCodeEnum.FIN.toString());
        assertEquals("HRM", DepartmentCodeEnum.HRM.toString());
        assertEquals("MKT", DepartmentCodeEnum.MKT.toString());
        assertEquals("IT", DepartmentCodeEnum.IT.toString());
        assertEquals("ADM", DepartmentCodeEnum.ADM.toString());
        assertEquals("OTHERS", DepartmentCodeEnum.OTHERS.toString());
    }
}
