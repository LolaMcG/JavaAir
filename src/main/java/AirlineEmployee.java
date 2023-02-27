public abstract class AirlineEmployee extends Person {

//    Instance variable of type Rank, which is an enum
    private Rank rank;

//Class constructor function. Here you write all the variables needed to construct this class, including those variables inherited from the parent class (superclass).
    public AirlineEmployee(String name, Rank rank){
//        Invoking superclass constructor. The superclass constructor of Person takes in one argument of String type, called 'name'.
        super(name);
        this.rank = rank;

    }

    public Rank getRank(){
        return rank;
    }

    public String communicate(){
        return "";
    }

}
