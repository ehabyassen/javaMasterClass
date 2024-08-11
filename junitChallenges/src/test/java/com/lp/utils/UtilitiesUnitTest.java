package com.lp.utils;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;

public class UtilitiesUnitTest {

    private Utilities utils;

    @Before
    public void setUp() {
        utils = new Utilities();
    }

    @Test
    public void test_that_everyNthChar_returns_null_if_null_array_is_passed() {
        char[] result = utils.everyNthChar(null, 1);
        assertThat(result)
                .as("The result should be null when null is passed.")
                .isEqualTo(null);
    }

    @Test
    public void test_that_everyNthChar_returns_input_array_if_array_length_is_less_than_n() {
        char[] input = {'A'};
        char[] result = utils.everyNthChar(input, 2);
        assertThat(result)
                .as("The result should be input array if the length is less than n.")
                .isEqualTo(input);
    }

    @Test
    public void test_that_everyNthChar_returns_an_array_of_every_2nd_char() {
        char[] input = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        char[] result = utils.everyNthChar(input, 2);
        char[] expected = {'B', 'D', 'F', 'H'};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_that_everyNthChar_does_not_return_extra_chars() {
        char[] input = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H'};
        char[] result = utils.everyNthChar(input, 3);
        char[] expected = {'C', 'F'};
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void test_that_removePairs_removes_consecutive_repeated_char() {
        String result = utils.removePairs("ABBCDEEF");
        assertThat(result).isEqualTo("ABCDEF");
    }

    @Test
    public void test_that_removePairs_does_not_remove_non_consecutive_repeated_char() {
        String result = utils.removePairs("ABCBDEF");
        assertThat(result).isEqualTo("ABCBDEF");
    }

    @Test
    public void test_that_removePairs_returns_empty_string_as_it_is() {
        String result = utils.removePairs("");
        assertThat(result).isEqualTo("");
    }

    @Test
    public void test_that_removePairs_returns_a_string_with_one_char_as_it_is() {
        String result = utils.removePairs("A");
        assertThat(result).isEqualTo("A");
    }

    @Test
    public void test_that_removePairs_returns_one_char_if_two_similar_chars_are_passed() {
        String result = utils.removePairs("AA");
        assertThat(result).isEqualTo("A");
    }

    @Test
    public void test_that_removePairs_returns_a_string_with_all_unique_chars_as_it_is() {
        String result = utils.removePairs("ABCD");
        assertThat(result).isEqualTo("ABCD");
    }

    @Test
    public void test_that_removePairs_returns_null_if_null_is_passed() {
        String result = utils.removePairs(null);
        assertThat(result)
                .as("The result should be null when null is passed.")
                .isEqualTo(null);
    }

    @Test
    public void test_converter_1() {
        int result = utils.converter(10, 5);
        assertThat(result).isEqualTo(300);
    }

    @Test
    public void test_that_converter_validates_b() {
        Throwable throwable = catchThrowable(() -> utils.converter(5, 0));
        assertThat(throwable)
                .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("b can not be 0 because the formula includes division by b");
    }

    @Test
    public void test_that_NullIfOddLength_returns_null_if_null_is_passed() {
        String result = utils.nullIfOddLength(null);
        assertThat(result)
                .as("The result should be null when null is passed.")
                .isEqualTo(null);
    }

    @Test
    public void test_that_NullIfOddLength_returns_null_for_a_string_with_add_length() {
        String result = utils.nullIfOddLength("A");
        assertThat(result)
                .as("The result should be null when a string with odd length is passed.")
                .isEqualTo(null);
    }

    @Test
    public void test_that_NullIfOddLength_returns_input_string_for_a_string_with_even_length() {
        String input = "AB";
        String result = utils.nullIfOddLength(input);
        assertThat(result).isEqualTo(input);
    }
}