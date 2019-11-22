package garbageCollection.markAndSweepAlgorithm;

public class Main {

    public static void main(String[] args) {
        Employee e = new Employee("Sumit", new City("London"));
        e = new Employee("Anubhav", new City("Seattle"));
        e = new Employee("Hashia", new City("Bangalore"));
    }

    private static class City {
        private String city;

        public City(String city){
            this.city = city;
        }

        public String getCity() {
            return city;
        }
    }

    private static class Employee {
        private String firsName;
        private City city;

        public Employee(String firsName, City city) {
            this.firsName = firsName;
            this.city = city;
        }

        public String getFirsName() {
            return firsName;
        }

        public City getCity() {
            return city;
        }
    }
}


/*
* Pseudo code for Mark
*
*/

//Mark(root)
//    if root.marked == false then
//        root.marked = true
//        for each v in root.references:
//            Mark(v)

/*
* Mark phase performs a DFS traversal on all inner references and flips marked flag subsequently
*
*/


/*
 * Pseudo code for Sweep
 *
 */


//Sweep()
//for each object in heap
//    if object.marked = true then
//        object.marked = false
//    else
//        heap.release(object)

/*
* Sweep phase linearly scans the heap and releases objects which have marked flag set to false
* */