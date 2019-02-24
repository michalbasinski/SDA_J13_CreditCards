package pl.sda.validators;

import pl.sda.detectors.CardIssuerDetector;
import pl.sda.verifiers.LuhnChecksumVerifier;

public class CreditCardValidator {

    public ValidationResult validate(String cardNumber) {
        ValidationResult result = new ValidationResult();

        //utworzenie nowego obiektu klasy CardIssuerDetector
        //wpisanie wyniku metody detect do obiektu result
        CardIssuerDetector cardIssuerDetector = new CardIssuerDetector();
        String issuerName = cardIssuerDetector.detect(cardNumber);
        result.setIssuerName(issuerName);

        //utworzenie nowego obiektu klasy LuhnChecksumVerifier
        //wpisanie wyniku metody verify do obiektu result
        LuhnChecksumVerifier luhnChecksumVerifier = new LuhnChecksumVerifier();
        boolean isLuhnPassed = luhnChecksumVerifier.verify(cardNumber);
        result.setLuhnPassed(isLuhnPassed);

        return result;
    }

}


