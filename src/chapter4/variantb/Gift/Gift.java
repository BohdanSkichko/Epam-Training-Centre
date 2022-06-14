package chapter4.variantb.Gift;

import chapter4.variantb.Gift.sweets.Sweet;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Gift {

    private final List<Sweet> sweetsList = new ArrayList<>();


    void addSweet(Sweet someSweet) {
        sweetsList.add(someSweet);
    }

    Sweet findSweets(int sugarMin, int sugarMax) {
        if (sugarMin < 0 || sugarMin > 100)
            throw new IllegalArgumentException("incorrect input \"SugarMin\"");
        if (sugarMax < sugarMin)
            throw new IllegalArgumentException("incorrect input \"SugarMax\"");
        for (Sweet s : sweetsList) {
            if (sugarMin <= s.getSugar() && s.getSugar() <= sugarMax) {
                return s;
            }
        }
        return null;
    }

    void sortBySugar() {
        sweetsList.sort(Comparator.comparing(Sweet::getSugar));
    }

    void sortByWeight() {
        sweetsList.sort(Comparator.comparing(Sweet::getWeight));
    }


    public int giftWeight() {
        int giftWeith = 0;
        for (Sweet s : sweetsList) {
            giftWeith += s.getWeight();
        }
        return giftWeith;
    }

    @Override
    public String toString() {
        return "Gift" + "\n" +
                "weight=" + giftWeight() + "\n" +
                sweetsList.stream()
                        .map(Sweet::toString)
                        .collect(Collectors.joining(""));
    }

    public List<Sweet> getSweetsList() {
        return sweetsList;
    }

}
