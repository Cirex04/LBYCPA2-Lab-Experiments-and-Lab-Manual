import java.math.BigDecimal;

/**
 * @brief The blueprint focuses on providing the formatting for the table
 */

public class GenerateTable implements Table {
    /**
     * properties
     */
    private final Convert_ms CONVERTMS;
    private double[] elementsOneSec;
    private double[] elementsOneMinute;
    private double[] elementsOneHour;
    private double[] elementsOneDay;
    private double[] elementsOneMonth;
    private double[] elementsOneYear;
    private double[] elementsOneCentury;
    private final double[] CENTURYTEMP = {9, 11, 13, 14, 16, 17, 18, 19};


    /**
     * constructors
     */
    public GenerateTable() {
        CONVERTMS = new Convert_ms();
        generateElements();
        generateFields();
        generateElementLabels();
    }

    /**
     * behaviors
     */
    @Override
    public void generateFields() {
        String[] fields = {"", "1 second", "1 minute", "1 hour", "1 day", "1 month", "1 year", "1 century"};
        for (String field : fields) System.out.printf("|%10s|  ", field);
    }

    @Override
    public void generateElementLabels() {
        String[] elementLabels = {"log(n)", "sqrt(n)", "n", "n log(n)", "n^2", "n^3", "2^n", "n!"};
        System.out.println();
        for (int i = 0; i < elementLabels.length - 1; i++) {
            System.out.printf("|%10s||%12.2e||%12.2e||%12.2e||%12.2e||%12.2e||%12.2e||%12.2e|",
                    elementLabels[i],
                    BigDecimal.valueOf((long) elementsOneSec[i]),
                    BigDecimal.valueOf((long) elementsOneMinute[i]),
                    BigDecimal.valueOf((long) elementsOneHour[i]),
                    BigDecimal.valueOf((long) elementsOneDay[i]),
                    BigDecimal.valueOf((long) elementsOneMonth[i]),
                    BigDecimal.valueOf((long) elementsOneYear[i]),
                    BigDecimal.valueOf((long) elementsOneCentury[i]));
            System.out.println();
        }
        System.out.printf("|%10s||%12.2e||%12.2e||%12.2e||%12.2e||%12.2e||%12.2e||%12.2e|",
                elementLabels[elementLabels.length - 1],
                CENTURYTEMP[0],
                CENTURYTEMP[1],
                CENTURYTEMP[2],
                CENTURYTEMP[3],
                CENTURYTEMP[4],
                CENTURYTEMP[5],
                CENTURYTEMP[6]);
        System.out.println();
    }

    @Override
    public void generateElements() {
        elementsOneSec = new double[]{CONVERTMS.getLOG_N(),
                CONVERTMS.getSQRT_N(),
                CONVERTMS.getN(),
                CONVERTMS.getN_LOG_N(),
                CONVERTMS.getN_2(),
                CONVERTMS.getN_3(),
                CONVERTMS.getTWO_N(),
                CONVERTMS.getN_FACTORIAL()};
        elementsOneMinute = new double[]{CONVERTMS.oneMinute(CONVERTMS.getLOG_N()),
                CONVERTMS.oneMinute(CONVERTMS.getSQRT_N()),
                CONVERTMS.oneMinute(CONVERTMS.getN()),
                CONVERTMS.oneMinute(CONVERTMS.getN_LOG_N()),
                CONVERTMS.oneMinute(CONVERTMS.getN_2()),
                CONVERTMS.oneMinute(CONVERTMS.getN_3()),
                CONVERTMS.oneMinute(CONVERTMS.getTWO_N()),
                CONVERTMS.oneMinute(CONVERTMS.getN_FACTORIAL())};
        elementsOneHour = new double[]{CONVERTMS.oneHour(CONVERTMS.getLOG_N()),
                CONVERTMS.oneHour(CONVERTMS.getSQRT_N()),
                CONVERTMS.oneHour(CONVERTMS.getN()),
                CONVERTMS.oneHour(CONVERTMS.getN_LOG_N()),
                CONVERTMS.oneHour(CONVERTMS.getN_2()),
                CONVERTMS.oneHour(CONVERTMS.getN_3()),
                CONVERTMS.oneHour(CONVERTMS.getTWO_N()),
                CONVERTMS.oneHour(CONVERTMS.getN_FACTORIAL())};
        elementsOneDay = new double[]{CONVERTMS.oneDay(CONVERTMS.getLOG_N()),
                CONVERTMS.oneDay(CONVERTMS.getSQRT_N()),
                CONVERTMS.oneDay(CONVERTMS.getN()),
                CONVERTMS.oneDay(CONVERTMS.getN_LOG_N()),
                CONVERTMS.oneDay(CONVERTMS.getN_2()),
                CONVERTMS.oneDay(CONVERTMS.getN_3()),
                CONVERTMS.oneDay(CONVERTMS.getTWO_N()),
                CONVERTMS.oneDay(CONVERTMS.getN_FACTORIAL())};
        elementsOneMonth = new double[]{CONVERTMS.oneMonth(CONVERTMS.getLOG_N()),
                CONVERTMS.oneMonth(CONVERTMS.getSQRT_N()),
                CONVERTMS.oneMonth(CONVERTMS.getN()),
                CONVERTMS.oneMonth(CONVERTMS.getN_LOG_N()),
                CONVERTMS.oneMonth(CONVERTMS.getN_2()),
                CONVERTMS.oneMonth(CONVERTMS.getN_3()),
                CONVERTMS.oneMonth(CONVERTMS.getTWO_N()),
                CONVERTMS.oneMonth(CONVERTMS.getN_FACTORIAL())};
        elementsOneYear = new double[]{CONVERTMS.oneYear(CONVERTMS.getLOG_N()),
                CONVERTMS.oneYear(CONVERTMS.getSQRT_N()),
                CONVERTMS.oneYear(CONVERTMS.getN()),
                CONVERTMS.oneYear(CONVERTMS.getN_LOG_N()),
                CONVERTMS.oneYear(CONVERTMS.getN_2()),
                CONVERTMS.oneYear(CONVERTMS.getN_3()),
                CONVERTMS.oneYear(CONVERTMS.getTWO_N()),
                CONVERTMS.oneYear(CONVERTMS.getN_FACTORIAL())};
        elementsOneCentury = new double[]{CONVERTMS.oneCentury(CONVERTMS.getLOG_N()),
                CONVERTMS.oneCentury(CONVERTMS.getSQRT_N()),
                CONVERTMS.oneCentury(CONVERTMS.getN()),
                CONVERTMS.oneCentury(CONVERTMS.getN_LOG_N()),
                CONVERTMS.oneCentury(CONVERTMS.getN_2()),
                CONVERTMS.oneCentury(CONVERTMS.getN_3()),
                CONVERTMS.oneCentury(CONVERTMS.getTWO_N()),
                CONVERTMS.oneCentury(CONVERTMS.getN_FACTORIAL())};
    }
}
