import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PilotTest {

    Pilot pilot1;
    Pilot pilot2;

    @Before
    public void before(){
        pilot1 = new Pilot("Amelia Earhart", Rank.CAPTAIN, "CPL12345");
        pilot2 = new Pilot("Emily Howell Warner", Rank.FIRST_OFFICER, "CPL67890");
    }

    @Test
    public void hasName(){
        assertEquals("Amelia Earhart", pilot1.getName());
    }

    @Test
    public void hasRank(){
        assertEquals(Rank.CAPTAIN, pilot1.getRank());
    }

    @Test
    public void hasLicenseNo(){
        assertEquals("CPL12345", pilot1.getLicenseNo());
    }

    @Test
    public void canFlyPlane(){
        assertEquals("Chocks away!", pilot1.flyPlane());
    }

    @Test
    public void canCommunicate(){
        assertEquals("Cabin crew ready for take off", pilot2.communicate());
    }

    @Test
    public void hasWeight(){
        assertEquals(80, pilot1.getWeight());
    }
}
