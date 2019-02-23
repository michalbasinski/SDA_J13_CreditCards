package pl.sda.verifiers.alternative;

import pl.sda.verifiers.IChecksumVerifier;

//Autor: Wojtek
public class LuhnChecksumVerifierAltTwo implements IChecksumVerifier {
    @Override
    public boolean verify(String cardNumber) {
        String[] cardNumberToArray = cardNumber.split("\\B");
        int[] cardNumberToIntArray = new int[cardNumberToArray.length];
        int result = 0;

        for (int i = 0; i < cardNumberToArray.length; i++) {
            cardNumberToIntArray[i] = Integer.parseInt(cardNumberToArray[i]);
        }
        for (int j = cardNumberToIntArray.length - 2; j >= 0; j = j - 2) {

            cardNumberToIntArray[j] = cardNumberToIntArray[j] * 2;
            if (cardNumberToIntArray[j] >= 10) {
                cardNumberToIntArray[j] = cardNumberToIntArray[j] - 9;
            }
        }
        for (int i = cardNumberToIntArray.length - 1; i >= 0 ; i--) {
            result = cardNumberToIntArray[i] + result;
        }
        if (result % 10 == 0){
            return true;
        }
        return false;
    }
}
