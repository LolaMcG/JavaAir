public class CabinCrew extends AirlineEmployee{

    private Rank rank;

    public CabinCrew(String name, Rank rank){
        super(name, rank);
    }


    public String communicate(){
        return "Please stow traytables and put seats in the upright position for landing";
    }
}
