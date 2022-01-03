package OODDesignPatterns.com.collections;

public class BasicEnums {

    enum Week {
        Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, Sunday;
        // these are enum constants
        // all are public static and final
        // since its final we cant create child enums
        // type is week

        Week() {
            System.out.println("constructor called for :  "+this);
        }
        // this is not public or protected, only private or default
        // why? we dont want to create new objects

    }

    public static void main(String[] args) {
        Week week;
        week = Week.Sunday;
//        for(Week day : Week.values()) {
//            System.out.println(day);
//        }
//        System.out.println(week.ordinal());
    }
}
