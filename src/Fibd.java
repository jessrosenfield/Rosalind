import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.Scanner;


/**
 * Created by Jessica on 11/28/2015.
 */
public class Fibd {
    public static void main(String[] args) throws FileNotFoundException {
        String s = "in/rosalind_";
        s = s.concat(new Object() {

        }.getClass().getEnclosingClass().getSimpleName().toLowerCase()).concat(".txt");
        File f = new File(s);
        StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(f)) {
            int[] inputs = read(scanner);
            result.append(process(inputs[0], inputs[1]).toString());
        }
        System.out.println(result);
    }

    public static int[] read(Scanner scanner) {
        int[] nm = {scanner.nextInt(), scanner.nextInt()};
        return nm;
    }

    public static BigInteger process(int n, int m) {
        BigInteger[] rabbits = new BigInteger[m];
        for (int i = 0; i < m; i ++) {
            rabbits[i] = BigInteger.ZERO;
        }
        rabbits[0] = BigInteger.ONE;
        for (int i = 0; i < n - 1; i++) {
            BigInteger rabbitKids = getRabbitKids(rabbits);
            ageRabbits(rabbits);
            rabbits[0] = rabbitKids;
        }
        BigInteger totalRabbits = BigInteger.ZERO;
        for (BigInteger rabbitAge : rabbits) {
            totalRabbits = totalRabbits.add(rabbitAge);
        }
        return totalRabbits; //- rabbits[m - 1];
    }

    public static BigInteger getRabbitKids(BigInteger[] rabbits) {
        BigInteger kids = BigInteger.ZERO;
        for (int i = 1; i < rabbits.length; i++) {
            kids = kids.add(rabbits[i]);
        }
        return kids;
    }

    public static void ageRabbits(BigInteger[] rabbits) {
        for (int i = rabbits.length - 1; i > 0; i--) {
            rabbits[i] = rabbits[i - 1];
        }
        rabbits[0] = BigInteger.ZERO;
    }

}
