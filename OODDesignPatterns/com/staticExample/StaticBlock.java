package OODDesignPatterns.com.staticExample;

public class StaticBlock {

    static int a = 4;
    static int b;

    // IMP:  will only run once, when the first obj is created ie when the class is loaded for the first time
    static {
        System.out.println("I am in a static block");
        b=a*5;
    }

    public static void main(String[] args) {
        StaticBlock staticBlock = new StaticBlock();
        System.out.println(staticBlock.a + " " +StaticBlock.b);

        StaticBlock.b += 3;
        System.out.println(StaticBlock.a + "  " +StaticBlock.b);

        StaticBlock obj2 = new StaticBlock();
        System.out.println(StaticBlock.a + "  " +StaticBlock.b);
    }
}
