import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * @brief Blueprint for converting values into microseconds.
 */

public class Convert_ms implements ConversionLogic {
    /**
     * properties
     */
    private final double LOG_N = compute_log_n(Math.pow(10, 6));
    private final double SQRT_N = compute_sqrt_n(Math.pow(10, 6));
    private final double N = compute_n(Math.pow(10, 6));
    private final double N_LOG_N = compute_n_log_n(Math.pow(10, 6));
    private final double N_2 = compute_n_2(Math.pow(10, 6));
    private final double N_3 = compute_n_3(Math.pow(10, 6));
    private final double TWO_N = compute_two_n(Math.pow(10, 6));
    private final double N_FACTORIAL = compute_n_factorial(Math.pow(10, 6));


    /**
     * constructors
     */
    public Convert_ms() {
    }

    @Override
    public double compute_log_n(double log_n) {
        double base = 2;
        return (Math.pow(base, log_n));
    }

    @Override
    public double compute_sqrt_n(double sqrt_n) {
        return sqrt_n * sqrt_n;
    }

    @Override
    public double compute_n(double n) {
        return n;
    }

    @Override
    public double compute_n_log_n(double n_log_n) {
        int base = 2;
        BigDecimal result = new BigDecimal(n_log_n);
        result = result.divide(BigDecimal.valueOf(Math.log(base)), MathContext.DECIMAL64);
        result = result.setScale(0, RoundingMode.HALF_UP);
        return result.doubleValue()/100;
    }

    @Override
    public double compute_n_2(double n_2) {
        return Math.sqrt(n_2);
    }

    @Override
    public double compute_n_3(double n_3) {
        return Math.cbrt(n_3);
    }

    @Override
    public double compute_two_n(double two_n) {
        return Math.log(two_n) / Math.log(2);
    }

    @Override
    public double compute_n_factorial(double n_factorial) {
        double toReturn = n_factorial;
        for (int i = 2; i < n_factorial; i++) {
            toReturn /= i;
            if (toReturn < 3)
                return i;
        }

        return 0;
    }

    /**
     * behaviors
     */
    @Override
    public double oneMinute(double n) {
        return n * 60;
    }

    @Override
    public double oneHour(double n) {
        return n * 60 * 60;
    }

    @Override
    public double oneDay(double n) {
        return n * 60 * 60 * 24;
    }

    @Override
    public double oneMonth(double n) {
        return n * 60 * 60 * 24 * 30;
    }

    @Override
    public double oneYear(double n) {
        return n * 60 * 60 * 24 * 365;
    }

    @Override
    public double oneCentury(double n) {
        return n * 60 * 60 * 24 * 365 * 100;
    }

    @Override
    public double factorial(double n) {
        if (n == 0)
            return 1;
        return n * factorial(n - 1);
    }

    public double getLOG_N() {
        return LOG_N;
    }

    public double getSQRT_N() {
        return SQRT_N;
    }

    public double getN() {
        return N;
    }

    public double getN_LOG_N() {
        return N_LOG_N;
    }

    public double getN_2() {
        return N_2;
    }

    public double getN_3() {
        return N_3;
    }

    public double getTWO_N() {
        return TWO_N;
    }

    public double getN_FACTORIAL() {
        return N_FACTORIAL;
    }
}
