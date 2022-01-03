package OODDesignPatterns.com.staticExample;


// outside classes cannot be static
public class InnerClasses {

    static class Test {
        String name;

        public Test(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        Test a = new Test("Sumit");
        Test b = new Test("Honey");

        System.out.println("printing with tos tring method::::  "+a);
//        System.out.println(b.name);
    }


}

