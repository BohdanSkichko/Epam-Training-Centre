package chapter3.variantb.task3;


import java.util.Arrays;
import java.util.Formatter;
import java.util.OptionalDouble;


public class Runner {
    public static void main(String[] args) {
        QuadraticEquation quadraticEquation = new QuadraticEquation(4, 7, 1);
        QuadraticEquation quadraticEquation1 = new QuadraticEquation(3, -1, -3);
        QuadraticEquation[] quadraticEquations = new QuadraticEquation[4];
        quadraticEquations[0] = new QuadraticEquation(12, 45, 2);
        quadraticEquations[1] = new QuadraticEquation(1, -12, 4);
        quadraticEquations[2] = new QuadraticEquation(-12, 23, 2.);
        quadraticEquations[3] = new QuadraticEquation(-12, -2, 34);
//        System.out.println(Arrays.toString(quadraticEquation.findRoots()));
        System.out.println(Arrays.toString(quadraticEquations[0].findRoots()));
        System.out.println(Arrays.toString(quadraticEquations[1].findRoots()));
        System.out.println(Arrays.toString(quadraticEquations[2].findRoots()));
        System.out.println(Arrays.toString(quadraticEquations[3].findRoots()));
//        findMinMaxRoots(quadraticEquations);


        //        System.out.println(quadraticEquation.findExtreme());
//        System.out.println(quadraticEquation1.findExtreme());
//        quadraticEquation1.findGrowAndDecay();
//        quadraticEquation.findGrowAndDecay();
//
    }

//    public static void findMinMaxRoots(QuadraticEquation[] array) {
//        OptionalDouble root = OptionalDouble.empty();
//        for (int i = 0; i < array.length; i++) {
//            OptionalDouble max = Arrays.stream(array[i].findRoots()).max();
//            if (Arrays.stream(array[i + 1].findRoots()).max() > max) {
//                max = Arrays.stream(array[i + 1].findRoots()).max();
//            }
//
//            root = max;
//        }
//        System.out.println(root);
//
//    }
}