import java.util.*;
import java.math.*;

public class DiffeHelmanBigInt {
    final static BigInteger one = new BigInteger("1");

    public static void main(String args[]) {
        Scanner stdin = new Scanner(System.in);
        BigInteger p;

        // Get a start spot to pick a prime from the user.
        System.out.println("Enter the approximate value of p you want.");
        String ans = stdin.next();
        p = getNextPrime(ans);
        System.out.println("Your prime is " + p + ".");

        // Get the base for exponentiation from the user.
        System.out.println("Now, enter a number in between 2 and p-1.");
        BigInteger g = new BigInteger(stdin.next());

        // Get A's secret number.
        System.out.println("Person A: enter your secret number now.");
        BigInteger a = new BigInteger(stdin.next());

        // Make A's calculation.
        BigInteger RESULTa = g.modPow(a, p);
        // This is the value that will get sent from A to B.

        // This value does NOT compromise the value of a easily.
        System.out.println("Person A sends to person B " + RESULTa + ".");

        // Get B's secret number.
        System.out.println("Person B: enter your secret number now.");
        BigInteger b = new BigInteger(stdin.next());

        // Make B's calculation.
        BigInteger RESULTb = g.modPow(b, p);
        // This is the value that will get sent from B to A.
        // This value does NOT compromise the value of b easily.

        System.out.println("Person B sends to person A " + RESULTb + ".");
        // Once A and B receive their values, they make their new calculations.
        // This involved getting their new numbers and raising them to the
        // same power as before, their secret number.

        BigInteger KeyACalculates = RESULTb.modPow(a, p);
        BigInteger KeyBCalculates = RESULTa.modPow(b, p);

        // Print out the Key A calculates.
        System.out.println("A takes " + RESULTb + " raises it to the power " + a + " mod " + p);
        System.out.println("The Key A calculates is " + KeyACalculates + ".");

        // Print out the Key B calculates.
        System.out.println("B takes " + RESULTa + " raises it to the power " + b + " mod " + p);
        System.out.println("The Key B calculates is " + KeyBCalculates + ".");
    }

    public static BigInteger getNextPrime(String ans) {
        BigInteger test = new BigInteger(ans);
        while (!test.isProbablePrime(99))
            test = test.add(one);
        return test;
    }
}