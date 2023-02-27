public class Pilot extends AirlineEmployee{


    private String licenseNo;
    private Rank rank;

//    Invoking superclass constructor. The superclass constructor of AirlineEmployee takes in two arguments - name and rank.
    public Pilot(String name, Rank rank, String licenseNo){
        super(name, rank);
        this.licenseNo = licenseNo;
    }

    public String flyPlane(){
        return "Chocks away!";
    }

    public String communicate(){
        return "Cabin crew ready for take off";
    }

    public String getLicenseNo(){
        return this.licenseNo;
    }
}
