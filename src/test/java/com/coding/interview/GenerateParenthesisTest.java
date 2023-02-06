package com.coding.interview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class GenerateParenthesisTest {

    private static final List<String> parenthesis1 = List.of("(())", "()()");
    private static final List<String> parenthesis2 = List.of("((()))", "(()())", "(())()", "()(())", "()()()");
    private static final GenerateParenthesis generator = new GenerateParenthesis();

    @Test
    public void test() {
        List<String> result = generator.generate(2);
        Assertions.assertEquals(result, parenthesis1);

        result = generator.generate(3);
        Assertions.assertEquals(result, parenthesis2);
    }
}
