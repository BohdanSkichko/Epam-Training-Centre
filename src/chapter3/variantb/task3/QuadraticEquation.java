package chapter3.variantb.task3;

import java.util.Arrays;
import java.util.Objects;
import java.util.OptionalDouble;

public class QuadraticEquation {
    private final double a;
    private final double b;
    private final double c;
    private double firstRoot;
    private double secondRoot;


    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
        if (this.a == 0) throw new IllegalArgumentException(" a can't be 0 ");
    }


    public QuadraticEquation sum(QuadraticEquation that) {
        double a = this.getA() + that.getA();
        double b = this.getB() + that.getB();
        double c = this.getC() + that.getC();
        return new QuadraticEquation(a, b, c);
    }


    public double findExtreme() {
        double x;
        double determinant = findDeterminant(getA(), getB(), getC());
        x = determinant / 4 * getA();
        return x;
    }

    public void findGrowAndDecay() {
        if (getA() > 0) {
            System.out.println("function decay (-Infinity;" + findExtreme() + "]" + "and growth [" + findExtreme() + ";Infinity)");
        }
        System.out.println();
        if (getA() < 0)
            System.out.println("function decay [" + findExtreme() + ";Infinity) and growth (-Infinity;" + findExtreme() + ")");
    }


    public static double findDeterminant(double a, double b, double c) {
        double determinant;
        determinant = (b * b - (4 * a * c));
        return determinant;
    }


    public double[] findRoots() {
        double determinant = findDeterminant(getA(), getB(), getC());
        if (determinant < 0) throw new IllegalArgumentException("no roots");
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
        return Double.compare(that.a, a) == 0 && Double.compare(that.b, b) == 0 && Double.compare(that.c, c) == 0 && Double.compare(that.firstRoot, firstRoot) == 0 && Double.compare(that.secondRoot, secondRoot) == 0;
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
