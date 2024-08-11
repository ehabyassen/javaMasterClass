package com.lp.utils;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(Parameterized.class)
public class UtilitiesRemovePairsParameterizedTest {

    private final String input;
    private final String output;
    private final Utilities utils = new Utilities();

    public UtilitiesRemovePairsParameterizedTest(String input, String output) {
        this.input = input;
        this.output = output;
    }

    @Parameters(name = "input: {0} - output {1}")
    public static Collection<Object[]> testData() {
        return Arrays.asList(new Object[][]{
                {"ABCDEFF", "ABCDEF"},
                {"AB88EFFG", "AB8EFG"},
                {"11223345566", "123456"},
                {"ZYZQQB", "ZYZQB"},
                {"A", "A"}
        });
    }

    @Test
    public void test_removePairs() {
        assertThat(utils.removePairs(input)).isEqualTo(output);
    }
}
