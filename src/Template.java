import com.google.common.collect.ImmutableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


/**
 * Created by Jessica on 11/28/2015.
 */
public class Template {
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
        return input;
    }
}
