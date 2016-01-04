import com.google.common.base.Joiner;
import javafx.util.Pair;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;


/**
 * Created by Jessica on 11/28/2015.
 */
public class Subs {
    public static void main(String[] args) throws FileNotFoundException {
        String s = "in/rosalind_";
        s = s.concat(new Object() {

        }.getClass().getEnclosingClass().getSimpleName().toLowerCase()).concat(".txt");
        File f = new File(s);
        StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(f)) {
            Collection<Integer> occurrences = process(read(scanner));
            result.append(Joiner.on(' ').join(occurrences));
        }
        System.out.println(result);
    }

    public static String[] read(Scanner scanner) {
        String[] nH = new String[2];
        nH[0] = scanner.nextLine();
        nH[1] = scanner.nextLine();
        return nH;
    }

    public static Collection<Integer> process(String[] input) {
        String needle = input[1];
        String haystack = input[0];
        List<Integer> matches = new ArrayList<>();
        int[] table = buildLastTable(needle);
        int skip;
        for (int i = 0; i < haystack.length() - needle.length(); i += skip) {
            skip = 0;
            for (int j = needle.length() - 1; j >= 0 && skip == 0; j--) {
                if (needle.charAt(j) != haystack.charAt(i + j)) {
                    skip = Math.max(1, j - table[haystack.charAt(i + j)]);
                } else if (j == 0) {
                    matches.add(i + 1);
                    skip = Math.max(1, j - table[haystack.charAt(i + j)]);
                }
            }
        }
        return matches;
    }

    public static int[] buildLastTable(CharSequence needle) {
        if (needle == null) {
            throw new IllegalArgumentException("null pattern");
        }
        int[] table = new int[Character.MAX_VALUE+1];
        for (int i = 0 ; i < table.length; i++) {
            table[i] = -1;
        }
        for (int i = 0; i < needle.length(); i++) {
            table[needle.charAt(i)] = i;
        }
        return table;
    }
}
