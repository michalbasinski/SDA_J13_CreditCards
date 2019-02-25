package pl.sda.validators;

import pl.sda.detectors.CardIssuerDetector;
import pl.sda.verifiers.LuhnChecksumVerifier;

/**
 * Klasa dostarczająca metoda pozwalającą na pełne przetworzenie numery karty i zwracająca informacje na temat
 * wystawcy karty oraz poprawności cyfry kontrolnej określonej przez algorytm Luhna.
 */
public class CreditCardValidator {

    /**
     * Metoda dokonująca pełnej analizy numeru karty.
     *
     * @param cardNumber numer karty do przetworzenia.
     * @param filePath   ścieżka do pliku z regułami, jeśli zostanie przekazana wartość null do zbudowania bazy reguł
     *                   zostanie użyty domyślny plik z katalogu /src/main/resources
     * @return obiekt zawierający wynik analizył
     */
    public ValidationResult validate(String cardNumber, String filePath) {
        ValidationResult result = new ValidationResult();

        //utworzenie nowego obiektu klasy CardIssuerDetector
        //wpisanie wyniku metody detect do obiektu result
        CardIssuerDetector cardIssuerDetector = new CardIssuerDetector();
        String issuerName = cardIssuerDetector.detect(cardNumber, filePath);
        result.setIssuerName(issuerName);

        //utworzenie nowego obiektu klasy LuhnChecksumVerifier
        //wpisanie wyniku metody verify do obiektu result
        LuhnChecksumVerifier luhnChecksumVerifier = new LuhnChecksumVerifier();
        boolean isLuhnPassed = luhnChecksumVerifier.verify(cardNumber);
        result.setLuhnPassed(isLuhnPassed);

        return result;
    }

}


