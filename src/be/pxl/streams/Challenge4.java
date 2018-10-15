package be.pxl.streams;

import be.pxl.streams.Person.Gender;

import java.util.Arrays;
import java.util.List;

public class Challenge4 {
    public static void main(String[] args) {
        List<Person> personen = Arrays.asList(
                new Person("Sofie", 23, Gender.FEMALE),
                new Person("Adam", 31, Gender.MALE),
                new Person("Bastiaan", 25, Gender.MALE),
                new Person("Berend", 22, Gender.MALE),
                new Person("Aagje", 27, Gender.FEMALE)
        );
        // 1. Geef de gemiddelde leeftijd van alle personen
        // Verwachte output:  Gemiddelde leeftijd: 25.6

        System.out.println("Gemiddelde leeftijd: " + personen.stream().mapToInt(a -> a.getAge()).average().getAsDouble());

        // 2. Hoeveel mannen staan er in de lijst
        // Verwachte output: Aantal mannen: 3

        System.out.println("Aantal mannen: " + personen.stream().filter(s -> s.getGender().equals(Gender.MALE)).count());

        // 3. Hoeveel mannen ouder dan 24 staan er in de lijst
        // Verwachte output: Aantal mannen boven 24: 2

        System.out.println("Aantal mannen boven 24: " + personen.stream().filter(s -> s.getAge() > 24 && s.getGender().equals(Gender.MALE)).count());

        // 4. Geef de gemiddelde leeftijd van alle mannen
        // Gemiddelde leeftijd mannen: 26.0

        System.out.println("Gemiddelde leeftijd mannen: " + personen.stream().filter(s -> s.getGender().equals(Gender.MALE)).mapToInt(s -> s.getAge()).average().getAsDouble());

        // 5. Maak een nieuwe persoon met als naam de eerste letter van iedere persoon in de lijst
        // en als leeftijd de som van alle leeftijden
        // Maak gebruik van de methode .reduce()
Person apple = new Person("klok", personen.stream().mapToInt(s -> s.getAge()).sum(), Gender.MALE);
        personen.add(apple);

    }
}
