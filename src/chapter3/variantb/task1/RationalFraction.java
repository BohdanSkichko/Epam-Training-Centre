package chapter3.variantb.task1;

import java.util.Arrays;

//Реализовать методы сложения, вычитания, умножения и деления объектов (для
//тех классов, объекты которых могут поддерживать арифметические действия).
//1. Определить класс Дробь (Рациональная Дробь) в виде пары чисел m и n.
//Объявить и инициализировать массив из k дробей, ввести/вывести значе-
//ния для массива дробей. Создать массив/список/множество объектов и пе-
//редать его в метод, который изменяет каждый элемент массива с четным
//индексом путем добавления следующего за ним элемента.
public class RationalFraction {
    private final int numerator;
    private final int denominator;


    public RationalFraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
        if (this.denominator == 0) throw new IllegalArgumentException("error enter denominator");
    }


    public RationalFraction add(RationalFraction that) {
        int numerator = this.getNumerator() * that.getDenominator() + this.getDenominator()* that.getDenominator();
        int denominator = this.getDenominator() * that.getDenominator();
        return createSimplified(numerator, denominator);
    }

    public RationalFraction minus(RationalFraction that) {
        int numerator = this.getNumerator() * that.getNumerator() - this.getDenominator() * that.getNumerator();
        int denominator = this.getDenominator() * that.getDenominator();
        return createSimplified(numerator, denominator);
    }

    public RationalFraction division(RationalFraction that) {
        int numerator = this.getNumerator() * that.getDenominator();
        int denominator = this.getDenominator() * that.getDenominator();
        return createSimplified(numerator, denominator);
    }

    public RationalFraction multi(RationalFraction that) {
        int numerator = this.getNumerator() * that.getNumerator();
        int denominator = this.getDenominator() * that.getDenominator();
        return createSimplified(numerator, denominator);
    }

    public static int findGcd(int a, int b) {
        if (b == 0) return a;
        return findGcd(b, a % b);
    }

    public static RationalFraction createSimplified(int numerator, int denominator) {

        int gcd = findGcd(numerator, denominator);
        if (gcd < 1) return new RationalFraction(numerator, denominator);
        numerator = numerator / gcd;
        denominator = denominator / gcd;

        return new RationalFraction(numerator, denominator);


    }



    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }


    @Override
    public String toString() {
        return "RationalFraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
