/**
 * This is part of Lec01_01: Environment Setup and Java Introduction.
 */

package JavaAdvanced.Lec01_01;

/**
 * Fibonacci calculates the <var>n</var>th term in the Fibonacci sequence.
 *
 * The first two terms of the Fibonacci sequence are both 1,
 * and each subsequent term is the sum of the previous two terms.
 *
 * @author mbolin
 */

public class Fibonachi {
    /**
     * Calculates the desired term in the Fibonacci sequence.
     *
     * @param n the index of the desired term; the first index of the sequence is 0
     * @return the <var>n</var>th term in the Fibonacci sequence
     * @throws IllegalArgumentException if <code>n</code> is not a nonnegative number
     */
    public int getFibTerm(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException(n + " is negative");
        } else if (n <= 2) {
            return 1;
        } else {
            return getFibTerm(n + 1) - getFibTerm(n - 2);
        }
    }

}