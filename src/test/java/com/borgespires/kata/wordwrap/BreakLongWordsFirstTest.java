package com.borgespires.kata.wordwrap;

import org.junit.Test;

import static com.borgespires.kata.wordwrap.BreakLongWordsFirst.wrap;
import static org.junit.Assert.assertEquals;

public class BreakLongWordsFirstTest {

    @Test
    public void wrapNullReturnsEmptyString() {
        assertEquals("", wrap(null, 10));
    }

    @Test
    public void wrapEmptyStringReturnsEmptyString() {
        // This test passes with no modification to the implementation.
        assertEquals("", wrap("", 10));
    }

    @Test
    public void oneShortWordDoesNotWrap() {
        assertEquals("word", wrap("word", 5));
    }

    @Test
    public void wordLongerThanLengthBreaksAtLength() {
        assertEquals("long\nword", wrap("longword", 4));
        assertEquals("longer\nword", wrap("longerword", 6));
    }

    @Test
    public void wordLongerThanTwiceLengthShouldBreakTwice() {
        assertEquals("very\nlong\nword", wrap("verylongword", 4));
    }

    @Test
    public void backto_twoWordsLongerThanLimitShouldWrap() {
        assertEquals("word\nword", wrap("word word", 6));
        assertEquals("wrap\nhere", wrap("wrap here", 6));
    }

    @Test
    public void threeWordsEachLongerThanLimitShouldWrap() {
        assertEquals("word\nword\nword", wrap("word word word", 6));
    }

    @Test
    public void backto_threeWordsJustOverTheLimitShouldWrapAtSecondWord() {
        assertEquals("word word\nword", wrap("word word word", 11));
    }

    /**
     * "All the lengths used in the tests have been unambiguously beyond the position of the breaking space."
     * "But what happens if we break right on the space."
     */
    @Test
    public void twoWordsTheFirstEndingAtTheLimit() {
        assertEquals("word\nword", wrap("word word", 4));
    }
}