package pl.sda.detectors;

import java.util.ArrayList;
import java.util.List;

public class CardIssuerDetector implements IDetector {

    @Override
    public String detect(String cardNo) {
        return null;
    }

    private List<IssuerRule> getIssuerRules() {
        List<IssuerRule> issuerRules = new ArrayList<>();

        issuerRules.add(new IssuerRule("Visa", "4", 16));
        issuerRules.add(new IssuerRule("Master Card", "51", 16));
        issuerRules.add(new IssuerRule("Master Card", "52", 16));
        issuerRules.add(new IssuerRule("Master Card", "53", 16));
        issuerRules.add(new IssuerRule("Master Card", "54", 16));
        issuerRules.add(new IssuerRule("Master Card", "55", 16));
        issuerRules.add(new IssuerRule("American Express", "34", 15));
        issuerRules.add(new IssuerRule("American Express", "37", 15));

        return issuerRules;
    }

}
