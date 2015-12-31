import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;


/**
 * Created by Jessica on 11/28/2015.
 */
public class Gc {
    public static void main(String[] args) throws FileNotFoundException {
        String s = "in/rosalind_";
        s = s.concat(new Object() {

        }.getClass().getEnclosingClass().getSimpleName().toLowerCase()).concat(".txt");
        File f = new File(s);
        try (Scanner scanner = new Scanner(f)) {
            GcContent highest = process(read(scanner));
            System.out.println(highest.name);
            System.out.println(highest.gcContent);
        }
    }

    public static Collection<GcContent> read(Scanner scanner) {
        ArrayList<GcContent> data = new ArrayList<>();
        String curName = "";
        StringBuilder curData = new StringBuilder();
        do {
            String curLine = scanner.nextLine();
            if (curLine.charAt(0) == '>') {
                if (curName.length() != 0) {
                    data.add(new GcContent(curName, curData.toString()));
                }
                curName = curLine.substring(1);
                curData = new StringBuilder();
            } else {
                curData.append(curLine);
            }
        } while (scanner.hasNextLine());
        data.add(new GcContent(curName, curData.toString()));
        return data;
    }

    public static GcContent process(Collection<GcContent> data) {
        return data.stream()
                .max((gc1, gc2) -> Double.compare(gc1.gcContent, gc2.gcContent))
                .get();
    }

    private static class GcContent {
        public final String name;
        public final String dna;
        public final double gcContent;

        public GcContent(String name, String dna) {
            this.name = name;
            this.dna = dna;
            gcContent = calculateGcContent(dna);
        }

        public static double calculateGcContent(String dna) {
            int gcCount = 0;
            for (int i = 0; i < dna.length(); i++) {
                if (dna.charAt(i) == 'G' || dna.charAt(i) == 'C') {
                    gcCount++;
                }
            }
            return gcCount / (double) dna.length() * 100;
        }
    }
}
