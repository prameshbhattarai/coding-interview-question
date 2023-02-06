package com.coding.interview;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public List<String> generate(int n) {
        List<String> result = new ArrayList<>();
        generate(0, 0, n, "", result);
        return result;
    }

    private void generate(int left, int right, int n, String text, List<String> result) {
        System.out.println(text);
        // pair of parenthesis
        if (text.length() == n * 2) {
            result.add(text);
        } else {
            // generate left parenthesis
            if (left < n) generate(left + 1, right, n, text + "(", result);

            // generate right parenthesis
            if (right < left) generate(left, right + 1, n, text + ")", result);
        }

    }
}
