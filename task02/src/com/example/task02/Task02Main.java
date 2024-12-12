package com.example.task02;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Task02Main {

    public static void main(String[] args) {

        cycleGrayCode(1)
                .limit(10)
                .forEach(System.out::println);

    }

    public static IntStream cycleGrayCode(int n) {

        if (n < 1 || n > 16) {
            throw new IllegalArgumentException("n должно быть в диапазоне [1,16]");
        }

        //определяем длину массива как 2^n
        int size = 1 << n;

        //создаем массив по правилу Грея
        int[] grayCodes = IntStream.range(0, size)
                .map(i -> i ^ (i >> 1))
                .toArray();

        //нормализуем данные из стрима и сопоставляем с кодом Грея
        return IntStream.iterate(0, i -> (i + 1) % grayCodes.length)
                .map(i -> grayCodes[i]);

    }

}
