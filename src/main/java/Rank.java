public enum Rank {
    CAPTAIN("Captain"),
    FIRST_OFFICER("First Officer"),
    CHIEF_PURSER("Chief Purser"),
    PURSER("Purser"),
    SENIOR_CREW("Senior Crew"),
    ATTENDANT("Attendant");

    private final String rank;

    Rank(String rank){
        this.rank = rank;
    }

    public String getRank(){
        return rank;
    }

}