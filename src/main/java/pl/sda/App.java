package pl.sda;

import pl.sda.validators.CreditCardValidator;
import pl.sda.validators.ValidationResult;

public class App
{
    /**
     * Metodzie main należy przekazać parametry
     * numer karty (wymagany, aby otrzymać rezulatat analizy),
     * ścieżkę do pliku csv z regułami (jeśli nie zostanie przekazany zostanie użyty domyślny plik z katalogu /src/main/resources)
     *
     * Parametry należy przekazać korzystając z menu Run -> Edit configurations w polu Program arguments
     * https://www.jetbrains.com/help/idea/setting-configuration-options.html
     */
    public static void main( String[] args )
    {
        if (args != null && args.length > 0) {
            String cardNumber = args[0];

            String customFilePath = null;
            if (args.length > 1) {
                customFilePath = args[1];
            }

            CreditCardValidator validator = new CreditCardValidator();
            ValidationResult validationResult = validator.validate(cardNumber, customFilePath);

            System.out.println("Wystawca: " + validationResult.getIssuerName());
            System.out.println("Luhn poprawny: " + validationResult.isLuhnPassed());

        } else {
            System.out.println( "Nie podano parametrów!" );
        }
    }
}
