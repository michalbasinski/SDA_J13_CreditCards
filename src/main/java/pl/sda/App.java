package pl.sda;

import pl.sda.validators.CreditCardValidator;
import pl.sda.validators.ValidationResult;

public class App
{
    public static void main( String[] args )
    {
        if (args != null && args.length > 0) {
            String cardNumber = args[0];
            CreditCardValidator validator = new CreditCardValidator();
            ValidationResult validationResult = validator.validate(cardNumber);

            System.out.println("Wystawca: " + validationResult.getIssuerName());
            System.out.println("Luhn poprawny: " + validationResult.isLuhnPassed());

        } else {
            System.out.println( "Nie podano parametrów!" );
        }
    }
}
