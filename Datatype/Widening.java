import java.util.Scanner;

public class Widening {
	public static void main(String[] args) {
		// Example of widening primitive conversion
        Scanner scanner  = new Scanner(System.in);
        System.out.print("Enter a byte value: ");
        byte a = scanner.nextByte();
        short b = a;
        int c = b;
        long d = c;
        float e = d;
        double f = e;

        System.out.println("Widening Primitive Conversion:");
        System.out.println("Byte   : " + a);
        System.out.println("Short  : " + b);
        System.out.println("Int    : " + c);
        System.out.println("Long   : " + d);
        System.out.println("Float  : " + e);
        System.out.println("Double : " + f);
    }
}
