public class Narrowing {
    
    public static void main(String[] args) {
        // Example of narrowing primitive conversion

        double a = 10.5;
        float b = (float) a;
        long c = (long) b;
        int d = (int) c;
        short e = (short) d;
        byte f = (byte) e;

        System.out.println("Narrowing Primitive Conversion:");
        System.out.println("Double : " + a);
        System.out.println("Float  : " + b);
        System.out.println("Long   : " + c);
        System.out.println("Int    : " + d);
        System.out.println("Short  : " + e);
        System.out.println("Byte   : " + f);
        System.out.println("--------------------------------------------------");
        System.out.println(Thread.currentThread().getName() + " executed successfully.");
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName() + " executed successfully.");
    }
}
