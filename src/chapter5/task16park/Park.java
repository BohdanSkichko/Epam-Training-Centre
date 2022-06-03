package chapter5.task16park;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Park {
    private final String name;
    private final List<Attraction> attractionList = new ArrayList<>();

    void addAttraction(Attraction attraction) {
        attractionList.add(attraction);
    }

    public Park(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Attraction> getAttractionList() {
        return attractionList;
    }

    @Override
    public String toString() {
        return "Park " +
                name + "\n" +
                attractionList.stream().map(Attraction::toString).collect(Collectors.joining(""));
    }

      static class Attraction {
        private final Double cost;
        private final String time;
        private final Type type;

        public Attraction(Double cost, String time, Type type) {
            this.cost = cost;
            this.time = time;
            this.type = type;
        }

        @Override
        public String toString() {
            return
                    "type: " + type + " " +
                            "cost: " + cost + "UAH " +
                            "time: " + time + " " + "\n";

        }

        public Type getType() {
            return type;
        }

        public Double getCost() {
            return cost;
        }

        public String getTime() {
            return time;
        }

        enum Type {
            HYDRODROME("Hydrodrome"),
            PNEUMATIC_TRAMPLINE("TRAMP_line"),
            INFLATUBLE_SLIDES("Slides"),
            GAME_MAZES("Game"),
            ;
            private final String name;

            Type(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return name;
            }
        }

    }
}


