import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Created by Jessica on 11/28/2015.
 */
public class Iprb {
    public static void main(String[] args) throws FileNotFoundException {
        String s = "in/rosalind_";
        s = s.concat(new Object() {

        }.getClass().getEnclosingClass().getSimpleName().toLowerCase()).concat(".txt");
        File f = new File(s);
        StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(f)) {
            int[] inputs = read(scanner);
            result.append(process(inputs[0], inputs[1], inputs[2]));
        }
        System.out.println(result);
    }

    public static int[] read(Scanner scanner) {
        int[] kmn = {scanner.nextInt(), scanner.nextInt(), scanner.nextInt()};
        return kmn;
    }

    public static double process(int k, int m, int n) {
        int totalPop = k + m + n;
        double totalProb = 0.0;
        // TODO: what if they are <2
        double xHomoDom = k / (double) totalPop;
        totalProb += xHomoDom * (k - 1) / (double) (totalPop - 1);
        totalProb += xHomoDom * m / (double) (totalPop - 1);
        totalProb += xHomoDom * n / (double) (totalPop - 1);
        double xHetero = m / (double) totalPop;
        totalProb += xHetero * k / (double) (totalPop - 1);
        totalProb += xHetero * (m - 1) / (double) (totalPop - 1) * 3 / 4;
        totalProb += xHetero* n / (double) (totalPop - 1) / 2;
        double xHomoRec = n / (double) totalPop;
        totalProb += xHomoRec * k / (double) (totalPop - 1);
        totalProb += xHomoRec * m / (double) (totalPop - 1) / 2;
        return totalProb;
    }
}
