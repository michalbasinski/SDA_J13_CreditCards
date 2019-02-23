package pl.sda.verifiers.alternative;

import pl.sda.verifiers.IChecksumVerifier;

import java.util.LinkedList;
import java.util.List;

//Autor: Mateusz
public class LuhnChecksumVerifierAltOne implements IChecksumVerifier {
    @Override
    public boolean verify(String cardNo) {
        String[] stringArray = cardNo.split("\\B");
        List<Integer> intArray = new LinkedList();
        int result = 0;

        for (int i = 0; i <stringArray.length; i++) {
            intArray.add(i, Integer.parseInt(stringArray[i]));
        }
        for (int j = intArray.size()-2; j >= 0; j -=2) {
            intArray.set(j, intArray.get(j) * 2);
            if (intArray.get(j) >= 10) {
                intArray.set(j,intArray.get(j) - 9);
            }
        }
        for (int i = 0; i <= intArray.size()-1; i++) {
            result = intArray.get(i) + result;
        }
        if (result % 10 == 0) {
            return true;
        } else {
            return false;
        }    }
}
