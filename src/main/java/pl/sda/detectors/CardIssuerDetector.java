package pl.sda.detectors;

import java.util.List;

/**
 * Implementacja detektora nazw wystawców kart kredytowych.
 */
public class CardIssuerDetector implements IDetector {

    /**
     * Metoda identyfikująca wystawcę karty na bazie numeru karty i bazy reguł.
     *
     * @param cardNo   numer karty do przetworzenia
     * @param filePath ścieżka do pliku
     * @return nazwa wystawcy
     */
    @Override
    public String detect(String cardNo, String filePath) {
        String result = "Unknown";

        //Algorytm pobiera bazę reguł
        //przeprowadzana jest iteracja
        //dokonane jest sprawdzenie czy numer karty zaczyna się od prefiksu i czy ma odpowiednią długość
        for (IssuerRule rule : getIssuerRules(filePath)) {
            if (cardNo.startsWith(rule.getPrefix())
                    && cardNo.length() == rule.getLength()) {
                result = rule.getName();
                break;
            }
        }

        return result;
    }

    private List<IssuerRule> getIssuerRules(String path) {
//        List<IssuerRule> issuerRules = new ArrayList<>();

//        issuerRules.add(new IssuerRule("Visa", "4", 16));
//        issuerRules.add(new IssuerRule("Master Card", "51", 16));
//        issuerRules.add(new IssuerRule("Master Card", "52", 16));
//        issuerRules.add(new IssuerRule("Master Card", "53", 16));
//        issuerRules.add(new IssuerRule("Master Card", "54", 16));
//        issuerRules.add(new IssuerRule("Master Card", "55", 16));
//        issuerRules.add(new IssuerRule("American Express", "34", 15));
//        issuerRules.add(new IssuerRule("American Express", "37", 15));

        IssuerRuleBuilder issuerRuleBuilder = new IssuerRuleBuilder();
        return issuerRuleBuilder.buildIssuerRules(path);
    }

}
