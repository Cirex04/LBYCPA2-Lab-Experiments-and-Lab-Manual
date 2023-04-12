/**
 * @brief Output of the time it takes for each algorithm for 2^n
 */

public class Main {
    /**
     * properties
     */

    /**
     * constructors
     */
    public Main() {
    }

    /**
     * behaviors
     */
    public static void main(String[] args) {
        System.out.printf("""
                        Algorithm      || n=2^6 || n=2^7 || n=2^8 || n=2^9 || n=2^10
                        Selection Sort || %d ms  || %d ms  || %d ms  || %d ms  || %d ms
                        Insertion Sort || %d ms  || %d ms  || %d ms  || %d ms  || %d ms
                        Bubble Sort    || %d ms  || %d ms  || %d ms  || %d ms  || %d ms
                        Merge Sort     || %d ms  || %d ms  || %d ms  || %d ms  || %d ms
                        Quicksort      || %d ms  || %d ms  || %d ms  || %d ms  || %d ms
                        """,
                0, 0, 0, 0, 7,
                0, 0, 0, 0, 5,
                0, 0, 0, 5, 7,
                0, 0, 0, 0, 0,
                0, 0, 0, 0, 4);
        System.out.println();
        System.out.printf("""
                Specs/
                Processor: 11th Gen Intel(R) Core(TM) i5-1135G7 @ 2.40 GHz (8 CPUs), ~ 2.4GHz
                System Manufacturer: LENOVO
                BIOS: GCCN26WW
                Memory: 12288MB RAM
                OS: Windows 11 Home Single Language 64-bit (10.0, Build 22621)
                System Model: GCCN26WW
                """);
    }
}
