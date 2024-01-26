import java.io.FileReader;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.List;

public class Reader {
    public static List<NobelDij> adatokBeolvasasa(String fajlnev) {
        List<NobelDij> nobelLista = new ArrayList<>();

        try (BufferedReader  reader = new BufferedReader (new FileReader(fajlnev), ';')) {
            reader.readLine();

            String sorStr;
            while ((sorStr = reader.readLine()) != null) {
                String[] sorSplitted = sorStr.split(";");
                NobelDij nobelDij;
                int evszam = Integer.parseInt(sorSplitted[0]);

                if (sorSplitted.length == 3) {
                    nobelDij = new NobelDij(evszam, sorSplitted[1], sorSplitted[2], "");
                }
                else if (sorSplitted.length == 4) {
                    nobelDij = new NobelDij(evszam, sorSplitted[1], sorSplitted[2], sorSplitted[3]);
                }
                else {
                    continue;
                }

                nobelLista.add(nobelDij);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return nobelLista;
    }
}
