package com.pluralsight.java.moreobjectoriented;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OptionalsDemo {
    private static abstract class MayBe<T> {
        public abstract <TResult> MayBe<TResult> map(Function<T, TResult> transform);

        public abstract <TResult> MayBe<TResult> flatMap(Function<T, MayBe<TResult>> transform);

        public abstract T orElse(T substitute);

        public abstract boolean isPresent();

        public abstract T get();
    }

    private static class Some<T> extends MayBe<T> {
        private T content;

        public Some(T content) {
            this.content = content;
        }

        @Override
        public <TResult> MayBe<TResult> map(Function<T, TResult> transform) {
            return new Some(transform.apply(this.content));
        }

        @Override
        public <TResult> MayBe<TResult> flatMap(Function<T, MayBe<TResult>> transform) {
            return transform.apply(this.content);
        }

        @Override
        public T orElse(T substitute) {
            return this.content;
        }

        @Override
        public boolean isPresent() {
            return true;
        }

        @Override
        public T get() {
            return this.content;
        }
    }

    private static class None<T> extends MayBe<T> {

        public None() {
        }

        @Override
        public <TResult> MayBe<TResult> map(Function<T, TResult> transform) {
            return new None<TResult>();
        }

        @Override
        public <TResult> MayBe<TResult> flatMap(Function<T, MayBe<TResult>> transform) {
            return new None<TResult>();
        }

        @Override
        public T orElse(T substitute) {
            return substitute;
        }

        @Override
        public boolean isPresent() {
            return false;
        }

        @Override
        public T get() {
            throw new IllegalArgumentException();
        }
    }

    private void display(MayBe<String> value) {
        System.out.println(value.map(String::toUpperCase).orElse("Nothing to show..."));
    }

    private void displayAsSquare(MayBe<String> value) {
        System.out.println();
        this.display(this.toSquare(value));
    }

    private MayBe<String> toSquare(MayBe<String> value) {
        return value.flatMap(this::toSquare);
    }

    private MayBe<String> toSquare(String value) {
        return this.trySqrt(value.length())
                .map(columns -> this.toMatrix(value, (int) Math.ceil(columns)));
    }

    private MayBe<Double> trySqrt(int value) {
        return value < 0 ? new None<Double>()
                : new Some(Math.sqrt((double) value));
    }

    private String toMatrix(String value, int columns) {
        return this.toMatrix(value, columns, (value.length() + columns - 1) / columns);
    }

    private String toMatrix(String value, int columns, int rows) {
        return IntStream.range(0, rows).map(row -> row * columns)
                .mapToObj(startIndex -> value.substring(startIndex, Math.min(startIndex + columns, value.length())))
                .collect(Collectors.joining(System.lineSeparator()));
    }

    public void run() {
        this.display(new None());
        this.display(new Some("Something"));
        this.display(new Some("Making your java code more object-oriented"));

        this.displayAsSquare(new None());
        this.displayAsSquare(new Some("Something"));
        this.displayAsSquare(new Some("Making your java code more object-oriented"));
    }

    public static void main(String[] args) {
        new OptionalsDemo().run();
    }
}
