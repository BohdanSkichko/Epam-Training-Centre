package chapter4.variantb.Gift.sweets;

public abstract class Sweet implements Comparable<Sweet> {
    private final double sugar;
    private final int weight;


    public Sweet(double sugar, int weight) {
        this.sugar = sugar;
        this.weight = weight;
    }


    public double getSugar() {
        return sugar;
    }

    public int getWeight() {
        return weight;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Sweet sweets)) return false;

        if (Double.compare(sweets.getSugar(), getSugar()) != 0) return false;
        return getWeight() == sweets.getWeight();
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(getSugar());
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + getWeight();
        return result;
    }

    @Override
    public String toString() {
        return
                "sugar=" + sugar + "% " +
                        "weight=" + weight + "g " +
                        "\n";
    }


    @Override
    public int compareTo(Sweet that) {
        return this.weight - that.weight;
    }
}
