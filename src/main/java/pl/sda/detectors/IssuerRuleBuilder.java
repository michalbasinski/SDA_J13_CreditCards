package pl.sda.detectors;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IssuerRuleBuilder {

    public List<IssuerRule> buildIssuerRules(String filePath) {
        List<IssuerRule> issuerRules = new ArrayList<>();

        String resourcePath = getClass()
                .getClassLoader()
                .getResource("issuers.csv")
                .getPath();

        if (filePath != null) {
            resourcePath = filePath;
        }

        //konstrukcja try-with-resources - bufferedReader/fileReader zostają zamknięte przez JVM w momencie błędu
        //więcej informacji - https://www.samouczekprogramisty.pl/konstrukcja-try-with-resources-w-jezyku-java/
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(resourcePath))) {

            //alternatywa dla zastosowania zmiennej boolean firstRow
            //String line = bufferedReader.readLine();

            //zmienna first row ustawiona na true sprawia, że pierwsza linia pliku nie jest wykorzystywana do tworzenia
            //obiektów klasy IssuerRule
            boolean firstRow = true;

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                if (firstRow) {
                    firstRow = false;
                } else {
                    // budowanie nowych obiektów issuerRule:
                    // 1. rozdzielenie linii na 3 wartości (średnik to separator)
                    // 2. stworzenie nowych obiektów klasy IssuerRule z wykorzystaniem konstruktora 3-argumentowego
                    // 3. dodanie nowego obiektu IssuerRule do listy issuerRules
                    String[] tokens = line.split(";");
                    IssuerRule issuerRule = new IssuerRule(tokens[0], tokens[1], Integer.parseInt(tokens[2]));
                    issuerRules.add(issuerRule);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return issuerRules;
    }
}
