# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([UC2](#uc2), [BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([UC3](#uc3), [BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu. ([UC4](#uc4))
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu. ([UC5](#uc5), [BR3](#br3))

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC5](#uc5): Przekazanie produktu Kupującemu
* [UC6](): Usunięcie aukcji

[Kupujący](#ac2): 
* [UC2](#uc2): Złożenie oferty na aukcj
* [UC3](#uc3): Wygrana aukcji
* [UC4](#uc4): Przekazanie płatności za produkt
* [UC7](): Przeglądanie aukcji

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

---

<a id="uc2"></a>
### UC2: Złożenie oferty na aukcj

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**

1. [Kupujący](#ac2) wybiera aukcję, na której chce złożyć ofertę.
2. System wyświetla aktualnie najwyższą ofertę.
3. [Kupujący](#ac2) wprowadza kwotę wyższą niż aktualna najwyższa oferta.
4. System weryfikuje, czy kwota spełnia minimalne wymagania dla oferty. (BR1)
5. System akceptuje ofertę i aktualizuje najwyższą ofertę na aukcji.

**Scenariusze alternatywne:**

4.A. Podano kwotę niższą lub równą aktualnej najwyższej ofercie.
* 4.A.1. System informuje o niewystarczającej kwocie.
* 4.A.2. Przejdź do kroku 3.


---
<a id="uc3"></a>

### UC3: Wygrana aukcji

**Aktorzy:** [Kupujący](#ac2), [Sprzedający](#ac1)

**Scenariusz główny:**

1. Aukcja dobiega końca, a czas trwania aukcji upływa.
2. System identyfikuje [Kupującego](#ac2) z najwyższą ofertą jako zwycięzcę aukcji. (BR2)
3. System informuje zwycięskiego [Kupującego](#ac2) o wygranej aukcji.
4. System informuje [Sprzedającego](#ac1) o wygraniu aukcji przez [Kupującego](#ac2).

---

<a id="uc4"></a>
### UC4: Przekazanie płatności za produkt

**Aktorzy:** [Kupujący](#ac2), [Sprzedający](#ac1)

**Scenariusz główny:**

1. [Kupujący](#ac2) rozpoczyna proces płatności za wygrany produkt.
2. System przekazuję [kupującemu](#ac2) kwotę do zapłaty i możliwe metody płatności.
3. [Kupujący](#ac2) wybiera metodę płatności i dokonuje płatności.
4. System weryfikuje, czy płatność została poprawnie przetworzona.
5. System potwierdza płatność [Kupującemu](#ac2) oraz informuje [Sprzedającego](#ac1) o otrzymaniu płatności.

**Scenariusze alternatywne:**  
4.A. Wystąpił problem z płatnością.

* 4.A.1. System informuje [Kupującego](#ac2) o błędzie i umożliwia ponowną próbę dokonania płatności.
* 4.A.2. Przejdź do kroku 2.

---
<a id="uc5"></a>
### UC5: Przekazanie produktu Kupującemu

**Aktorzy:** [Kupujący](#ac2), [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) otrzymuje informację o otrzymaniu płatności za produkt.
2. System prosi [kupującego](#ac2) o podanie metody dostawy oraz danych.
3. [Kupujący](#ac2) podaje dane do wysyłki.
4. System przekazuje dane [sprzedającemu](#ac1).
5. [Sprzedający](#ac1) przygotowuje produkt do przekazania [Kupującemu](#ac2).
6. [Sprzedający](#ac1) wysyła produkt lub organizuje jego odbiór przez [Kupującego](#ac2).
7. System oznacza aukcję jako [zamknietą](#br3).


**Scenariusze alternatywne:**  
4.A [Kupujący](#ac2) podał błędne dane
* 4.A.1 Przejdź do kroku 3  

6.A. Wystąpiły problemy z dostarczeniem produktu.
* 6.A.1. [Sprzedający](#ac1) kontaktuje się z [Kupującym](#ac2) w celu rozwiązania problemu.
* 6.A.2. Przejdź do kroku 5

---

## Obiekty biznesowe (inaczej obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN. Nie jest możliwe wtcofanie oferty


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

<a id="br3"></a>
### BR3: Zamkniecie aukcji

Aukcja jest zamykana przez system w momencie gdy [kupujący](#ac2) otrzyma produkt.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt |
| ------------------------------------------------- | ------ | ------- |
| [UC1](#uc1): Wystawienia produktu na aukcję       |    C   |    C    |
| [UC2](#uc2): Złożenie oferty na aukcj             |    U   |    -    |
| [UC3](#uc3): Wygrana aukcji                       |    R   |    R    |
| [UC4](#uc4): Przekazanie płatności za produkt     |    R   |   -     |
| [UC5](#uc5): Przekazanie produktu Kupującemu      |    U   |   U  |

