package com.emart.inventory_module.programm;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringExample {

    public static void dublicateCharacter(String str)
    {
        int count[] = new int [256];
        for(int i=0;i<=str.length()-1;i++)
        {
            count[str.charAt(i)]++;
        }

        for(int i=0;i<=count.length-1;i++)
        {
            if(count[i]>1)
            {
                System.out.println(count[i]+"- "+(char) i);
            }
        }
    }

    public static String frequencyChar(String str)
    {
        Map<Character,Long> hm=str.chars().mapToObj(ch->(char) ch).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        return hm.entrySet().stream().map(e->e.getKey()+"-"+e.getValue()).collect(Collectors.joining());
    }

    public static void main(String[] args) {

        dublicateCharacter("Hello");
        System.out.println(frequencyChar("Hello"));

    }


}
