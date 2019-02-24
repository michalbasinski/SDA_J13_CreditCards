package pl.sda.validators;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CreditCardValidatorTest {

//generator testowych numerów kart
//https://www.mobilefish.com/services/credit_card_number_generator/credit_card_number_generator.php

//5538952797967959
//5551001284342458
//5205143106994957

    @Test
    public void shouldReturnMasterCardAndTrueFor5149273068100605() {
        //given
        final String cardNumber = "5149273068100605";
        final String expectedIssuer = "Master Card";
        CreditCardValidator validator = new CreditCardValidator();

        //when
        ValidationResult result = validator.validate(cardNumber, null);

        //then
        Assert.assertEquals(expectedIssuer, result.getIssuerName());
        Assert.assertTrue(result.isLuhnPassed());
    }

    @Test
    public void shouldReturnMasterCardAndTrueFor5149273068100605v2() {
        //given
        final String cardNumber = "5149273068100605";

        final ValidationResult expectedResult = new ValidationResult();
        expectedResult.setIssuerName("Master Card");
        expectedResult.setLuhnPassed(true);

        CreditCardValidator creditCardValidator = new CreditCardValidator();

        //when
        ValidationResult result = creditCardValidator.validate(cardNumber, null);

        //then
        Assert.assertEquals(expectedResult, result);
    }
}