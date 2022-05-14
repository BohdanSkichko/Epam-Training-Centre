package chapter3.variantb.task3;


import java.security.KeyPairGenerator;
import java.util.Objects;


public class QuadraticEquation {
    private final double a;
    private final double b;
    private final double c;
    private final double firstRoot;
    private final double secondRoot;


    public QuadraticEquation(double a, double b, double c) {
        if (a == 0) throw new IllegalArgumentException(" a can't be 0 ");
        this.a = a;
        this.b = b;
        this.c = c;
        this.firstRoot = findRoots().getFirst();
        this.secondRoot = findRoots().getSecond();
    }

    public double findDeterminant() {
        double determinant;
        determinant = (b * b - (4 * a * c));
        return determinant;
    }

    public double findExtreme() {
        double extreme;
        double determinant = findDeterminant();
        extreme = determinant / 4 * getA();
        return extreme;
    }

    public GrowAndDecay findFunctionIntervals() {
        String decay;
        String grow;
        if (getA() > 0) {
            decay = "(-Infinity;" + findExtreme() + "]";
            grow = "[" + findExtreme() + ";Infinity)";
        } else {
            decay = "[" + findExtreme() + ";Infinity)";
            grow = "(-Infinity;" + findExtreme() + "]";
        }
        return new GrowAndDecay(decay, grow);

    }


    public Root findRoots() {
        double determinant = findDeterminant();
        if (determinant < 0) throw new IllegalArgumentException("no roots");
        double firstRoot;
        double secondRoot;
        if (determinant > 0) {
            firstRoot = (-getB() + Math.sqrt(determinant)) / (2 * getA());
            secondRoot = (-getB() - Math.sqrt(determinant)) / (2 * getA());
        } else firstRoot = secondRoot = -getB() / (2 * getA());
        return new Root(firstRoot, secondRoot);

    }

    private record GrowAndDecay(String grow, String decay) {


        public String getGrow() {
            return grow;
        }

        public String getDecay() {
            return decay;
        }
    }

    private record Root(double first, double second) {

        public double getFirst() {
            return first;
        }

        public double getSecond() {
            return second;
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuadraticEquation that = (QuadraticEquation) o;
        return Double.compare(that.a, a) == 0 && Double.compare(that.b, b) == 0 &&
                Double.compare(that.c, c) == 0 && Double.compare(that.firstRoot, firstRoot) == 0 &&
                Double.compare(that.secondRoot, secondRoot) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, c, firstRoot, secondRoot);
    }


    @Override
    public String toString() {
        return "QuadraticEquation{" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public double getSecondRoot() {
        return secondRoot;
    }

    public double getFirstRoot() {
        return firstRoot;
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }
}
