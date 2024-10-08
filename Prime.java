import java.util.LinkedList;

public class Prime {
    private LinkedList<Integer> primes;

    public Prime(int max) {
        primes = new LinkedList<>();
        boolean[] isPrime = new boolean[max + 1];
        for (int i = 2; i <= max; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= Math.sqrt(max); i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= max; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int i = 2; i <= max; i++) {
            if (isPrime[i]) {
                primes.add(i);
            }
        }
    }

    public boolean isPrime(int num) {
        for (int prime : primes) {
            if (prime == num) {
                return true;
            }
        }
        return false;
    }

    public int getPrime(int index) {
        return primes.get(index);
    }

    public int findFactor(int target) {
        if (target < 2) {
            return -1;
        }
        for (int i = 0; i < primes.size(); i++) {
            int prime = primes.get(i);
            if (target % prime == 0) {
                return prime;
            }
        }
        return -1;
    }
}