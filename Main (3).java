import java.util.LinkedList;


public class Main {
    public static void main(String[] args) {
        final int MAX_LIMIT = 10000;
        Prime prime = new Prime(MAX_LIMIT);
        java.util.Random random = new java.util.Random();

        int number;
        do {
            number = random.nextInt(MAX_LIMIT);
        } while (number < 2 || prime.isPrime(number));

        System.out.println("What primes make up " + number + "?");
        while (number >= 2) {
            int factor = prime.findFactor(number);
            System.out.print(factor);
            number /= factor;
            if (number >= 2) {
                System.out.print("x");
            }
        }
        System.out.println();
    }
}