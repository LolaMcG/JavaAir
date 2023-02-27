import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger1;
    Passenger passenger2;

    @Before
    public void before(){
        passenger1 = new Passenger("Craig David", 3);
        passenger2 = new Passenger("Julia Childs", 2);
    }

    @Test
    public void hasName(){
        assertEquals("Craig David", passenger1.getName());
    }

    @Test
    public void hasNoOfBags(){
        assertEquals(2, passenger2.getNoOfBags());
    }

    @Test
    public void hasWeight(){
        assertEquals(80, passenger2.getWeight());
    }
}
