package br.com.bb9leko.fundamentals;

import java.util.Arrays;
import java.util.List;

public class TestArrays {

    public static void main(String[] args) {

        List<String> listArray = Arrays.asList("Marcos", "Gabriel", "Luiza", "Ana", "","","","");
        listArray.stream()
                .filter(String::isEmpty)
                .toList()
                .forEach(System.out::println);

        listArray.forEach(System.out::println);

    }

}
