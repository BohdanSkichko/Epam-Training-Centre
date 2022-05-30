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

    void findSweets(int sugarMin, int sugarMax) {
        for (Sweet s : sweetsList) {
            if (sugarMin <= s.getSugar() && s.getSugar() <= sugarMax) {
                System.out.println(s);
            }
        }
    }

    void sortSugar() {
        sweetsList.sort(new sugarComparator());
    }

    void sortWeight() {
        sweetsList.sort(new weightComparator());
    }


    public int giftWeight() {
        int giftWeith = 0;
        for (Sweet s : sweetsList) {
            giftWeith += s.getWeight();
        }
        return giftWeith;
    }


    private static class weightComparator implements Comparator<Sweet> {

        @Override
        public int compare(Sweet o1, Sweet o2) {
            return o1.getWeight() - o2.getWeight();
        }
    }

    private static class sugarComparator implements Comparator<Sweet> {
        @Override
        public int compare(Sweet o1, Sweet o2) {
            return (int) (o1.getSugar() - o2.getSugar());
        }
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
