import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Created by Jessica on 11/28/2015.
 */
public class Fib {
    public static void main(String[] args) throws FileNotFoundException {
        String s = "in/rosalind_";
        s = s.concat(new Object() {

        }.getClass().getEnclosingClass().getSimpleName().toLowerCase()).concat(".txt");
        File f = new File(s);
        StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(f)) {
            int[] inputs = read(scanner);
            result.append(Long.toString(process(inputs[0], inputs[1])));
        }
        System.out.println(result);
    }

    public static int[] read(Scanner scanner) {
        int[] nk = {scanner.nextInt(), scanner.nextInt()};
        return nk;
    }

    public static long process(int n, int k) {
        long[] rabbits = new long[3];
        rabbits[0] = 1;
        for (int i = 0; i < n - 3; i++) {
            rabbits[2] = rabbits[0] * k;
            rabbits[0] += rabbits[1];
            rabbits[1] = rabbits[2];
        }
        long totalRabbits = 0;
        for (long rabbitAge : rabbits) {
            totalRabbits += rabbitAge;
        }
        return totalRabbits;
    }
}
