package com.pluralsight.java.lambdaexpression.reductioncaveats;

import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class MainReduction {
    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        List<Integer> ints1 = Arrays.asList(0, 1, 2, 3, 4);
        List<Integer> ints2 = Arrays.asList(5, 6, 7, 8, 9);

//        Associative Operation
//        BinaryOperator<Integer> op = (i1, i2) -> i1 + i2;
//        BinaryOperator<Integer> op = (i1, i2) -> i1;

//        Non-Associative Operation
//        BinaryOperator<Integer> op = (i1, i2) -> (i1 + i2) * (i1 + i2);
//        BinaryOperator<Integer> op = (i1, i2) -> (i1 + i2) / 2;

//        Below is associative operation but have Non-Identity Element
//        If there is all negative element in list. It will give wrong result
        BinaryOperator<Integer> op = (i1, i2) -> Integer.max(i1, i2);

//        Parallel Way
//        int reduction1 = reduce(ints1, 0, op);
//        int reduction2 = reduce(ints2, 0, op);
//        int reduction = reduce(Arrays.asList(reduction1, reduction2), 0, op);

//        Singular Way
        int reduction = reduce(ints, 0, op);
        System.out.println("Reduction: " + reduction);
    }

    private static int reduce(
            List<Integer> values,
            int valueIfEmpty,
            BinaryOperator<Integer> reduction) {
        int result = valueIfEmpty;
        for (int value : values) {
            result = reduction.apply(result, value);
        }
        return result;
    }
}
