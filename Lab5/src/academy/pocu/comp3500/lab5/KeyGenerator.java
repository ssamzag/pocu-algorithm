package academy.pocu.comp3500.lab5;

import java.math.BigInteger;

public class KeyGenerator {
    static long primeTest[] = {2, 3, 5, 7, 13, 325, 9375, 28178, 450775, 9780504, 1795265022};

    public static boolean isPrime(final BigInteger number) {
        return isPrime(number.longValue());
    }

    public static long addMod(long x, long y, long m) {
        x %= m;
        y %= m;
        return (x >= m - y ? x - (m - y) : x + y);
    }

    // calculate (x * y) % m; overlow-safe
    public static long mulMod(long x, long y, long m) {
        x %= m;
        y %= m;
        long r = 0;
        while (y > 0) {
            if (y % 2 == 1)
                r = addMod(r, x, m);
            x = addMod(x, x, m);
            y /= 2;
        }
        return r;
    }

    // calculate x^y % m; overflow-safe
    public static long powMod(long x, long y, long m) {
        x %= m;
        long r = 1;
        while (y > 0) {
            if (y % 2 == 1)
                r = mulMod(r, x, m);
            x = mulMod(x, x, m);
            y /= 2;
        }
        return r;
    }

    // true for probable prime, false for composite
    public static boolean millerRabin(long n, long a) {
        long d = n - 1;
        while (d % 2 == 0) {
            if (powMod(a, d, n) == n - 1)
                return true;
            d /= 2;
        }
        long tmp = powMod(a, d, n);
        return tmp == n - 1 || tmp == 1;
    }

    public static boolean isPrime(long n) {
        if (n <= 1)
            return false;
        if (n <= Long.parseLong("10000000000")) {
            for (long i = 2; i * i <= n; i++)
                if (n % i == 0)
                    return false;
            return true;
        }
        for (long a : primeTest)
            if (!millerRabin(n, a))
                return false;
        return true;
    }
}