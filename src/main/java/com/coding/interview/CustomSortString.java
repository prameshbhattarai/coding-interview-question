package com.coding.interview;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given two strings order and s. All the characters of order are unique and were sorted in some custom order previously.
 * <p>
 * Permute the characters of s so that they match the order that order was sorted. More specifically, if a character x occurs before a character y in order, then x should occur before y in the permuted string.
 * <p>
 * Return any permutation of s that satisfies this property.
 */
public class CustomSortString {


    /*
        Logic
        Create hash table of String s with frequency
        
        Now iterate the order and search for the character from order in the hash table
        and if found then append it to the string (with number of frequency)
        
        return the final string
        
        for example:
        
        order = "cba"
        s = "abcd"
        r = new StringBuilder();
        
        hash table of s with freq
        
        a - 1
        b - 1
        c - 1
        d - 1
        
        
        now iterate the order
        cba
        
            search c in the hash table

            found 1 time
            append c in the r
            remove c from the hash table

            search for b in the hash table
            
            found 1 time
            append b in the r
            remove  b from the hash table
            
            ... and so on...
            
            
        now we have inserted all the order char in the string builder
        now insert remaining character from the hash table
        
        loop the hash table and insert each value for freq time
        
        */
    public String sort(String order, String text) {

        Map<Character, Integer> lookup = new HashMap<>();
        StringBuilder result = new StringBuilder();


        // create hash table of the text with frequency
        for (Character c : text.toCharArray()) {
            if (lookup.containsKey(c)) {
                lookup.put(c, lookup.get(c) + 1);
            } else {
                lookup.put(c, 1);
            }
        }

        // now iterate the order string and create the result
        for (Character o : order.toCharArray()) {
            if (lookup.containsKey(o)) {
                // append char for number of frequency
                int i = lookup.get(o);
                while (i-- > 0) {
                    result.append(o);
                }
                // remove the order char from lookup
                lookup.remove(o);
                // why ??.. because we will again iterate the lookup to insert
                // remaining char from the text
            }
        }

        // append remaining char from the lookup
        for (Map.Entry<Character, Integer> iterator : lookup.entrySet()) {
            int freq = iterator.getValue();
            while (freq-- > 0) {
                result.append(iterator.getKey());
            }
        }

        return result.toString();
    }
}
