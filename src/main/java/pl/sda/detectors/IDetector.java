package pl.sda.detectors;

/**
 * Interfejs definiujący metodę pozwalającą na identyfikację wystawcy karty.
 */
public interface IDetector {

    /**
     * Metoda identyfikująca wystawcę karty na bazie numeru karty i bazy reguł.
     *
     * @param cardNo   numer karty do przetworzenia
     * @param filePath ścieżka do pliku
     * @return nazwa wystawcy
     */
    String detect(String cardNo, String filePath);
}
