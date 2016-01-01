import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * Created by Jessica on 11/28/2015.
 */
public class Prot {
    public static String codonTableFile = "in/codon_table.txt";
    public static Pattern rna2Protein = Pattern.compile("([AUGC]{3})\\s(\\S+)");

    public static void main(String[] args) throws FileNotFoundException {
        String s = "in/rosalind_";
        s = s.concat(new Object() {

        }.getClass().getEnclosingClass().getSimpleName().toLowerCase()).concat(".txt");
        File f = new File(s);
        StringBuilder result = new StringBuilder();
        try (Scanner scanner = new Scanner(f)) {
            result.append(process(read(scanner), getCodonMap()));
        }
        System.out.println(result);
    }

    public static ImmutableMap<String, String> getCodonMap() throws FileNotFoundException {
        File f = new File(codonTableFile);
        ImmutableMap.Builder<String, String> proteinMapBuilder = ImmutableMap.builder();
        Scanner scanner = new Scanner(f);
        while (scanner.hasNextLine()) {
            String text = scanner.nextLine();
            Matcher matches = rna2Protein.matcher(text);
            while (matches.find()) {
                String codon = matches.group(1);
                String aminoAcid = matches.group(2);
                proteinMapBuilder.put(codon, aminoAcid);
            }
        }
        return proteinMapBuilder.build();
    }

    public static String read(Scanner scanner) {
        return scanner.nextLine();
    }

    public static String process(String input, ImmutableMap<String, String> codonTable) {
        StringBuilder result = new StringBuilder();
        for (String codon : Splitter.fixedLength(3).split(input)) {
            if (!codonTable.get(codon).equals("Stop")) {
                result.append(codonTable.get(codon));
            } else {
                break;
            }
        }
        return result.toString();
    }
}
