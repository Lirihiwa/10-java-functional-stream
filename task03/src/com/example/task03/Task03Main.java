package com.example.task03;

import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.stream.Stream;

public class Task03Main {

    public static void main(String[] args) {

        findMinMax(
                Stream.of(2, 9, 5, 4, 8, 1, 3),
                Integer::compareTo,
                (min, max) ->
                        System.out.println("min: " + min + " / max: " + max)
        );

    }

    public static <T> void findMinMax(
            Stream<? extends T> stream,
            Comparator<? super T> order,
            BiConsumer<? super T, ? super T> minMaxConsumer) {

        Objects.requireNonNull(stream, "stream пустой");
        Objects.requireNonNull(order, "order пустой");
        Objects.requireNonNull(minMaxConsumer, "minMaxConsumer пустой");

        Iterator<? extends T> iter = stream.iterator();

        if (iter.hasNext()) {
            T min = iter.next();
            T max = min;

            while (iter.hasNext()) {
                T element = iter.next();

                if (order.compare(element, max) >= 0) {
                    max = element;
                }
                if (order.compare(element, min) < 0) {
                    min = element;
                }
            }
            minMaxConsumer.accept(min, max);
        } else {
            minMaxConsumer.accept(null, null);
        }
    }
}
