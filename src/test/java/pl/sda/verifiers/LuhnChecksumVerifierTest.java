package pl.sda.verifiers;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class LuhnChecksumVerifierTest {

    @Test
    public void shouldReturnTrueForNumber198011() {
        //given
        // dane wejściowe, oczekiwany wynik i obiekt poddawany testom
        final String number = "198011";
        final boolean expectedResult = true;
        IChecksumVerifier verifier = new LuhnChecksumVerifier();

        //when
        // wywołanie metody poddawanej testom
        boolean result = verifier.verify(number);

        //then
        // sprawdzenie poprawności wyniku
        Assert.assertEquals(expectedResult, result);
    }

    @Test
    public void shouldReturnFalseForNumber198010() {
        //given
        final String number = "198010";
        final boolean expectedResult = false;
        IChecksumVerifier verifier = new LuhnChecksumVerifier();

        //when
        boolean result = verifier.verify(number);

        //then
        Assert.assertEquals(expectedResult, result);
    }
}