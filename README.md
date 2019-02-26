# SDA_J13_CreditCards

## Opis programu:
    Projekt SDA_J13_CreditCards to implementacja programu pozwalającego na przeanalizowanie numeru karty kredytowej. Analiza
    numeru składa się z dwóch kroków:
    - identyfikacji wystawcy karty,
    - sprawdzenia poprawności numeru karty poprzez weryfikację cyfry kontrolnej z wykorzystaniem algorytmu Luhna.

    Program podzielony jest na następujące pakiety/moduły:
    - validators - pakiet z klasą zapewniającą metody służące do pełnej analizy numerów kart,
    - detectors - zawiera interfejsy/klasy związane z identyfikacją wystawcy karty,
    - verifiers - zawiera interfejsy/klasy obsługujące weryfkiację poprawności cyfry kontrolnej.
    Najważniejszą klasą jest CardIssuerDetector wystawiająca metodę pozwalającą na pełną analizę numeru karty, która
    przyjmuje jako parametry numer karty oraz ścieżkę do pliku z regułami (jeśli ścieżka do pliku będzie nullem, baza
    reguł zostanie utworzona na bazie pliku issuers.csv w katalogu /src/main/resources.
