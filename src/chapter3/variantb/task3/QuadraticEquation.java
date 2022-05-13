package chapter3.variantb.task3;

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
        this.firstRoot = findRoots()[0];
        this.secondRoot = findRoots()[1];


    }

    public double findExtreme() {
        double extreme;
        double determinant = findDeterminant();
        extreme = determinant / 4 * getA();
        return extreme;
    }

    public static GrowAndDecay findFunctionIntervals(QuadraticEquation quadraticEquation) {
        String decay;
        String grow;
        if (quadraticEquation.getA() > 0) {
            decay = "(-Infinity;" + quadraticEquation.findExtreme() + "]";
            grow = "[" + quadraticEquation.findExtreme() + ";Infinity)";
        } else {
            decay = "[" + quadraticEquation.findExtreme() + ";Infinity)";
            grow = "(-Infinity;" + quadraticEquation.findExtreme() + "]";
        }
        return new GrowAndDecay(decay, grow);

    }

    private static class GrowAndDecay {
        String grow;
        String decay;

        public GrowAndDecay(String grow, String decay) {
            this.grow = grow;
            this.decay = decay;
        }

        public static void findFunctionIntervals(QuadraticEquation quadraticEquation) {
            if (quadraticEquation.getA() > 0) {
                System.out.println("function decay (-Infinity;" + quadraticEquation.findExtreme() + "]" +
                        "and growth [" + quadraticEquation.findExtreme() + ";Infinity)");
            } else {
                System.out.println("function decay [" + quadraticEquation.findExtreme() +
                        ";Infinity) and function grow (-Infinity;" + quadraticEquation.findExtreme() + "]");
            }
        }


        public String getGrow() {
            return grow;
        }

        @Override
        public String toString() {
            return "GrowAndDecay{" +
                    "grow='" + grow + '\'' +
                    ", decay='" + decay + '\'' +
                    '}';
        }

        public String getDecay() {
            return decay;
        }
    }


    public double findDeterminant() {
        double determinant;
        determinant = (b * b - (4 * a * c));
        return determinant;
    }


    public double[] findRoots() {
        double determinant = findDeterminant();
        if (determinant < 0) throw new IllegalArgumentException("no roots");
        double firstRoot;
        double secondRoot;
        if (determinant > 0) {
            firstRoot = (-getB() + Math.sqrt(determinant)) / (2 * getA());
            secondRoot = (-getB() - Math.sqrt(determinant)) / (2 * getA());
        } else firstRoot = secondRoot = -getB() / (2 * getA());
        return new double[]{firstRoot, secondRoot};
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
