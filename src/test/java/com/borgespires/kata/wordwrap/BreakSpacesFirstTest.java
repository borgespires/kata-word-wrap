package com.borgespires.kata.wordwrap;

import org.junit.Test;

import static com.borgespires.kata.wordwrap.BreakSpacesFirst.wrap;
import static org.junit.Assert.assertEquals;

public class BreakSpacesFirstTest {

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
        assertEquals("other", wrap("other", 5));
    }

    @Test
    public void twoWordsLongerThanLimitShouldWrap() {
        assertEquals("word\nword", wrap("word word", 6));
    }

    @Test
    public void twoWordsShorterThanTheLimitDoNotWrap() {
        assertEquals("word word", wrap("word word", 11));
    }

    @Test
    public void threeWordsJustOverTheLimitShouldWrapAtSecondWord() {
        assertEquals("word word\nword", wrap("word word word", 11));
    }

    @Test
    public void fourWordsShorterThanTwiceTheLengthShouldWrapAtSecondWord() {
        assertEquals("word word\nword word", wrap("word word word word", 11));
    }

    @Test
    public void threeWordsEachLongerThanLimitShouldWrap() {
        assertEquals("word\nword\nword", wrap("word word word", 6));
    }

    @Test
    public void twoWordsTheFirstEndingAtTheLimit() {
        assertEquals("word\nword", wrap("word word", 4));
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
}