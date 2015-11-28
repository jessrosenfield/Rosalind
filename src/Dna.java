import com.google.common.collect.ImmutableList;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.Scanner;


/**
 * Created by Jessica on 11/28/2015.
 */
public class Dna {
    public static void main(String[] args) throws FileNotFoundException {
        ImmutableList<Character> nucleotides =
                new ImmutableList.Builder<Character>().add('A', 'C', 'G', 'T').build();
        StringBuilder result = new StringBuilder();
        String s = "in/rosalind_";
        s = s.concat(new Object() {

        }.getClass().getEnclosingClass().getSimpleName().toLowerCase()).concat(".txt");
        File f = new File(s);
        try (Scanner scanner = new Scanner(f)) {
            String line = scanner.nextLine();
            for (char c : nucleotides) {
                int count = 0;
                for (int i = 0; i < line.length(); i++)  {
                    if (c == line.charAt(i)) {
                        count++;
                    }
                }
                result.append(count).append(' ');
            }
        }
        System.out.println(result.substring(0, result.length() - 1));
    }
}
