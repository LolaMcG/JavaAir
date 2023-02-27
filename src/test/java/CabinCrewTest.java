import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CabinCrewTest {

    CabinCrew cabinCrew1;
    CabinCrew cabinCrew2;

    @Before
    public void before(){
        cabinCrew1 = new CabinCrew("Big Jane", Rank.CHIEF_PURSER);
        cabinCrew2 = new CabinCrew("Pearl Diver", Rank.ATTENDANT);
    }

    @Test
    public void hasName(){
        assertEquals("Big Jane", cabinCrew1.getName());
    }

    @Test
    public void hasRank(){
        assertEquals(Rank.ATTENDANT, cabinCrew2.getRank());
    }

    @Test
    public void canCommunicate(){
        assertEquals("Please stow traytables and put seats in the upright position for landing", cabinCrew1.communicate());
    }

    @Test
    public void hasWeight(){
        assertEquals(80, cabinCrew1.getWeight());
    }
}
