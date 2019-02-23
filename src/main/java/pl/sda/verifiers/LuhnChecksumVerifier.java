package pl.sda.verifiers;

public class LuhnChecksumVerifier implements IChecksumVerifier {

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
