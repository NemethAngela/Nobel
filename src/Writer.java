import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Writer {
    public static void WriteFile(String fileName, List<NobelDij> nobelDijak) {
        Collections.sort(nobelDijak, Comparator.comparingInt(NobelDij::getEvszam));     //évszám szerint rendezés növekvő

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, false))) {
            for (NobelDij nobelDij : nobelDijak) {
                //nobelDij.setVezeteknev("Dr. " + nobelDij.getVezeteknev());        //vezetéknév változtatása, set-el
                writer.write(nobelDij.getEvszam() + ":" + nobelDij.getVezeteknev() + " " + nobelDij.getKeresztnev());
                writer.newLine();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
