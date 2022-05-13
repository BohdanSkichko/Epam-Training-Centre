package chapter3.variantb.task3;


import java.util.Arrays;
import java.util.Formatter;
import java.util.OptionalDouble;


public class Runner {
    public static void main(String[] args) {
        QuadraticEquation quadraticEquation = new QuadraticEquation(8, 19, 2);
        QuadraticEquation quadraticEquation1 = new QuadraticEquation(-12, -2, 34);

        QuadraticEquation[] quadraticEquations = new QuadraticEquation[4];
        quadraticEquations[0] = new QuadraticEquation(2, 5, 2);
        quadraticEquations[1] = new QuadraticEquation(-12, 12, 4);
        quadraticEquations[2] = new QuadraticEquation(8, 19, 2);
        quadraticEquations[3] = new QuadraticEquation(-20, -2, 3);
        System.out.println(Arrays.toString(quadraticEquations[0].findRoots()));
        System.out.println(Arrays.toString(quadraticEquations[1].findRoots()));
        System.out.println(Arrays.toString(quadraticEquations[2].findRoots()));
        System.out.println(Arrays.toString(quadraticEquations[3].findRoots()));
//        QuadraticEquation.GrowAndDecay.findFunctionIntervals(quadraticEquation1);
        System.out.println(QuadraticEquation.findFunctionIntervals(quadraticEquation));


        System.out.println(findMinRoot(quadraticEquations));
        System.out.println(findMaxRoot(quadraticEquations));


        System.out.println(quadraticEquation.findExtreme());
        System.out.println(quadraticEquation1.findExtreme());

    }

    public static double findMinRoot(QuadraticEquation[] array) {
        double min = array[0].getFirstRoot();
        for (QuadraticEquation quadraticEquation : array) {
            if (min > quadraticEquation.getFirstRoot()) {
                min = quadraticEquation.getFirstRoot();
            }
            if (min > quadraticEquation.getSecondRoot()) {
                min = quadraticEquation.getSecondRoot();
            }

        }
        return min;
    }

    public static double findMaxRoot(QuadraticEquation[] array) {
        double max = array[0].getFirstRoot();
        for (QuadraticEquation quadraticEquation : array) {
            if (max < quadraticEquation.getFirstRoot()) {
                max = quadraticEquation.getFirstRoot();
            }
            if (max < quadraticEquation.getSecondRoot()) {
                max = quadraticEquation.getSecondRoot();
            }

        }
        return max;
    }

}