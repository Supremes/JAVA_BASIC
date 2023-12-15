package org.dododo;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class JavaBasic {
    public static void main(String[] args) {
        testStream();
    }

    private static void testLambda() {
        List<String> names = Arrays.asList("name", "sex", "hobby");

        // with method reference -- static method
        names.forEach(System.out::println);
        names.forEach(name -> System.out.println(name));

        // with method reference -- instance method
        names.sort(String::compareTo);
        names.sort((a, b) -> a.compareTo(b));

        // with method reference -- constructor method
        Supplier<Map<String, String>> mm = () -> new HashMap<>();
        Supplier<Map<String, String>> supplier = HashMap::new;
    }

    // map filter todo: reduce
    private static void testStream() {
        List<String> names = Arrays.asList("dododo", "citrix", "winnie ");
        List<String> filteredNames =names.stream().filter(name -> name.startsWith("win")).map(String::toUpperCase).collect(Collectors.toList());
        System.out.println(filteredNames);
    }
}
