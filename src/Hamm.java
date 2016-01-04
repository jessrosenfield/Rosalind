import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Created by Jessica on 11/28/2015.
 */
public class Hamm {
    public static void main(String[] args) throws FileNotFoundException {
        String s = "in/rosalind_";
        s = s.concat(new Object() {

        }.getClass().getEnclosingClass().getSimpleName().toLowerCase()).concat(".txt");
        File f = new File(s);
        StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(f)) {
            result.append(Integer.toString(process(read(scanner))));
        }
        System.out.println(result);
    }

    public static String[] read(Scanner scanner) {
        String[] s = new String[2];
        s[0] = scanner.nextLine();
        s[1] = scanner.nextLine();
        return s;
    }

    public static int process(String[] s) {
        int dist = 0;
        for (int i = 0; i < s[0].length(); i++) {
            if (s[0].charAt(i) != s[1].charAt(i)) {
                dist++;
            }
        }
        return dist;
    }
}
