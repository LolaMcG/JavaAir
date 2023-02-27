public abstract class Person {

//Instance variables
    private String name;

//    Static variable - this is associated with the class rather than an instance of the class. Reasonable average weight has been assigned to a Person, in kg.
    private static int personWeight = 80;
    private static int bagWeight = 23;


//    Constructor function
    public Person(String name){
        this.name = name;
    }


//    Will return the 'name' instance variable in any instance of a child class of Person.
    public String getName(){
        return this.name;
    }

    public int getWeight(){
        return this.personWeight;
    }
}
