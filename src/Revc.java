import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import com.google.common.collect.ImmutableMap;


/**
 * Created by Jessica on 11/28/2015.
 */
public class Revc {
    public static void main(String[] args) throws FileNotFoundException {
        String s = "in/rosalind_";
        s = s.concat(new Object() {

        }.getClass().getEnclosingClass().getSimpleName().toLowerCase()).concat(".txt");
        File f = new File(s);
        StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(f)) {
            result.append(process(read(scanner)));
        }
        System.out.println(result);
    }

    public static String read(Scanner scanner) {
        return scanner.nextLine();
    }

    public static String process(String input) {
        ImmutableMap.Builder<Character, Character> reverseComplements = ImmutableMap.builder();
        reverseComplements.put('T', 'A');
        reverseComplements.put('A', 'T');
        reverseComplements.put('G', 'C');
        reverseComplements.put('C', 'G');
        ImmutableMap complements = reverseComplements.build();
        StringBuilder output = new StringBuilder();
        for (int i = input.length() - 1; i >= 0; i--) {
            output.append(complements.get(input.charAt(i)));
        }
        return output.toString();
    }
}
