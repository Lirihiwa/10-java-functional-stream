package com.example.task01;

import java.io.IOException;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;

public class Task01Main {
    public static void main(String[] args) throws IOException, NullPointerException {

        // TODO С корректно реализованным методом ternaryOperator должен компилироваться и успешно работать следующий код:

        Predicate<Object> condition = Objects::isNull;
        Function<Object, Integer> ifTrue = obj -> 0;
        Function<CharSequence, Integer> ifFalse = CharSequence::length;
        Function<String, Integer> safeStringLength = ternaryOperator(condition, ifTrue, ifFalse);

        System.out.println(safeStringLength.apply("null3"));
    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {

        Objects.requireNonNull(condition, "condition не может быть null");
        Objects.requireNonNull(ifTrue, "ifTrue не может быть null");
        Objects.requireNonNull(ifFalse, "ifFalse не может быть null");

        return u -> condition.test(u) ? ifTrue.apply(u) : ifFalse.apply(u);
    }
}
