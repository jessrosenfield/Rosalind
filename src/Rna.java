import com.google.common.collect.ImmutableMap;
import com.google.common.escape.CharEscaper;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.KeyStore;
import java.util.Scanner;


/**
 * Created by Jessica on 11/28/2015.
 */
public class Rna {
    public static void main(String[] args) throws FileNotFoundException {
        StringBuilder result = new StringBuilder();
        String s = "in/rosalind_";
        s = s.concat(new Object() {

        }.getClass().getEnclosingClass().getSimpleName().toLowerCase()).concat(".txt");
        File f = new File(s);
        try (Scanner scanner = new Scanner(f)) {
            String line = scanner.nextLine();
            for (int i = 0; i < line.length(); i++)  {
                result.append(transcribe(line.charAt(i)));
            }
        }
        System.out.println(result.toString());
    }
    public static char transcribe(char c) {
        if (c == 'T') {
            return 'U';
        } else {
            return c;
        }
    }
}
