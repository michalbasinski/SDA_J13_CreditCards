package pl.sda.verifiers.alternative;

import pl.sda.verifiers.IChecksumVerifier;

//Autor: Dominik
public class LuhnChecksumVerifierAltThree implements IChecksumVerifier {
    @Override
    public boolean verify(String cardNumber) {
        int[] intArray = new int[cardNumber.length()];

        //pozielić:
        for (int i = 0; i < cardNumber.length(); i++) {
            intArray[i] = Integer.parseInt(cardNumber.substring(i, i + 1));
        }

        //w lewą stronę
        for (int i = intArray.length - 2; i >= 0; i = i - 2) {

            //podwajamy co drugą
            int x = intArray[i];
            x = x * 2;

            //jeśil większa od 9, sumuj cyfry
            if (x > 9) {
                x = x - 9;
            }
            //przypisuje:
            intArray[i] = x;
        }

        //do kupy:

        int addTotal = 0;

        for (int i = 0; i < intArray.length; i++) {
            addTotal += intArray[i];
        }

        //czy podzielne przez 10?

        if (addTotal % 10 == 0) {
            return true;
        } else {
            return false;
        }
    }
}
