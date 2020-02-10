package kata.effective.java.item48;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

import com.google.common.base.Stopwatch;
import java.math.BigInteger;
import java.util.concurrent.TimeUnit;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class TestParallelStream {


  public static void worstCase(boolean isParallel) {
    Stopwatch stopwatch = Stopwatch.createStarted();

    Stream<BigInteger> primes = isParallel ? primes().parallel() : primes();
    primes
        .map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
        .filter(mersenne -> mersenne.isProbablePrime(50))
        .limit(20)
        .forEach(System.out::println);

    stopwatch.stop();
    System.out.printf("worstCase scenario took  %s seconds", stopwatch.elapsed(TimeUnit.SECONDS));
  }

  static Stream<BigInteger> primes() {
    return Stream.iterate(TWO, BigInteger::nextProbablePrime);
  }


  public static long bestCase(boolean isParallel, long n) {
    Stopwatch stopwatch = Stopwatch.createStarted();
    LongStream longStream = isParallel ?
        LongStream.rangeClosed(2, n).parallel() :
        LongStream.rangeClosed(2, n);
    final long count = longStream
        .mapToObj(BigInteger::valueOf)
        .filter(i -> i.isProbablePrime(50))
        .count();
    stopwatch.stop();
    System.out.printf("bestCase scenario took  %s seconds", stopwatch.elapsed(TimeUnit.SECONDS));
    return count;
  }
}
