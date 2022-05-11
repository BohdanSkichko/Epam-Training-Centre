package chapter3.variantb.task1;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {

        RationalFraction rationalFraction = new RationalFraction(13, 12);
        RationalFraction rationalFraction1 = new RationalFraction(17, 3);
        System.out.println(rationalFraction.add(rationalFraction1));
        System.out.println(rationalFraction.minus(rationalFraction1));
        System.out.println(rationalFraction.multi(rationalFraction1));
        System.out.println(rationalFraction.division(rationalFraction));
        System.out.println(rationalFraction);

        RationalFraction[] fractions = new RationalFraction[6];
        fractions[0] = new RationalFraction(2, 12);
        fractions[1] = new RationalFraction(21, 3);
        fractions[2] = new RationalFraction(11, 4);
        fractions[3] = new RationalFraction(23, 12);
        fractions[4] = new RationalFraction(34, 23);
        fractions[5] = new RationalFraction(12, 11);
        modifyEvenElement(fractions);


    }

    static void modifyEvenElement(RationalFraction[] array) {
        for (int i = 0; i < array.length; i++) {
            if (i % 2 == 0 & i + 1 < array.length) {
                array[i] = array[i].add(array[i+1]);
            }
        }
        System.out.println(Arrays.toString(array));

    }
}