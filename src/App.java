/*
* File: App.java
* Author: Németh Angéla
* Copyright: 2024, Németh Angéla
* Group: Szoft II-1-E
* Date: 2024-01-26
* Github: https://github.com/NemethAngela/Paclient
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class App {

    static List<NobelDij> nobelLista;

    public static void main(String[] args) throws Exception {
        nobelLista = Reader.adatokBeolvasasa("nobel.csv");
        //kiir();

        // 3. feladat: Artur B. McDonald milyen típusú
        //  díjat kapott! Feltételezheti, hogy életében csak egyszer kapott Nobel­ díjat.
        System.out.println("3. feladat");
        NobelDij result = findNobelDijByName("Arthur B.", "McDonald");
        result.kiir();

        // 4. feladat: ki kapott 2017-ben irodalmi Nobel-díjat!
        System.out.println("4. feladat");
        List<NobelDij> resultList = findNobelDijByYearAndType(2017, "irodalmi");
        kiirNobelLista(resultList);

        // 5. feladat: mely szervezetek kaptak béke Nobel-díjai 1990-től napjainkig!
        System.out.println("5. feladat");
        List<NobelDij> resultList2 = findCorpNobelDijFromYear(1990);
        kiirNobelLista(resultList2);

        // 6. feladat: A Curie család több tagja is kapott díjat. melyik évben a család melyik tagja milyen díjat kapott!
        System.out.println("6. feladat");
        List<NobelDij> resultList3 = findNobelDijByVezeteknevPart("Curie");
        kiirNobelLista(resultList3);

        // 7. feladat: melyik típusú díjból hány darabot osztottak ki a Nobel-díj történelme folyamán!
        System.out.println("7. feladat");
        listSumOfNobelDijakByType();

        // 8. feladat: Hozzon létre orvosi.txt néven egy UTF-8 kódolású szöveges állományt, amely tartalmazza az
        // összes kiosztott orvosi Nobel-díj adatait! A fájlban szerepeljen kettősponttal elválasztva a
        // kiosztás éve és a díjazott teljes neve! A sorok évszám szerint növekvő rendben legyenek az
        // állományban!
        System.out.println("8. feladat");
        List<NobelDij> orvosNobelDijak = getNobelDijakByTipus("orvosi");
        Writer.WriteFile("orvosi.txt", orvosNobelDijak);
        System.out.println("A kiírás sikeresen befejeződött");
    }

    private static void kiirNobelLista(List<NobelDij> lista) {
        for (NobelDij nobelDij : lista) {
            nobelDij.kiir();
        }
    }

    private static NobelDij findNobelDijByName(String keresztnev, String vezeteknev) {
        for (NobelDij nobelDij : nobelLista) {
            if(nobelDij.getKeresztnev().equals(keresztnev) && nobelDij.getVezeteknev().equals(vezeteknev)) {
                return nobelDij;
            }
        }

        return null;
    }

    private static List<NobelDij> findNobelDijByYearAndType(int year, String type) {
        List<NobelDij> lista = new ArrayList<>();;

        for (NobelDij nobelDij : nobelLista) {
            if(nobelDij.getEvszam() == year && nobelDij.getTipus().equals(type)) {
                lista.add(nobelDij);
            }
        }

        return lista;
    }

    private static List<NobelDij> findCorpNobelDijFromYear(int yearFrom) {
        List<NobelDij> lista = new ArrayList<>();;

        for (NobelDij nobelDij : nobelLista) {
            if(nobelDij.getEvszam() >= yearFrom && nobelDij.getVezeteknev().equals("")) {
                lista.add(nobelDij);
            }
        }

        return lista;
    }

    private static List<NobelDij> findNobelDijByVezeteknevPart(String vezeteknevPart) {
        List<NobelDij> lista = new ArrayList<>();;

        for (NobelDij nobelDij : nobelLista) {
            if(nobelDij.getVezeteknev().contains(vezeteknevPart)) {
                lista.add(nobelDij);
            }
        }

        return lista;
    }

    private static void listSumOfNobelDijakByType(){
        Map<String, Integer> stringIntMap = new HashMap<>();

        for (NobelDij nobelDij : nobelLista) {
            if (stringIntMap.get(nobelDij.getTipus()) == null) {
                stringIntMap.put(nobelDij.getTipus(), 1);
            } 
            else {
                int currentCount = stringIntMap.get(nobelDij.getTipus());
                stringIntMap.put(nobelDij.getTipus(), currentCount + 1);
            }
        }

        for (Map.Entry<String, Integer> entry : stringIntMap.entrySet()) {
            String tipus = entry.getKey();
            int darab = entry.getValue();

            System.out.println("Tipus: " + tipus + ", darab: " + darab);
        }
    }

    private static List<NobelDij> getNobelDijakByTipus(String tipus) {
        List<NobelDij> lista = new ArrayList<>();;

        for (NobelDij nobelDij : nobelLista) {
            if(nobelDij.getTipus().equals(tipus)) {
                lista.add(nobelDij);
            }
        }

        return lista;
    }
}
