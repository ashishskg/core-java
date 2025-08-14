package com.ashish.designpattern.strategy.collectionstrategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Create a list of integers
        List<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(2);
        numbers.add(8);
        numbers.add(1);

        // Sort the list using different strategies

        // Strategy 1: Natural order (ascending)
        Collections.sort(numbers);
        System.out.println("Sorted list (natural order): " + numbers);

        // Strategy 2: Reverse order (descending)
        Collections.sort(numbers, Collections.reverseOrder());
        System.out.println("Sorted list (reverse order): " + numbers);

        // Strategy 3: Custom comparator (even numbers first)
        Comparator<Integer> evenFirstComparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (o1 % 2 == 0 && o2 % 2 != 0) {
                    return -1;
                } else if (o1 % 2 != 0 && o2 % 2 == 0) {
                    return 1;
                } else {
                    return o1.compareTo(o2);
                }
            }
        };
        Collections.sort(numbers, evenFirstComparator);
        System.out.println("Sorted list (even numbers first): " + numbers);
    }
}

