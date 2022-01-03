package javaInterviewPrep;

public class FInalizeExample {

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object finalized :::: ");
    }

    public static void main(String[] args) {
        FInalizeExample f1 = new FInalizeExample();
        FInalizeExample f2 = new FInalizeExample();
        System.out.println("printing finalize related :::");
//        f1 = null;
//        f2 = null;
        System.out.println("before garbage collection :::: ");
        System.gc();
    }
}
