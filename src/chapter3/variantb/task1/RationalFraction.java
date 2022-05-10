package chapter3.variantb.task1;

//Реализовать методы сложения, вычитания, умножения и деления объектов (для
//тех классов, объекты которых могут поддерживать арифметические действия).
//1. Определить класс Дробь (Рациональная Дробь) в виде пары чисел m и n.
//Объявить и инициализировать массив из k дробей, ввести/вывести значе-
//ния для массива дробей. Создать массив/список/множество объектов и пе-
//редать его в метод, который изменяет каждый элемент массива с четным
//индексом путем добавления следующего за ним элемента.
public class Fraction {
    private final int numerator;
    private final int denominator;

    Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        this.denominator = denominator;
    }
    public static int findGcd(int a, int b) {
        if (b == 0) return a;
        return findGcd(b, a % b);
    }




    public int getN() {
        return numerator;
    }

    public int getM() {
        return denominator;
    }


    @Override
    public String toString() {
        return "Fraction{" +
                "numerator=" + numerator +
                ", denominator=" + denominator +
                '}';
    }
}
