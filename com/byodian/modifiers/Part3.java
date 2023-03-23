package com.byodian.modifiers;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;

public class Part3<T> {
    private static final Part3<?> EMPTY = new Part3<>();
    private final T value;
    private Part3() {
        this.value = null;
    }

    public static <T> Part3<T> empty() {
        @SuppressWarnings("unchecked")
        Part3<T> t = (Part3<T>) EMPTY;
        return t;
    }

    private Part3 (T value) {
        this.value = Objects.requireNonNull(value);
    }

    public static <T> Part3<T> of(T value) {
        return new Part3<>(value);
    }

    public static <T> Part3<T> ofNullable(T value) {
        return value == null ? empty() : of(value);
    }

    public T get() {
        if (value == null) {
            throw new NoSuchElementException("No value present");
        }

        return value;
    }

    public boolean isPresent() {
        return value != null;
    }

    public void ifPresent(Consumer<? super T> consumer) {
        if (value != null)
            consumer.accept(value);
    }

    public static void main(String[] args) {
        String publicVar = Test.publicVar;
        int privateVar = Test.getPrivateVar();
        publicVar = "Hello Vue!";

        System.out.println(Test.publicVar);
        System.out.println(publicVar + privateVar);
    }
}
