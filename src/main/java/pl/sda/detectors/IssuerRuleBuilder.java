package pl.sda.detectors;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class IssuerRuleBuilder {

    public List<IssuerRule> buildIssuerRules() {
        List<IssuerRule> issuerRules = new ArrayList<>();

        String resourcePath = getClass()
                .getClassLoader()
                .getResource("issuer.csv")
                .getPath();

        //konstrukcja try-with-resources - bufferedReader/fileReader zostają zamknięte przez JVM w momencie błędu
        //więcej informacji - https://www.samouczekprogramisty.pl/konstrukcja-try-with-resources-w-jezyku-java/
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(resourcePath))) {


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return issuerRules;
    }
}
