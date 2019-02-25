package pl.sda.verifiers;

/**
 * Implementacja interfejsu IChecksumVerifier wykorzystująca algorytm Luhna do sprawdzania porawności numeru karty.
 */
public class LuhnChecksumVerifier implements IChecksumVerifier {

    /**
     * Metoda sprawdzająca poprawność numeru karty z wykorzystaniem algorytmu Luhna.
     *
     * @param cardNumber numer karty do sprawdzenia
     * @return wartość pokazująca czy numer jest poprawny (true/false)
     */
    @Override
    public boolean verify(String cardNumber) {

        char[] chars = cardNumber.toCharArray();
        int counter = 1;
        long sum = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            Integer increment = Integer.parseInt(((Character) chars[i]).toString());
            increment = counter % 2 == 0 ? increment * 2 : increment;
            increment = increment >= 10 ? increment - 9 : increment;
            sum += increment;
            counter++;
        }
        return sum % 10 == 0;
    }
}
