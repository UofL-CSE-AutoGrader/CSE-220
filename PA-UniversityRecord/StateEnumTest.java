package autogradertests;

import org.example.university.enums.StateEnum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StateEnumTest {

    @Test
    @DisplayName("Test getFullName method for each state")
    void getFullNameReturnsCorrectFullNameForEachState() {
        assertEquals("Alabama", StateEnum.AL.getFullName());
        assertEquals("Alaska", StateEnum.AK.getFullName());
        assertEquals("Arizona", StateEnum.AZ.getFullName());
        assertEquals("Arkansas", StateEnum.AR.getFullName());
        assertEquals("California", StateEnum.CA.getFullName());
        assertEquals("Colorado", StateEnum.CO.getFullName());
        assertEquals("Connecticut", StateEnum.CT.getFullName());
        assertEquals("Delaware", StateEnum.DE.getFullName());
        assertEquals("Florida", StateEnum.FL.getFullName());
        assertEquals("Georgia", StateEnum.GA.getFullName());
        assertEquals("Hawaii", StateEnum.HI.getFullName());
        assertEquals("Idaho", StateEnum.ID.getFullName());
        assertEquals("Illinois", StateEnum.IL.getFullName());
        assertEquals("Indiana", StateEnum.IN.getFullName());
        assertEquals("Iowa", StateEnum.IA.getFullName());
        assertEquals("Kansas", StateEnum.KS.getFullName());
        assertEquals("Kentucky", StateEnum.KY.getFullName());
        assertEquals("Louisiana", StateEnum.LA.getFullName());
        assertEquals("Maine", StateEnum.ME.getFullName());
        assertEquals("Maryland", StateEnum.MD.getFullName());
        assertEquals("Massachusetts", StateEnum.MA.getFullName());
        assertEquals("Michigan", StateEnum.MI.getFullName());
        assertEquals("Minnesota", StateEnum.MN.getFullName());
        assertEquals("Mississippi", StateEnum.MS.getFullName());
        assertEquals("Missouri", StateEnum.MO.getFullName());
        assertEquals("Montana", StateEnum.MT.getFullName());
        assertEquals("Nebraska", StateEnum.NE.getFullName());
        assertEquals("Nevada", StateEnum.NV.getFullName());
        assertEquals("New Hampshire", StateEnum.NH.getFullName());
        assertEquals("New Jersey", StateEnum.NJ.getFullName());
        assertEquals("New Mexico", StateEnum.NM.getFullName());
        assertEquals("New York", StateEnum.NY.getFullName());
        assertEquals("North Carolina", StateEnum.NC.getFullName());
        assertEquals("North Dakota", StateEnum.ND.getFullName());
        assertEquals("Ohio", StateEnum.OH.getFullName());
        assertEquals("Oklahoma", StateEnum.OK.getFullName());
        assertEquals("Oregon", StateEnum.OR.getFullName());
        assertEquals("Pennsylvania", StateEnum.PA.getFullName());
        assertEquals("Rhode Island", StateEnum.RI.getFullName());
        assertEquals("South Carolina", StateEnum.SC.getFullName());
        assertEquals("South Dakota", StateEnum.SD.getFullName());
        assertEquals("Tennessee", StateEnum.TN.getFullName());
        assertEquals("Texas", StateEnum.TX.getFullName());
        assertEquals("Utah", StateEnum.UT.getFullName());
        assertEquals("Vermont", StateEnum.VT.getFullName());
        assertEquals("Virginia", StateEnum.VA.getFullName());
        assertEquals("Washington", StateEnum.WA.getFullName());
        assertEquals("West Virginia", StateEnum.WV.getFullName());
        assertEquals("Wisconsin", StateEnum.WI.getFullName());
        assertEquals("Wyoming", StateEnum.WY.getFullName());
    }

    @Test
    @DisplayName("Test toString method for each state")
    void toStringReturnsCorrectFullNameForEachState() {
        assertEquals("Alabama", StateEnum.AL.toString());
        assertEquals("Alaska", StateEnum.AK.toString());
        assertEquals("Arizona", StateEnum.AZ.toString());
        assertEquals("Arkansas", StateEnum.AR.toString());
        assertEquals("California", StateEnum.CA.toString());
        assertEquals("Colorado", StateEnum.CO.toString());
        assertEquals("Connecticut", StateEnum.CT.toString());
        assertEquals("Delaware", StateEnum.DE.toString());
        assertEquals("Florida", StateEnum.FL.toString());
        assertEquals("Georgia", StateEnum.GA.toString());
        assertEquals("Hawaii", StateEnum.HI.toString());
        assertEquals("Idaho", StateEnum.ID.toString());
        assertEquals("Illinois", StateEnum.IL.toString());
        assertEquals("Indiana", StateEnum.IN.toString());
        assertEquals("Iowa", StateEnum.IA.toString());
        assertEquals("Kansas", StateEnum.KS.toString());
        assertEquals("Kentucky", StateEnum.KY.toString());
        assertEquals("Louisiana", StateEnum.LA.toString());
        assertEquals("Maine", StateEnum.ME.toString());
        assertEquals("Maryland", StateEnum.MD.toString());
        assertEquals("Massachusetts", StateEnum.MA.toString());
        assertEquals("Michigan", StateEnum.MI.toString());
        assertEquals("Minnesota", StateEnum.MN.toString());
        assertEquals("Mississippi", StateEnum.MS.toString());
        assertEquals("Missouri", StateEnum.MO.toString());
        assertEquals("Montana", StateEnum.MT.toString());
        assertEquals("Nebraska", StateEnum.NE.toString());
        assertEquals("Nevada", StateEnum.NV.toString());
        assertEquals("New Hampshire", StateEnum.NH.toString());
        assertEquals("New Jersey", StateEnum.NJ.toString());
        assertEquals("New Mexico", StateEnum.NM.toString());
        assertEquals("New York", StateEnum.NY.toString());
        assertEquals("North Carolina", StateEnum.NC.toString());
        assertEquals("North Dakota", StateEnum.ND.toString());
        assertEquals("Ohio", StateEnum.OH.toString());
        assertEquals("Oklahoma", StateEnum.OK.toString());
        assertEquals("Oregon", StateEnum.OR.toString());
        assertEquals("Pennsylvania", StateEnum.PA.toString());
        assertEquals("Rhode Island", StateEnum.RI.toString());
        assertEquals("South Carolina", StateEnum.SC.toString());
        assertEquals("South Dakota", StateEnum.SD.toString());
        assertEquals("Tennessee", StateEnum.TN.toString());
        assertEquals("Texas", StateEnum.TX.toString());
        assertEquals("Utah", StateEnum.UT.toString());
        assertEquals("Vermont", StateEnum.VT.toString());
        assertEquals("Virginia", StateEnum.VA.toString());
        assertEquals("Washington", StateEnum.WA.toString());
        assertEquals("West Virginia", StateEnum.WV.toString());
        assertEquals("Wisconsin", StateEnum.WI.toString());
        assertEquals("Wyoming", StateEnum.WY.toString());
    }
}
