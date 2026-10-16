package com.emart.inventory_module.programm;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class NumberExample {


    public static void main(String[] args) {

        int data[]={10,21,4,6,7,10,12};
      Optional<Integer> val= Arrays.stream(data).boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst();
        System.out.println("Second Largest: "+val);

        Optional<Integer> smallest = Arrays.stream(data).boxed().sorted().skip(1).findFirst();
        System.out.println("Second Smallest: "+smallest);

       Set<Integer> dublicate= Arrays.stream(data).boxed().collect(Collectors.groupingBy(n->n,Collectors.counting()))
                .entrySet().stream().filter(entry->entry.getValue()>1).map(e->e.getKey()).collect(Collectors.toSet());
        System.out.println(dublicate);



    }
}
