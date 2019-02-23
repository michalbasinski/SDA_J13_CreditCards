package pl.sda.detectors;

import org.junit.Assert;
import org.junit.Test;

public class CardIssuerDetectorTest {

    @Test
    public void shouldReturnMasterCard() {
        //given
        final String cardNumber = "5500000000000000";
        final String expectedResult = "Master Card";
        final IDetector detector = new CardIssuerDetector();

        //when
        String result = detector.detect(cardNumber);

        //then
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void shouldReturnVisa() {
        //given
        final String cardNumber = "4500000000000000";
        final String expectedResult = "Visa";
        final IDetector detector = new CardIssuerDetector();

        //when
        String result = detector.detect(cardNumber);

        //then
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void shouldReturnUnknown() {
        //given
        final String cardNumber = "0000000000000000";
        final String expectedResult = "Unknown";
        final IDetector detector = new CardIssuerDetector();

        //when
        String result = detector.detect(cardNumber);

        //then
        Assert.assertEquals(expectedResult, result);
    }
}