package chapter5.task8city;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class City {
    private final String name;
    private final AddressInfo address;

    public City(String name, AddressInfo address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public String toString() {
        return "City " +
                "name " + name + "\n" +
                address;

    }

    public String getName() {
        return name;
    }

    static class AddressInfo {
        private final List<Street> streetList = new ArrayList<>();
        private final List<Avenue> avenueList = new ArrayList<>();
        private final List<Square> squareList = new ArrayList<>();

        int getQuantityStreet() {
            return streetList.size();
        }

        int getQuantityAvenue() {
            return avenueList.size();
        }

        int getQuantitySquare() {
            return squareList.size();
        }

        @Override
        public String toString() {
            return "QuantityStreet: " + getQuantityStreet() + "\n" +
                    "QuantityAvenue: " + getQuantityAvenue() + "\n" +
                    "QuantitySquare: " + getQuantitySquare() + "\n" +
                    "Street: " + streetList.stream()
                    .map(Street::toString)
                    .collect(Collectors.joining(",", "", ".")) + "\n" +
                    "Avenue: " + avenueList.stream()
                    .map(Avenue::toString)
                    .collect(Collectors.joining(",", "", ".")) + "\n" +
                    "Square: " + squareList.stream()
                    .map(Square::toString)
                    .collect(Collectors.joining(",", "", "."));
        }


        void addStreet(Street s) {
            streetList.add(s);
        }

        void addAvenue(Avenue a) {
            avenueList.add(a);
        }

        void addSquare(Square s) {
            squareList.add(s);
        }
    }
}
