package pl.sda.verifiers;

/**
 * Interfejs definiuje metodę, która pozwala na sprawdzenie poprawności sumy kontrolnej.
 */
public interface IChecksumVerifier {

    /**
     * Metoda sprawdzająca poprawność numeru karty.
     *
     * @param cardNumber numer karty do sprawdzenia
     * @return wartość pokazująca czy numer jest poprawny (true/false)
     */
    boolean verify(String cardNumber);
}
