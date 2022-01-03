package javaInterviewPrep;

class FinalizeDemo {
    @Override
    protected void finalize() throws Throwable {
        System.out.println("Object finalized :::: ");
    }
}

public class InterviewPrep {

    public static void main(String[] args) {
        int i = 10; // single valued container
        Integer iRef = new Integer(i); // Boxed (constructing the object)

        int j = iRef.intValue();

        try{
            int x = 100;
            int y = 0;
            int z = x/y;
            int p1 = 23;
            int p2 = 24;
            int q = p1/p2;
            System.out.println("this should have been executed::::   "+q);
        } catch (Exception e) {
            System.out.println("Exception Trace is ::::  "+e.toString());
        } finally {
            System.out.println("Finally block is being executed ::::: ");
            int p1 = 23;
            int p2 = 24;
            int q = p1/p2;
            System.out.println("this should have been executed::::   "+q);

            FinalizeDemo fd = new FinalizeDemo();
            fd = null;
            System.gc();
        }

    }

    private static final int getSum(int a, int b) {
        return a+b;
    }
}
